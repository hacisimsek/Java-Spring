package com.haydikodlayal.m.springelasticsearchexample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    @Field(name = "name" , type = FieldType.Text)
    private String name;
    @Field(name = "surname" , type = FieldType.Text)
    private String surname;
    @Field(name = "email" , type = FieldType.Text)
    private String email;
    @Field(name = "password" , type = FieldType.Text)
    private String password;
}
