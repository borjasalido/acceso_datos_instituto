package org.ies.tierno.serialization.jackson;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // omite null
public class User {
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_EMPTY) // omite lista vacía
    private List<String> tags;

    @JsonCreator
    public User(@JsonProperty("phone") String phone, @JsonProperty("tags")  List<String> tags) {
        this.phone = phone;
        this.tags = tags;
    }
}