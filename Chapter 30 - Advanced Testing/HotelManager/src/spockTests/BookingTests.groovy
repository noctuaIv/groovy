package spockTests

import groovy.mock.interceptor.StubFor
import models.Booking
import models.BookingClashException
import models.Customer
import models.HotelManager
import models.Room
import org.joda.time.DateTime
import org.joda.time.LocalDate
import spock.lang.*

class BookingTests extends Specification {

	def "add and retrieve a booking" () {
		setup:
	
		def date1 = new LocalDate(2015,5,3)
		def date2 = new LocalDate(2015,5,4)
		
		def customer = new Expando(name: "Sandra Taylor")
		
		HotelManager hm 
		use(HotelManagerLoadRoomsCategory) {
			hm = new HotelManager()
		}
		
		def newBooking = new Booking(customer: customer, date: date1, room: hm.rooms[0])
		
		def dbFunctionsStub = new StubFor(data.DatabaseFunctions )
		dbFunctionsStub.demand.saveBooking { true }
		
		dbFunctionsStub.use {
			hm.addBooking(newBooking)
		}
				
		expect:
		hm.bookings.size() == 1
		hm.getBooking(hm.rooms[0], date1) == newBooking
		hm.getBooking(hm.rooms[1], date1) == null
		hm.getBooking(hm.rooms[0], date2) == null
		hm.getBooking(hm.rooms[1], date2) == null
	}

	def "booking fails due to a clash" () {
		def date1 = new LocalDate(2015,5,3)
		def customer = new Expando(name: "Sandra Taylor")
		
		HotelManager hm
		use (HotelManagerLoadRoomsCategory)  {
			hm = new HotelManager()
		}
		def newBooking = new Booking(customer: customer, date: date1, room: hm.rooms[0])
		
		def dbFunctionsStub = new StubFor(data.DatabaseFunctions )
		dbFunctionsStub.demand.saveBooking { true }
				
		dbFunctionsStub.use {
			hm.addBooking(newBooking)
		}
		
		when:
		dbFunctionsStub.use {
			hm.addBooking(newBooking)
		}
			
		then:
		BookingClashException ex = thrown()
		hm.bookings.size() == 1
	}


}
