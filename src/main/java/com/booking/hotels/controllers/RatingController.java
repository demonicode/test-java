package com.booking.hotels.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotels.services.RatingService;

import lombok.RequiredArgsConstructor;

@RestController // localHost:8080/rating
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {

	private final RatingService ratingService;

	@GetMapping("/city/{cityId}")
	public ResponseEntity<?> getRatingByCity(@PathVariable Long cityId) {
		return new ResponseEntity<>(ratingService.getRatingAverage(cityId), HttpStatus.OK); // 200
	}
}
