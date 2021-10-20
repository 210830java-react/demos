package com.revature.intercom;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.models.Flashcard;

@RequestMapping("flashcard")
@FeignClient(name = "flashcard-service")
public interface FlashcardClient {

    @GetMapping
    List<Flashcard> findAll();

    @GetMapping("/{id}")
    Optional<Flashcard> findById(@PathVariable("id") int id);
}
