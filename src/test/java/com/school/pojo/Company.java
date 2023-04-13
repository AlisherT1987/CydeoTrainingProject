
package com.school.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "companyId",
    "companyName",
    "title",
    "startDate",
    "address"
})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {

    @JsonProperty("Company Name")
    public String companyName;
    @JsonProperty("Title")
    public String title;
    @JsonProperty("Start Date")
    public String startDate;
    @JsonProperty("address")
    public Address address;

}
