package com.school.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Company{
    private String companyName;
    private String title;
    private String startDate;
    private Address address;
}