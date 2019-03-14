package UI

import data.DatabaseFunctions
import data.LoadAndSaveXML
import models.Booking
import models.Customer
import models.HotelManager
import models.RoomBookingDSL
import org.joda.time.*

def hotelManager = new HotelManager()
hotelManager.with {
	loadBookings()
	
}


def dsl = new RoomBookingDSL()
def newBooking = dsl.createNewBooking(hotelManager) {
	name      "Adam Wainright"
	address   "15 Gallop Drive,  My Town"
	email     "adam@somecompany.com"
	phone     "012345"
	date      "2014_04_23"
	guests    3
	sea_view
  }

//hotelManager.addBooking(newBooking)


def hotelReports = new HotelReports()
def reportsList = ["printTodaysBookings","runRoomReports", "printTemplateLetters"]
reportsList.each { hotelReports.invokeMethod(it,hotelManager) }


  