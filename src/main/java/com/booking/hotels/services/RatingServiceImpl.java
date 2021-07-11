package com.booking.hotels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booking.hotels.dto.RatingReportDto;
import com.booking.hotels.entities.Hotel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

	private final HotelService hotelService;

	@Override
	public RatingReportDto getRatingAverage(Long cityId) {
		return getRatingAverage(hotelService.getHotelsByCity(cityId));
	}

	@Override
	public RatingReportDto getRatingAverage(List<Hotel> hotels) {
		double ratingSum = 0;
		int ratingCount = 0;

		for (Hotel hotel : hotels) {
			if (hotel.getRating() != null) {
				ratingSum += hotel.getRating();
				ratingCount++;
			}
		}
		return new RatingReportDto(ratingCount, ratingSum / ratingCount);
	}
}
