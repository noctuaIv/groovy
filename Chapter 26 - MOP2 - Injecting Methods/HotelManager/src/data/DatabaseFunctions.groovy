package data

import groovy.sql.Sql;

class DatabaseFunctions {

	def connectionString = "jdbc:derby://localhost:50000/hotel"
	def sql
	
	def getCustomerID(name) {
		sql.firstRow("select id from customer where name = $name")?.id
	}
	
	def saveCustomer(customer) {
		sql.execute("insert into customer (name,address,phonenumber,email) values ($customer.name, $customer.address, $customer.phoneNumber, $customer.eMail)")
		getCustomerID(customer.name)
	}
	
	def saveBooking(booking) {
		def customerID = getCustomerID(booking.customer.name) ?: saveCustomer (booking.customer) 
		sql.execute("insert into booking (customerID, bookingDate, room) values ($customerID, ${booking.date.toString()}, ${booking.room.roomNumber})")
	}
	
	def saveBookings(bookings) {
		bookings.each {saveBooking (it) }
	}
	
	def loadCustomer(id) {
		sql.firstRow("select * from customer where id = $id")
	}
	
	def loadBookings() {
		sql.dataSet("booking")
	}
	
	DatabaseFunctions() {
		sql = Sql.newInstance(connectionString)
	}
	
	def loadBookings
}
