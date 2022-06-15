package ru.khaliullov.pastebox.api.responce;

import lombok.Data;

@Data
public class PasteboxResponse {
    private final String data;
    private final boolean isPublic;
}
