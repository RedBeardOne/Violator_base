package com.demo.violations.functional;

import com.demo.violations.data.Violation;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Read {
    private File file;


    public List<Violation> getAllRecords(File file) throws IOException {
        byte[] data;
        List<Violation> listViolations;
        data = Files.readAllBytes(Paths.get(String.valueOf(file)));
        ObjectMapper objectMapper = new ObjectMapper();
        return listViolations = objectMapper.readValue(file, new TypeReference<List<Violation>>() {
        });
    }
}
