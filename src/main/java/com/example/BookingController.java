package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/bookings")
public class BookingController {

	BookingRepository bookingRepository;

	@Autowired
	public BookingController(BookingRepository bookingRepository) {
		Assert.notNull(bookingRepository);
		this.bookingRepository = bookingRepository;
	}

	@RequestMapping(value="/hotel", method=RequestMethod.GET)
	public List<HotelBooking> getAll(){

		return bookingRepository.findAll();
	}

	/*@RequestMapping(value="/hotel/{id}", method=RequestMethod.GET)
	public ResponseEntity<HotelBooking> getOne(@PathVariable long id){
		return bookingRepository.findOneById(id).ifPresent(hb -> new ResponseEntity(hb, HttpStatus.ACCEPTED));
	}*/

	@RequestMapping(value="/first", method=RequestMethod.GET)
	public List<HotelBooking> getFirst(){

		return null;
	}

	@RequestMapping(value="/hotel", method=RequestMethod.POST)
	public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){

		 bookingRepository.save(hotelBooking);
		 return bookingRepository.findAll();
	}

	@RequestMapping(value="/hotel", method=RequestMethod.PUT)
	public List<HotelBooking> update(@RequestBody HotelBooking hotelBooking){

		 bookingRepository.save(hotelBooking);
		 return bookingRepository.findAll();
	}

	@RequestMapping(value="/hotel/{id}", method=RequestMethod.DELETE)
	public List<HotelBooking> remove(@PathVariable long id){

		bookingRepository.delete(id);
		return bookingRepository.findAll();
	}

	
	@RequestMapping(value="/affordable/{price}", method=RequestMethod.GET)
	public List<HotelBooking>getAffordable(@PathVariable double price){

		return bookingRepository.findByPricePerNightLessThan(price);

		// return bookings.stream().filter(x-> x.getPricePerNight()<= price).collect(Collectors.toList());
		//	 List<HotelBooking>Asda= ..
		//		return Asda;
	}


}
