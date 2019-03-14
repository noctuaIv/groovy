package ui;

import static org.junit.Assert.*;

import org.junit.Test;

class ExamScoresTest extends GroovyTestCase {

	@Test
	void testAverageScore() {
		def integerList = [10,17,66,33,70,80]
		def decimalList = [58.7,59.6,52.5,50.6,49.4,48.1]
		
		def examScores = new ExamScores()
		examScores.setScores(integerList)
		assert examScores.getAverageScore() == 46
		
		examScores.setScores(decimalList)
		assert examScores.getAverageScore() == 53.15
	}
	
	@Test
	void testToString() {
		def integerList = [10,17,66,33,70,80]
		def decimalList = [58.7,59.6,52.5,50.6,49.4,48.1]
		
		def examScores = new ExamScores()
		examScores.setScores(integerList)
		assertToString(examScores, "6 with 46")
	}
	
	@Test
	void testNotInstantiated() {
		def examScores = new ExamScores()
		shouldFail(NullPointerException) { examScores.getAverageScore() } 
	}

}
