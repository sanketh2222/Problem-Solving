package com.crio.xmeme.service;

import com.crio.xmeme.dto.Meme;
import com.crio.xmeme.repository.MemeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.inject.Provider;
import java.util.List;

@Service
//@Primary
public class MemeServiceImpl implements MemeServices {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Autowired
    private MemeRepository memeRepository;

    @Override
    public String postMeme(Meme meme) {
//        memeRepository.findById(m)
        List<Meme> memesList = memeRepository.findAll(Example.of(meme));// search with object
        if (memesList.size() !=0){
            return "001";
        }
        mongoTemplate.save(meme);
        long total = memeRepository.findAll().stream().count();
        return "{id: "+total+"}";
    }

    @Override
    public Meme getMeme(String id) {
        return null;
    }

    @Override
    public List<Meme> getMemes() {
        return null;
    }
}
