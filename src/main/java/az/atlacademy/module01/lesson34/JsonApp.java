package az.atlacademy.module01.lesson34;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonApp {

    public static final String RESOURCE = "src/main/java/az/atlacademy/module01/lesson34/resource/";
    public static final Path PATH = Paths.get(RESOURCE + "person.txt");

    public static void main(String[] args) {
        Person person = new Person("Bob", "Doe", 35);

        String personJson = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            personJson = objectMapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(personJson);


        try {
            Files.writeString(PATH, personJson);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String string = Files.readString(PATH);
            System.out.println(string);
            List<String> strings = Files.readAllLines(PATH);
            System.out.println(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
