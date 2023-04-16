package com.school.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Student{
    
    private String firstName;
    private String lastName;
    private String joinDate;
    private String subject;
    private String gender;
    private String birthDate;
    private String major;
    private int batch;

    private Contact contact;
    private Company company;

}  
