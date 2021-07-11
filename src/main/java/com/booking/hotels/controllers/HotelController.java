package com.booking.hotels.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotels.entities.Hotel;
import com.booking.hotels.services.HotelService;
import com.sun.istack.NotNull;

import lombok.RequiredArgsConstructor;

@RestController // localHost:8080/hotel
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

	private final HotelService hotelService;

	@GetMapping
	public ResponseEntity<?> getAllHotels() {
		return new ResponseEntity<>(hotelService.getAllHotels(), HttpStatus.OK); // 200
	}

	@PostMapping
	public ResponseEntity<?> createHotel(@RequestBody Hotel hotel) {
		hotelService.createNewHotel(hotel);
		return new ResponseEntity<>(HttpStatus.CREATED); // 201
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<?> getHotelById(@PathVariable @NotNull Long hotelId) {
		return new ResponseEntity<>(hotelService.getHotelById(hotelId), HttpStatus.OK); // 200
	}

	@GetMapping("/city/{cityId}")
	public ResponseEntity<?> getHotelsByCity(@PathVariable @NotNull Long cityId) {
		return new ResponseEntity<>(hotelService.getHotelsByCity(cityId), HttpStatus.OK); // 200
	}

	@DeleteMapping("/{hotelId}")
	public ResponseEntity<?> deleteHotel(@PathVariable Long hotelId) {
		hotelService.deleteHotel(hotelId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
}
