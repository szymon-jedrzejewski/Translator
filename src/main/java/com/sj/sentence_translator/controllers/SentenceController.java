package com.sj.sentence_translator.controllers;

import com.sj.sentence_translator.exceptions.SentenceTranslationException;
import com.sj.sentence_translator.services.SentenceTranslator;
import com.sj.sentence_translator.services.WordCounter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/translate")
public class SentenceController {

    private SentenceTranslator sentenceTranslator;
    private WordCounter wordCounter;

    public SentenceController(SentenceTranslator sentenceTranslator, WordCounter wordCounter) {
        this.sentenceTranslator = sentenceTranslator;
        this.wordCounter = wordCounter;
    }

    @PostMapping("/sentence")
    public String translateSentenceNoQuotes(@RequestBody String sentence) throws SentenceTranslationException {
        wordCounter.countWord(sentence);
        return sentenceTranslator.translate(sentence);
    }
}
