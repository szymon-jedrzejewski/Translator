package com.sj.sentence_translator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryDatabaseTest {
    @Test
    public void shouldPassIfContentOfTheFileIsNotNull() {
        InMemoryDatabase inMemoryDatabase = new InMemoryDatabase();
        assertNotNull(inMemoryDatabase.getContent());
    }
}