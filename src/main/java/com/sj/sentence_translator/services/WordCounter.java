package com.sj.sentence_translator.services;

import com.sj.sentence_translator.models.Word;
import com.sj.sentence_translator.repositories.WordRepository;
import org.springframework.stereotype.Service;

@Service
public class WordCounter {

    private WordRepository repository;

    public WordCounter(WordRepository repository) {
        this.repository = repository;
    }

    public void countWord(String sentence) {
        for (String word : sentence.split(" ")) {
            if (repository.existsByContent(word)) {
                Word wordToUpdate = repository.findByContent(word);
                int updatedValueOfTranslations = wordToUpdate.getNumberOfTranslations() + 1;
                wordToUpdate.setNumberOfTranslations(updatedValueOfTranslations);
                repository.save(wordToUpdate);
            } else {
                Word newWord = new Word(word, 1);
                repository.save(newWord);
            }
        }
    }
}
