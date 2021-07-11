package com.booking.hotels.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotels.entities.City;
import com.booking.hotels.services.CityService;

import lombok.RequiredArgsConstructor;

@RestController // localHost:8080/city
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

	private final CityService cityService;

	@GetMapping
	public ResponseEntity<?> getAllCities() {
		return new ResponseEntity<>(cityService.getAllCities(), HttpStatus.OK); // 200
	}

	@PostMapping
	public ResponseEntity<?> createCity(@RequestBody City city) {
		cityService.createCity(city);
		return new ResponseEntity<>(HttpStatus.CREATED); // 201
	}
}
