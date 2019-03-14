package models

import aop.HotelLogger
import org.joda.time.LocalDate

class Booking extends HotelLogger {
	Customer customer
	Room room
	LocalDate date
}
