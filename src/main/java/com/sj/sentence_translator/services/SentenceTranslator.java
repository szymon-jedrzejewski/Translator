package com.sj.sentence_translator.services;

import com.sj.sentence_translator.InMemoryDatabase;
import com.sj.sentence_translator.exceptions.SentenceTranslationException;
import com.sj.sentence_translator.exceptions.WordTranslationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SentenceTranslator {
    private static final Logger logger = LogManager.getLogger(InMemoryDatabase.class);
    private final Dictionary dictionary;

    public SentenceTranslator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String translate(String isQuote, String sentence) throws SentenceTranslationException {
        try {
            String[] words = sentence.split(" ");
            StringBuilder translatedSentence = new StringBuilder();

            for (String word : words) {
                if (isQuote.equals("true")) {
                    translatedSentence.append("'").append(dictionary.getTranslation(word)).append("' ");
                } else {
                    translatedSentence.append(dictionary.getTranslation(word)).append(" ");
                }
            }

            return translatedSentence.toString().trim();
        } catch (WordTranslationException e) {
            logger.error(e.getMessage());
        }
        throw new SentenceTranslationException("There was a problem during translating sentence");
    }
}

