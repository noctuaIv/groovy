package models

import aop.HotelLogger
import org.joda.time.LocalDate

class Booking extends HotelLogger {
	def customer
	Room room
	LocalDate date
}
