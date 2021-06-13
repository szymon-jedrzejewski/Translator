package com.sj.sentence_translator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InMemoryDatabase {
    private static final Logger logger = LogManager.getLogger(InMemoryDatabase.class);
    private String filePath;
    private String content;

    public InMemoryDatabase() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(new FileReader("src/main/resources/config/in_memory_db_config.json"));
            filePath = (String) json.get("filePath");
            readFile();
        } catch (ParseException | IOException e) {
            logger.error(e.getMessage());
        }

    }

    public void readFile() {
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public String getContent() {
        return content;
    }
}
