package models

import org.joda.time.LocalDate

class RoomBookingDSL {
	
	def name
	def address
	def email
	def phone
	def date
	def guests
	def features
	
	def methodMissing(String name, args) {
		this."$name" = args[0]
	}
	
	def propertyMissing(String name) {
		features = name
	}
	
	def createNewBooking(hotelManager,bookingClosure) {
		bookingClosure.delegate = this
		bookingClosure()
		
		def customer = new Customer(name: name, address: address, eMail: email, phoneNumber: phone)
		def dateList = date.split ("_")
		def bookingDate = new LocalDate(dateList[0].toInteger(),dateList[1].toInteger(),dateList[2].toInteger())
		def room = hotelManager."findAllRoomsWith$features"(guests)[0]
		def booking = new Booking(customer:customer, room:room, date:bookingDate)
		booking
		}
}
