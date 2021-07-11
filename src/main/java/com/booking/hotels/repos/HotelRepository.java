package com.booking.hotels.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.booking.hotels.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "update hotels set deleted = true where id = ?1 ", nativeQuery = true)
	void deleteHotelById(long hotelId);
}
