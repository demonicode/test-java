package com.booking.hotels.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.hotels.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {

}
