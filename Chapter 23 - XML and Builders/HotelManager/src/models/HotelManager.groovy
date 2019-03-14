package models

import org.joda.time.DateTime;
import org.joda.time.LocalDate
import data.LoadAndSaveXML
import groovy.io.FileType

class HotelManager {
	ArrayList<Room> rooms = []
	ArrayList<Booking> bookings = []

	void loadRooms() {
		
		rooms = new LoadAndSaveXML().loadRooms()
			
	}

	void addBooking(Booking booking) {
		if (isRoomBooked(booking.room,  booking.date)) {
			throw new BookingClashException()
		}
		bookings << booking
	}

	Booking getBooking(Room room,LocalDate date) {
		bookings.find {it.room == room && it.date == date}
	}

	boolean isRoomBooked(Room room,LocalDate date) {
		getBooking(room,date) != null
	}

}