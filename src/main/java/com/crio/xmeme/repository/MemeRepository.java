package com.crio.xmeme.repository;

import com.crio.xmeme.dto.Meme;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MemeRepository extends MongoRepository<Meme,Long> {

    @Query("{'name' :?0}")
    public void findMeme(String name, String url, String caption);
}
