package ru.sendel.pastebox.service;

import ru.sendel.pastebox.api.PasteboxRequest;
import ru.sendel.pastebox.api.responce.PasteboxResponse;
import ru.sendel.pastebox.api.responce.PasteboxUrlResponse;

import java.util.List;

public interface PasteboxService {
    PasteboxResponse getByHash(String hash);
    List<PasteboxResponse> getFirstPublicPasteboxes();
    PasteboxUrlResponse create(PasteboxRequest request);
}
