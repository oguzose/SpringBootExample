package com.example;

public class HotelBooking {
	
	private String hotelName;
	private double pricePerNight;
	private int nbOfNights;
	
	
	public HotelBooking() {
		
		// TODO Auto-generated constructor stub
	}

	public HotelBooking(String hotelName, double pricePerNight, int nbOfNights) {
		this.hotelName = hotelName;
		this.pricePerNight = pricePerNight;
		this.nbOfNights = nbOfNights;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public double getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public int getNbOfNights() {
		return nbOfNights;
	}
	public void setNbOfNights(int nbOfNights) {
		this.nbOfNights = nbOfNights;
	}

}
