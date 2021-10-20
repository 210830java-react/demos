package com.revature.intercom;

import com.revature.models.Flashcard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("flashcard")
@FeignClient(name = "flashcard-service")
public interface FlashcardClient {

    @GetMapping
    ResponseEntity<List<Flashcard>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<Flashcard> findById(@PathVariable("id") int id);

}
