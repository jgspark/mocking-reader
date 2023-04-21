package org.jgspark.reader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Reader {

    public static <T> T readJson(String path, Class<T> type) {

        File jsonFile = null;

        try {
            jsonFile = new ClassPathResource(path).getFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String fileString = null;

        try {
            fileString = new String(Files.readAllBytes(jsonFile.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        try {
            return objectMapper.readValue(fileString, type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
