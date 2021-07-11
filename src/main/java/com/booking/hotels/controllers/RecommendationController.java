package com.booking.hotels.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotels.services.RecommendationService;

import lombok.RequiredArgsConstructor;

@RestController // localHost:8080/rating
@RequestMapping("/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

	private final RecommendationService recommendationService;

	@GetMapping()
	public ResponseEntity<?> getBestHotelRecommendationScore() {
		return new ResponseEntity<>(recommendationService.getBestHotelRecommendationScore(), HttpStatus.OK); // 200
	}
}
