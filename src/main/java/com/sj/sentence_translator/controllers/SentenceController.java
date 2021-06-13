package com.sj.sentence_translator.controllers;

import com.sj.sentence_translator.exceptions.SentenceTranslationException;
import com.sj.sentence_translator.models.Word;
import com.sj.sentence_translator.services.SentenceTranslator;
import com.sj.sentence_translator.services.WordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/translate")
public class SentenceController {

    private SentenceTranslator sentenceTranslator;
    private WordService wordService;

    public SentenceController(SentenceTranslator sentenceTranslator, WordService wordService) {
        this.sentenceTranslator = sentenceTranslator;
        this.wordService = wordService;
    }

    @PostMapping("/sentence")
    public String translateSentenceNoQuotes(@RequestBody String sentence) throws SentenceTranslationException {
        wordService.countWord(sentence);
        return sentenceTranslator.translate(sentence);
    }

    @GetMapping("/ranking")
    public List<Word> getWordUsageRanking() {
        return wordService.getWordsRanking();
    }
}
