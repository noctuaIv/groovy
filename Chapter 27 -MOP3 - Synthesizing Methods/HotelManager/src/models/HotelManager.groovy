package models

import org.joda.time.DateTime;
import org.joda.time.LocalDate
import data.DatabaseFunctions
import data.LoadAndSaveXML
import groovy.io.FileType

class HotelManager {
	ArrayList<Room> rooms = []
	ArrayList<Booking> bookings = []

	void loadRooms() {
		
		rooms = new LoadAndSaveXML().loadRooms()
			
	}

	void addBookingWithoutSave(Booking booking) {
		if (isRoomBooked(booking.room,  booking.date)) {
			throw new BookingClashException()
		}
		bookings << booking
	}
		
	void addBooking(Booking booking) {
		addBookingWithoutSave(booking)
		new DatabaseFunctions().saveBooking(booking)
	}
	
	void loadBookings() {
		def dbFunctions = new DatabaseFunctions()
		def ds = dbFunctions.loadBookings()
		ds.each { dbBooking ->
			def customerID = dbBooking.customerID
			def customerRow = dbFunctions.loadCustomer(customerID)
			def customer = new Customer(name: customerRow.name, address : customerRow.address, eMail: customerRow.email, phoneNumber: customerRow.phoneNumber)
			def room = rooms.find {it.roomNumber == dbBooking.room.toInteger()}
			def booking = new Booking(customer: customer, date: new LocalDate(dbBooking.bookingdate), room: room)
			addBookingWithoutSave(booking)
		}
	}

	Booking getBooking(Room room,LocalDate date) {
		bookings.find {it.room == room && it.date == date}
	}

	boolean isRoomBooked(Room room,LocalDate date) {
		getBooking(room,date) != null
	}
	
	def methodMissing(String name, args) {
		if (name.startsWith("findAllRoomsWith")) {
			def featureString = name -= "findAllRoomsWith"
			def feature = Enum.valueOf(RoomFeatures, featureString.toUpperCase())
			def minOccupancy = args[0]
			rooms.findAll {it.features.contains (feature) && it.getMaxOccupancy() >= minOccupancy}
		}
		else {throw new MissingMethodException (name, this.getClass(), args) }
	}
	
}