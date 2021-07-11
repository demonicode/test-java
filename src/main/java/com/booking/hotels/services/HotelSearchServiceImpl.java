package com.booking.hotels.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.booking.hotels.entities.Hotel;
import com.booking.hotels.repos.HotelRepository;
import com.booking.hotels.utils.DistanceComparator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HotelSearchServiceImpl implements HotelSearchService {

	private final HotelRepository hotelRepository;
	DistanceComparator distanceComparator = new DistanceComparator();

	@Override
	public List<Hotel> searchClosestHotelsByCity(Long cityId) {
		return hotelRepository.findAll().stream()
				.filter((hotel) -> cityId.equals(hotel.getCity().getId()) && !hotel.isDeleted())
				.sorted(new DistanceComparator()).limit(3).collect(Collectors.toList());
	}
}
