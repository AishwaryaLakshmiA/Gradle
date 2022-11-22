package org.example;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.time.Clock;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Employee[] personList = Stream.of(
                        new Employee(1, "Ken", 60000),
                        new Employee(2, "Smith", 75000),
                        new Employee(3, "Tej", 21000 ),
                        new Employee(4, "Andrews", 55000))
                .toArray(Employee[]::new);
        String arrayToJson = null;

        try {
            arrayToJson = objectMapper.writeValueAsString(personList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println("JAVA object to Json: \n");
        System.out.println(arrayToJson);
    }
}