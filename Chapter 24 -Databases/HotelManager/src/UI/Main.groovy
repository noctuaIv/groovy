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

