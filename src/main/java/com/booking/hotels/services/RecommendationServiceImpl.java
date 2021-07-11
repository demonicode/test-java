package com.booking.hotels.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booking.hotels.dto.RecommendedHotelDto;
import com.booking.hotels.entities.Hotel;
import com.booking.hotels.utils.HotelRecommendationAdvisor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationServiceImpl implements RecommendationService {

	private final HotelService hotelService;

	@Override
	public RecommendedHotelDto getBestHotelRecommendationScore() {
		List<Hotel> hotels = hotelService.getAllHotels();
		double maxHotelScore = 0;
		String hotelNameString = "";
		for (Hotel hotel : hotels) {
			double currentHotelScore = HotelRecommendationAdvisor.getRecommendedScore(hotel);
			if (currentHotelScore > maxHotelScore) {
				maxHotelScore = currentHotelScore;
				hotelNameString = hotel.getName();
			}
		}
		return new RecommendedHotelDto(hotelNameString, maxHotelScore);
	}
}
