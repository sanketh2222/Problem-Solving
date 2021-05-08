package com.crio.xmeme.entity;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "Meme")
@Data
public class MemeEntity {

//    @Id
    @NonNull
    private String mid;

    @NonNull
    private  String name;

    @NonNull
    private  String url;

    @NonNull
    private  String caption;
}
