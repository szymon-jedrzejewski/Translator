package com.sj.sentence_translator.services;

import com.sj.sentence_translator.exceptions.SentenceTranslationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SentenceTranslatorTest {

    @Test
    public void shouldPassIfReturnTranslatedSentence() throws SentenceTranslationException {
        SentenceTranslator sentenceTranslator = new SentenceTranslator(new JsonDictionary());

        String sentenceToTranslate = "Ala ma kota jesteś sterem białym żołnierzem nosisz spodnie więc walcz";
        String expected = "Alice has a cat you are the helm white soldier wear trousers so fight";

        assertEquals(expected, sentenceTranslator.translate(sentenceToTranslate));
    }

    @Test
    public void shouldFailIfCanNotTranslateSentence() {
        SentenceTranslator sentenceTranslator = new SentenceTranslator(new JsonDictionary());
        assertThrows(NullPointerException.class, () ->
        { sentenceTranslator.translate(null); });
    }

}