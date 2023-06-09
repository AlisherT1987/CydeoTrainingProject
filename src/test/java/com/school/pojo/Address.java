package com.school.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Address{
    private String city;
    private String street;
    private int zipCode;
    private String state;
}