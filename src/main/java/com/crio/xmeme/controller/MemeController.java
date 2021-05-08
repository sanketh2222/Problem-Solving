package com.crio.xmeme.controller;

import com.crio.xmeme.dto.Meme;
import com.crio.xmeme.service.MemeServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MemeController {

    @Autowired
    MemeServices memeServices;

    public final String ENDPOINT = "/memes/";

    @GetMapping(ENDPOINT)
    private ResponseEntity<List<Meme>> getMemes() {
        List<Meme> memes = memeServices.getMemes();
        return ResponseEntity.ok(memes);
    }

    @PostMapping(ENDPOINT)
    private ResponseEntity<String> postMeme(@RequestBody Meme meme) {

        String resp = memeServices.postMeme(meme);
        String Response = "{\"id\":\""+resp+"\"}";
        return ResponseEntity.ok(Response);
    }

    @GetMapping(ENDPOINT + "/{id}")
    private ResponseEntity<Meme> getMemeById(@PathVariable String id) {
        Meme meme = memeServices.getMeme(id);
        return ResponseEntity.ok(meme);
    }
}
