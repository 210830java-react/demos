package com.revature.intercom;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.models.Flashcard;

@FeignClient(name = "flashcard")
public interface FlashcardClient {

    @GetMapping
    List<Flashcard> findAll();

    @GetMapping("/{id}")
    Optional<Flashcard> findById(@PathVariable("id") int id);
}
