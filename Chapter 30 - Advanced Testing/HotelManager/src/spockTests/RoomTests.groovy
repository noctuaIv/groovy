package spockTests

import models.Room
import spock.lang.*

public class RoomTests extends Specification {

	def "room max occupancy"() {
		setup:
		Room room = new Room()
		
		when:
		room.singleBeds = singleBeds
		room.doubleBeds = doubleBeds
		
		then:
		room.getMaxOccupancy() == maxOccupancy
		
		where:
		singleBeds | doubleBeds | maxOccupancy
		1          | 0          | 1
		2          | 0          | 2
		0          | 1          | 2
		0          | 2          | 4
		1          | 1          | 3
		2          | 2          | 6
	}

}
