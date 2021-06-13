package com.sj.sentence_translator.services;

import com.sj.sentence_translator.exceptions.WordTranslationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonDictionaryTest {

    @Test
    public void shouldPassIfReturnAla() throws WordTranslationException {
        Dictionary jsonDictionary = new JsonDictionary();
        assertEquals("Alice", jsonDictionary.getTranslation("Ala"));
    }

    @Test
    public void shouldPassIfReturnCat() throws WordTranslationException {
        Dictionary jsonDictionary = new JsonDictionary();
        assertEquals("a cat", jsonDictionary.getTranslation("kota"));

    }

    @Test
    public void shouldReturnNullIfThereIsNoSuchWord() throws WordTranslationException {
        Dictionary jsonDictionary = new JsonDictionary();
        assertNull(jsonDictionary.getTranslation(""));
    }

}