package models

@Category(Room)
class RoomPrice {

	def price() {
		50 * getMaxOccupancy() + 10 * features.size()
	}
}
