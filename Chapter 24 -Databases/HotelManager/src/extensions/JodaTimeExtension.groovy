package extensions

import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.DateTimeFormat

class JodaTimeExtension {

	static def niceString(LocalDate self) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd MMMM yyyy")
		self.toString(dtf)
	}


}
