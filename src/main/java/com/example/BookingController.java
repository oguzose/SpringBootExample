package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value="/bookings")
public class BookingController {
	
	private List<HotelBooking> bookings;
	
	public BookingController() {
		
		bookings = new ArrayList<>();
		bookings.add(new HotelBooking("otelim", 200.50, 3));
		bookings.add(new HotelBooking("ot2", 10.50, 4));

	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<HotelBooking> getAll(){
		
		return bookings;
	}
	
	@RequestMapping(value="/first", method=RequestMethod.GET)
	public List<HotelBooking> getFirst(){
		
		return bookings.subList(0, 1);
	}
	
	
	@RequestMapping(value="/affordable/{price}", method=RequestMethod.GET)
	public List<HotelBooking>getAffordable(@PathVariable double price){
		
	 return bookings.stream().filter(x-> x.getPricePerNight()<= price).collect(Collectors.toList());
		
		//	 List<HotelBooking>Asda= ..
		//		return Asda;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
		
		 bookings.add(hotelBooking);
		
		return bookings;
	}
	
	

}
