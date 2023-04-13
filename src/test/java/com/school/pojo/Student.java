
package com.school.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "studentId",
    "firstName",
    "lastName",
    "batch",
    "joinDate",
    "birthDate",
    "password",
    "subject",
    "gender",
    "admissionNo",
    "major",
    "section",
    "contact",
    "company"
})

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

    @JsonProperty("studentId")
    public Integer studentId;
    @JsonProperty("Firstname")
    public String firstName;
    @JsonProperty("Lastname")
    public String lastName;
    @JsonProperty("Batch")
    public Integer batch;
    @JsonProperty("Joining Date")
    public String joinDate;
    @JsonProperty("Birth Date")
    public String birthDate;
    @JsonProperty("Subject")
    public String subject;
    @JsonProperty("Gender")
    public String gender;
    @JsonProperty("Major")
    public String major;

    @JsonProperty("contact")
    public Contact contact;
    @JsonProperty("company")
    public Company company;

}
