package com.mongo.proj.full.text.search;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Profile {

    @Id
    private String id;
    private String name;

    @TextIndexed
    private String title;

    @TextIndexed(weight = 2)
    private String aboutMe;

    public Profile(String name, String title, String aboutMe) {
        this.name = name;
        this.title = title;
        this.aboutMe = aboutMe;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                '}';
    }
}
