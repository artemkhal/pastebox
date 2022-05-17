package ru.sendel.pastebox.repository;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PasteboxEntity {
    private int id;
    private String data;
    private String hash;
    private LocalDateTime lifeTime;
    private boolean isPublic;
}
