package com.booking.hotels.services;

import java.util.List;

import com.booking.hotels.entities.Hotel;

public interface HotelSearchService {

	List<Hotel> searchClosestHotelsByCity(Long cityId);
}
