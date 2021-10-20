package com.revature.models;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double grade;
	private String name;
	
	@ElementCollection
	private Set<Integer> cards;
	
	public boolean addCard(Integer id) {
		return cards.add(id);
	}
	
	public boolean removeCard(Integer id) {
		return cards.remove(id);
	}
}
