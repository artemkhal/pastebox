package ru.khaliullov.pastebox.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.khaliullov.pastebox.api.PasteboxRequest;
import ru.khaliullov.pastebox.api.responce.PasteboxResponse;
import ru.khaliullov.pastebox.api.responce.PasteboxUrlResponse;
import ru.khaliullov.pastebox.service.PasteboxService;

import java.util.Collection;

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
