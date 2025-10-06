package org.ies.tierno.serialization.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.List;

public class JacksonXmlDemo {
    private static final ObjectMapper MAPPER = new XmlMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(SerializationFeature.INDENT_OUTPUT); // pretty
    public static void main(String[] args) throws Exception {

        Person p = new Person("1","Alice", LocalDate.now(), "Sandia4you", List.of("admin","beta"));

        String xmlStr = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(p);
        System.out.println(xmlStr);

        Person back = MAPPER.readValue(xmlStr, Person.class);
        System.out.println(back.getName());
    }
}