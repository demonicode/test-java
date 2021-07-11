package com.booking.hotels.services;

import java.util.List;

import com.booking.hotels.entities.Hotel;

public interface HotelService {

	List<Hotel> getAllHotels();

	List<Hotel> getHotelsByCity(Long cityId);

	Hotel getHotelById(Long hotelId);

	Hotel createNewHotel(Hotel hotel);

	void deleteHotel(Long hotelId);
}
