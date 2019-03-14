package UI

import data.DatabaseFunctions
import data.LoadAndSaveXML
import models.Booking
import models.Customer
import models.HotelManager
import org.joda.time.*

def hotelManager = new HotelManager()
hotelManager.with {
	loadRooms()
	loadBookings()
	
}

def hotelReports = new HotelReports()
def reportsList = ["printTodaysBookings","runRoomReports", "printTemplateLetters"]
reportsList.each { hotelReports.invokeMethod(it,hotelManager) }

def newCustomer = new Customer()
newCustomer.name = "David Buxton"
newCustomer.address="17 some road"
newCustomer.phoneNumber="012345"
newCustomer.eMail = "david@email.com"

Booking newBooking = new Booking(customer: newCustomer, room: hotelManager.rooms[10], date: new LocalDate() )
newBooking.setDate(new LocalDate(2016,02,01))
 



