package com.booking.hotels.services;

import com.booking.hotels.dto.RecommendedHotelDto;

public interface RecommendationService {

	RecommendedHotelDto getBestHotelRecommendationScore();
}
