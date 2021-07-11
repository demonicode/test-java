package com.booking.hotels.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.booking.hotels.entities.Hotel;
import com.booking.hotels.exception.BadRequestException;
import com.booking.hotels.exception.ElementNotFoundException;
import com.booking.hotels.repos.HotelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

	private final HotelRepository hotelRepository;

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public List<Hotel> getHotelsByCity(Long cityId) {
		return hotelRepository.findAll().stream()
				.filter((hotel) -> cityId.equals(hotel.getCity().getId()) && !hotel.isDeleted())
				.collect(Collectors.toList());
	}

	@Override
	public Hotel getHotelById(Long hotelId) {
		return hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ElementNotFoundException("Could not find hotel with ID provided"));
	}

	@Override
	public Hotel createNewHotel(Hotel hotel) {
		if (hotel.getId() != 0L)
			throw new BadRequestException("The ID must not be provided when creating a new Hotel");
		return hotelRepository.save(hotel);
	}

	@Override
	public void deleteHotel(Long hotelId) {
		hotelRepository.deleteHotelById(hotelId);
	}
}
