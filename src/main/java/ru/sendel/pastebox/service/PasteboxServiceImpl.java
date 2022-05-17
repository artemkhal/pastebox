package ru.sendel.pastebox.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import ru.sendel.pastebox.api.PasteboxRequest;
import ru.sendel.pastebox.api.PublicStatus;
import ru.sendel.pastebox.api.responce.PasteboxResponse;
import ru.sendel.pastebox.api.responce.PasteboxUrlResponse;
import ru.sendel.pastebox.repository.PasteboxEntity;
import ru.sendel.pastebox.repository.PasteboxRepository;

import javax.websocket.server.ServerEndpoint;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app")
public class PasteboxServiceImpl implements PasteboxService {

    private String host = "http://abc.ru";
    private int publicListSize = 10;
    private final PasteboxRepository repository;
    private AtomicInteger idGenerator = new AtomicInteger(0);

    @Override
    public PasteboxResponse getByHash(String hash) {
        PasteboxEntity pasteboxEntity = repository.getByHash(hash);
        return new PasteboxResponse(pasteboxEntity.getData(), pasteboxEntity.isPublic());
    }

    @Override
    public List<PasteboxResponse> getFirstPublicPasteboxes() {
        List<PasteboxEntity> list = repository.getListOfPublicAndAlive(publicListSize);
        return list.stream().map(pasteboxEntity ->
            new PasteboxResponse(pasteboxEntity.getData(), pasteboxEntity.isPublic()))
                .collect(Collectors.toList());
    }

    @Override
    public PasteboxUrlResponse create(PasteboxRequest request) {

           int hash = generateId();
        PasteboxEntity pasteboxEntity = new PasteboxEntity();
        pasteboxEntity.setData(request.getData());
        pasteboxEntity.setId(hash);
        pasteboxEntity.setHash(Integer.toHexString(hash));
        pasteboxEntity.setPublic(request.getPublicStatus() == PublicStatus.PUBLIC);
        pasteboxEntity.setLifeTime(LocalDateTime.now().plusSeconds(request.getExpirationTimeSeconds()));
        repository.add(pasteboxEntity);

        return new PasteboxUrlResponse(host + "/" +pasteboxEntity.getHash());

    }

    private int generateId() {
        return idGenerator.getAndIncrement();
    }
}
