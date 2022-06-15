package ru.khaliullov.pastebox.service;

import ru.khaliullov.pastebox.api.responce.PasteboxResponse;
import ru.khaliullov.pastebox.api.responce.PasteboxUrlResponse;
import ru.khaliullov.pastebox.api.PasteboxRequest;

import java.util.List;

public interface PasteboxService {
    PasteboxResponse getByHash(String hash);
    List<PasteboxResponse> getFirstPublicPasteboxes();
    PasteboxUrlResponse create(PasteboxRequest request);
}
