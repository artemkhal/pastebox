package ru.sendel.pastebox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.sendel.pastebox.api.PasteboxRequest;
import ru.sendel.pastebox.api.responce.PasteboxResponse;
import ru.sendel.pastebox.api.responce.PasteboxUrlResponse;
import ru.sendel.pastebox.service.PasteboxService;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class PasteBoxController {

    private final PasteboxService pasteboxService;



    @GetMapping("/{hash}")
    public PasteboxResponse getByHash(@PathVariable String hash) {
        return pasteboxService.getByHash(hash);
    }

    @GetMapping("/")
    public Collection<PasteboxResponse> getPublicPasteList() {
        return pasteboxService.getFirstPublicPasteboxes();
    }
    @PostMapping("/")
    public PasteboxUrlResponse add(@RequestBody PasteboxRequest request){
        return pasteboxService.create(request);
    }

}
