package com.sj.sentence_translator.services;

import com.sj.sentence_translator.InMemoryDatabase;
import com.sj.sentence_translator.exceptions.WordTranslationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class JsonDictionary implements Dictionary {
    private static final Logger logger = LogManager.getLogger(InMemoryDatabase.class);
    private final InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
    private final JSONParser parser;

    public JsonDictionary() {
        parser = new JSONParser();
    }

    @Override
    public String getTranslation(String wordToTranslate) throws WordTranslationException {
        try {
            JSONObject object = (JSONObject) parser.parse(inMemoryDatabase.getContent());
            return (String) object.get(wordToTranslate);
        } catch (ParseException e) {
            logger.error(e.getMessage());
        }
        throw new WordTranslationException("Problem during parsing json");
    }
}