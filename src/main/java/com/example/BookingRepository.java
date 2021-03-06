package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends JpaRepository<HotelBooking, Long> {
	
	List<HotelBooking>findByPricePerNightLessThan(double price);
	Optional<HotelBooking> findOneById(long id);
}
