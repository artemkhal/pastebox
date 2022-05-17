package ru.sendel.pastebox.api.responce;

import lombok.Data;
import ru.sendel.pastebox.api.PublicStatus;

@Data
public class PasteboxResponse {
    private final String data;
    private final boolean isPublic;
}
