package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

	
	private	BookingRepository bookingRepository;
	
	@Autowired
	public DatabaseSeeder(BookingRepository bookingRepository) {
		super();
		this.bookingRepository = bookingRepository;
	}


	@Override
	public void run(String... arg0) throws Exception {

		List<HotelBooking>	bookings = new ArrayList<>();
		
		bookings.add(new HotelBooking("rahathotel", 100.50, 3));
		bookings.add(new HotelBooking("otelim", 200.50, 6));
		bookings.add(new HotelBooking("ot2", 10.50, 8));
		
		bookingRepository.save(bookings);	
		
	}

	
	
}
