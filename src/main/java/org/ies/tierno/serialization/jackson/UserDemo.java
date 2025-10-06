package org.ies.tierno.serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class UserDemo {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .enable(SerializationFeature.INDENT_OUTPUT); // pr

    public static void main(String[] args) throws JsonProcessingException {
        var user = new User("valor", List.of("a"));

        var json = MAPPER.writeValueAsString(user);

        var back = MAPPER.readValue(json, User.class);
        log.info(back);
    }
}
