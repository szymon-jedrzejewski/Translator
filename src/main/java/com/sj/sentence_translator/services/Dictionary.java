package com.sj.sentence_translator.services;

import com.sj.sentence_translator.exceptions.WordTranslationException;

public interface Dictionary {
    String getTranslation(String word) throws WordTranslationException;
}
