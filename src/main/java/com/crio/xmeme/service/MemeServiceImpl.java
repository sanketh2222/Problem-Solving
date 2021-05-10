package com.crio.xmeme.service;

import com.crio.xmeme.dto.Meme;
import com.crio.xmeme.exceptions.MemeAlreadyExists;
import com.crio.xmeme.exceptions.MemeNotFoundException;
import com.crio.xmeme.repository.MemeRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.inject.Provider;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@Primary
@Slf4j
public class MemeServiceImpl implements MemeServices {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Autowired
    private MemeRepository memeRepository;

    @Override
    public String postMeme(Meme meme) {
        List<Meme> memesList = memeRepository.findAll(Example.of(meme));// search with object
        if (memesList.size() !=0){
            throw  new MemeAlreadyExists(HttpStatus.CONFLICT,"Meme Already Exists");
        }
        
        
        long total = memeRepository.findAll().stream().count();
        meme.setMid(total);
        mongoTemplate.save(meme);
        return Long.toString(total);
    }

    @Override
    public Meme getMeme(String mid) {
        try{
            Optional<Meme> meme = memeRepository.findByMemeId(mid);
            return meme.get();
        }catch (Exception e){
            throw new MemeNotFoundException(HttpStatus.NOT_FOUND,"Meme doess not exiist");
        }
        

        // Meme meme = mapper.map(memeEntity,Meme.class);
        
    }

    @Override
    public List<Meme> getMemes() {
        // List<Meme> memeList =   memeRepository.findAll().stream().limit(100).collect(Collectors.toList());
        List<Meme> memeList1 =  memeRepository.findAll().stream().sorted(Comparator.comparing(Meme::getMid)
                    .reversed()).limit(100).collect(Collectors.toList());
        // memeRepository.findAll().sort(c);
        // List<Meme> finalList = memeList.stream().filter(meme -> 
        //         (Integer.parseInt(meme.getMid()) <= 100)).collect(Collectors.toList());
        log.info("len of meme list is "+memeList1.size());
        return memeList1;
    }
}
