package com.booking.hotels.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotels.services.HotelSearchService;
import com.sun.istack.NotNull;

import lombok.RequiredArgsConstructor;

@RestController // localHost:8080/search
@RequestMapping("/search")
@RequiredArgsConstructor
public class HotelSearchController {

	private final HotelSearchService hotelSearchService;

	@GetMapping("/{cityId}")
	public ResponseEntity<?> getClosestHotelsByCity(@PathVariable @NotNull Long cityId) {
		return new ResponseEntity<>(hotelSearchService.searchClosestHotelsByCity(cityId), HttpStatus.OK); // 200
	}
}
