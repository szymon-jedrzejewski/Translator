package com.sj.sentence_translator.services;

import com.sj.sentence_translator.exceptions.SentenceTranslationException;
import com.sj.sentence_translator.exceptions.WordTranslationException;
import org.springframework.stereotype.Service;

@Service
public class SentenceTranslator {

    private final Dictionary jsonDictionary;

    public SentenceTranslator(Dictionary jsonDictionary) {
        this.jsonDictionary = jsonDictionary;
    }

    public String translate(String sentence) throws SentenceTranslationException {
        try {
            String[] words = sentence.split(" ");
            StringBuilder translatedSentence = new StringBuilder();

            for (String word : words) {
                translatedSentence.append(jsonDictionary.getTranslation(word)).append(" ");
            }

            return translatedSentence.toString().trim();
        } catch (WordTranslationException e) {
            e.printStackTrace();
        }
        throw new SentenceTranslationException("There was a problem during translating sentence");
    }
}

