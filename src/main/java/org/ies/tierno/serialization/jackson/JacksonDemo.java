package org.ies.tierno.serialization.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.log4j.Log4j;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

@Log4j
public class JacksonDemo {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .setPropertyNamingStrategy(PropertyNamingStrategies.SnakeCaseStrategy.INSTANCE)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(SerializationFeature.INDENT_OUTPUT); // pretty

    public static void main(String[] args) throws Exception {
        Person p = new Person("1","Alice", LocalDate.of(1990,5,2), "secret", List.of("admin","beta"));

        // To String
        String json = MAPPER.writeValueAsString(p);
        System.out.println(json);

        // To File
        Path path = Path.of("person.json");
        MAPPER.writeValue(path.toFile(), p);

        // From String
        Person back = MAPPER.readValue(json, Person.class);

        // List<Person>
        List<Person> people = List.of(
                p,
                new Person("2","Bob", java.time.LocalDate.of(1985,1,20), null, List.of())
        );
        Path peoplePath = Path.of("people.json");
        MAPPER.writeValue(peoplePath.toFile(), people);
        List<Person> backList = MAPPER.readValue(peoplePath.toFile(), new TypeReference<List<Person>>() {});
        log.info(backList);
    }
}