package com.crio.xmeme.controller;

import com.crio.xmeme.dto.Meme;
import com.crio.xmeme.service.MemeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class MemeController {

    @Autowired
    MemeServices memeServices;

    public final String ENDPOINT = "/memes/";

    @GetMapping(ENDPOINT)
    private ResponseEntity<List<Meme>> getMemes(){

        return null;
    }

    @PostMapping(ENDPOINT)
    private ResponseEntity<String> postMeme(@RequestBody Meme meme){
        String resp = memeServices.postMeme(meme);

        if ( resp.equals("001")){
            throw  new ResponseStatusException(HttpStatus.CONFLICT,"MEME EXISTS",null);
        }
//        String Response = "{id:"+""+resp+"}";
        return ResponseEntity.ok(resp);
    }

    @GetMapping(ENDPOINT+"/id")
    private  ResponseEntity<Meme> getMemeById(@PathVariable String id){
        return null;
    }
}
