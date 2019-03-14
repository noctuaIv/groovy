package UI

import groovy.text.SimpleTemplateEngine
import models.HotelManager
import models.RoomFeatures;
import org.joda.time.LocalDate
import models.RoomPrice

class HotelReports {

	void runRoomReports(HotelManager hm) {
		use (RoomPrice) {
			println "Hotel Room Report - ${new LocalDate().niceString()}"
			println ""
			def totalGuests = hm.rooms.sum {it.getMaxOccupancy()}
			println "The hotel can sleep $totalGuests guests."
			println ""
			def foundRooms = hm.rooms.findAll {it.getMaxOccupancy() >= 2}
			println "The following ${foundRooms.size()} rooms can sleep 2 or more people:"
			foundRooms.each { println "Room number $it.roomNumber - sleeps ${it.getMaxOccupancy()} - price ${it.price()}"}
			println ""

			foundRooms = hm.rooms.findAll {it.features.contains(RoomFeatures.SEA_VIEW)}
			println "The following ${foundRooms.size()} rooms have a sea view:"
			foundRooms.each { println "Room number $it.roomNumber - sleeps ${it.getMaxOccupancy()}- price ${it.price()}"}
			println ""
		}
	}

	void printTodaysBookings(HotelManager hm) {
		def today = new LocalDate()
		def todaysBookings = hm.bookings.findAll {it.date == today}
		println "Today's bookings: ${todaysBookings.size()}"
		todaysBookings.each {
			println "Customer: $it.customer.name - Room: $it.room.roomNumber"
		}
	}

	void printTemplateLetters(HotelManager hm) {
		def template = new File(/E:\VPP Groovy Course\HotelManager\templates\DailyCheckInTemplate.txt/).text
		def today = new LocalDate()
		def todaysBookings = hm.bookings.findAll {it.date == today}
		def engine = new SimpleTemplateEngine()
		todaysBookings.each {
			def output = engine.createTemplate(template).make(it.getProperties())
			def outputFile = new File(/E:\VPP Groovy Course\HotelManager\templates\${it.customer.name}.txt/)
			outputFile << output
		}
	}


}
