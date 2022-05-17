package ru.sendel.pastebox.api.responce;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PasteboxUrlResponse {
    private final String url;
}
