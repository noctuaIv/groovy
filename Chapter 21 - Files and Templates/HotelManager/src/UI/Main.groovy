package UI

import models.Booking
import models.Customer
import models.HotelManager
import org.joda.time.*

def hotelManager = new HotelManager()
hotelManager.with {
	setUpTestRooms()

	def customer1 = new Customer(name: "Matt Greencroft",address: "1 Some Road,  My Town",eMail: "matt@somecompany.com",phoneNumber: "012345")
	def customer2 = new Customer(name: "David Williams",address: "3 High Street,  My Town",eMail: "david@somecompany.com",phoneNumber: "012345" )
	def customer3 = new Customer(name: "Michelle Black",address: "17 Low Avenue,  My Town",eMail: "michelle@somecompany.com",phoneNumber: "012345" )

	def today = new LocalDate()
	def booking1 = new Booking(customer: customer1,date: today, room: rooms[3] )
	def booking2 = new Booking(customer: customer2,date: today, room: rooms[7] )
	def booking3 = new Booking(customer: customer3,date: today, room: rooms[8] )

	addBooking(booking1)
	addBooking(booking2)
	addBooking(booking3)
	
}
def hotelReports = new HotelReports()
def reportsList = ["printTodaysBookings","runRoomReports", "printTemplateLetters"]
reportsList.each { hotelReports.invokeMethod(it,hotelManager) }
