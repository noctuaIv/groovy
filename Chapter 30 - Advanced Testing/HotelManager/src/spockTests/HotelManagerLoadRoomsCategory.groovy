package spockTests

import models.Room

@Category(models.HotelManager)
class HotelManagerLoadRoomsCategory {

	void loadRooms() {
		def room1 = new Room (roomNumber : 1)
		def room2 = new Room (roomNumber : 2)
		
		rooms << room1 << room2
	}
}
