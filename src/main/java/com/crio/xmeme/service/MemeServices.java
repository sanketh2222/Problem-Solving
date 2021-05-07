package com.crio.xmeme.service;


import com.crio.xmeme.dto.Meme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemeServices {

    public String postMeme(Meme meme);

    public Meme getMeme(String id);

    public List<Meme> getMemes();

//    public Meme saveMeme();
}
