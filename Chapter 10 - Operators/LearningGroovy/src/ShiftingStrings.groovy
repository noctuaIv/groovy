
class ShiftingStrings {

	String stuff = ""
	
	String toString() {
		stuff
	}
	
	def leftShift(String moreStuff) {
		stuff += moreStuff
		this
	}

	def getID() {
		3
	}
	
}
