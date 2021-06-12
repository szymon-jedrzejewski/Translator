package com.sj.sentence_translator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String content;
    private int numberOfTranslations;

    public Word() {
    }

    public Word(String content, int numberOfTranslations) {
        this.content = content;
        this.numberOfTranslations = numberOfTranslations;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String word) {
        this.content = word;
    }

    public int getNumberOfTranslations() {
        return numberOfTranslations;
    }

    public void setNumberOfTranslations(int numberOfTranslations) {
        this.numberOfTranslations = numberOfTranslations;
    }
}
