package com.booking.hotels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booking.hotels.entities.City;
import com.booking.hotels.exception.BadRequestException;
import com.booking.hotels.exception.ElementNotFoundException;
import com.booking.hotels.repos.CityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

	private final CityRepository cityRepository;

	@Override
	public List<City> getAllCities() {
		return cityRepository.findAll();
	}

	@Override
	public City getCityById(Long id) {
		return cityRepository.findById(id)
				.orElseThrow(() -> new ElementNotFoundException("Could not find city with ID provided"));
	}

	@Override
	public City createCity(City city) {
		if (city.getId() != null)
			throw new BadRequestException("The ID must not be provided when creating a new City");
		return cityRepository.save(city);
	}

}
