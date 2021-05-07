package com.crio.xmeme.entity;

import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Meme")
public class MemeEntity {

    @Id
    private String id;

    @NonNull
    private  String name;

    @NonNull
    private  String url;

    @NonNull
    private  String caption;
}
