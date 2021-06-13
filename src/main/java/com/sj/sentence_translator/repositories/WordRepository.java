package com.sj.sentence_translator.repositories;

import com.sj.sentence_translator.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
    boolean existsByContent(String content);
    Word findByContent(String content);
}
