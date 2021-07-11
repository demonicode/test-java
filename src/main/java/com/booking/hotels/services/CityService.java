package com.booking.hotels.services;

import java.util.List;

import com.booking.hotels.entities.City;

public interface CityService {

	List<City> getAllCities();

	City getCityById(Long id);

	City createCity(City city);
}
