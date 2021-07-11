package com.booking.hotels.services;

import java.util.List;

import com.booking.hotels.dto.RatingReportDto;
import com.booking.hotels.entities.Hotel;

public interface RatingService {

	RatingReportDto getRatingAverage(Long cityId);

	RatingReportDto getRatingAverage(List<Hotel> hotels);

}
