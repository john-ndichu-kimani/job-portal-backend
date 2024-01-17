package com.john.job_connect.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "jobPosts")
public class Post {
    @Id
    private String id;
    private String title;
    private String company;
    private String location;
    private String[] skills_required;
    private int experience_required;
    private int salary;
}
