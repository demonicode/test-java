package com.booking.hotels.utils;

import com.booking.hotels.entities.City;
import com.booking.hotels.entities.Hotel;

public class SearchDistanceAdvisor {
	public static double distanceFromHotelToCityCentre(Hotel hotel) {
	    City city = hotel.getCity();
	    return HaversineDistance.haversine(
	        hotel.getLatitude(),
	        hotel.getLongitude(),
	        city.getCityCentreLatitude(),
	        city.getCityCentreLongitude());
	  }
}
