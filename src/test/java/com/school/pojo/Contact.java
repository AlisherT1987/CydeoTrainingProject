
package com.school.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "contactId",
    "phone",
    "emailAddress",
    "permanentAddress"
})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

    @JsonProperty("Mobile number")
    public String phone;
    @JsonProperty("Email")
    public String emailAddress;
    @JsonProperty("Permanent Address")
    public String permanentAddress;

}
