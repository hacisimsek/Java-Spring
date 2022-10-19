package com.springboot.restclient.entity;

import lombok.Data;

@Data
public class Result {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private String image;
    private String[] episode;
    private String url;
    private String created;
}
