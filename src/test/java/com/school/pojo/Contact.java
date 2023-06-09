package com.school.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Contact{
    private String emailAddress;
    private String phone;
    private String permanentAddress;

}