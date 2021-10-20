package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import com.revature.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Flashcard;
import com.revature.models.Quiz;
import com.revature.repositories.QuizRepository;

@RestController
@RequestMapping("/quiz")
public class QuizController {

//	@Autowired
	private QuizRepository quizDao;
	
//	@Autowired
	private RestTemplate restTemplate;
	
	public QuizController(RestTemplate template) {
		this.restTemplate = template;
	}
	
	@Autowired
	public void setQuizDao(QuizRepository dao) {
		this.quizDao = dao;
	}
	
	@GetMapping
	public ResponseEntity<List<Quiz>> findAll() {
		List<Quiz> all = quizDao.findAll();
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Quiz> findById(@PathVariable("id") int id) {
		Optional<Quiz> optional = quizDao.findById(id);
		
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Quiz insert(@RequestBody Quiz quiz) {
		int id = quiz.getId();
		
		if(id != 0) {
			throw new BadRequestException("Invalid id provided for new resource.");
		}
		
		quizDao.save(quiz);
		return quiz;
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/cards")
	public ResponseEntity<List<Flashcard>> getCards() {
		List<Flashcard> all = restTemplate.getForObject("http://flashcard-service/flashcard", List.class);
		
		if(all.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok(all);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	public void handleBadRequest(BadRequestException e) {}

}
