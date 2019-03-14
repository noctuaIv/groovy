package data

import groovy.xml.MarkupBuilder
import models.Room
import models.RoomFeatures;

class LoadAndSaveXML {

	def loadRooms() {
		def rooms = []

		def xmlDoc = new XmlSlurper().parse("roomlist.xml")
		xmlDoc.Room.each {
			Room newRoom = new Room()
			newRoom.roomNumber = it.@roomNumber.text().toInteger()
			newRoom.singleBeds = it.singleBeds.text().toInteger()
			newRoom.doubleBeds = it.doubleBeds.text().toInteger()
			it.features.feature.each { nextFeature ->
				newRoom.features << Enum.valueOf(RoomFeatures, nextFeature.text())
			}
			rooms << newRoom
		}

		rooms
	}
	
	def saveBookings(hotelBookings) {
		def stringWriter = new StringWriter()
		def xmlBuilder= new MarkupBuilder(stringWriter)
		
		xmlBuilder.bookings {
			hotelBookings.each { nextBooking ->
				booking {
					customer {
						name (nextBooking.customer.name)
						address (nextBooking.customer.address)
						eMail (nextBooking.customer.eMail)
						phoneNumber (nextBooking.customer.phoneNumber)
					}
					room (nextBooking.room.roomNumber)
					date (nextBooking.date)
				}
			}
		}
		def file = new File("bookings.xml")
		file << stringWriter.toString()
	}
}
