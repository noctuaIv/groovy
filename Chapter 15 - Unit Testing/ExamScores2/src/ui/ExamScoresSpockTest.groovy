package ui

import spock.lang.Specification

class ExamScoresSpockTest extends Specification {

	def "test Average Score"() {
		setup:
		def examScores = new ExamScores()
		
		when:
		examScores.setScores(scoreList)
		
		then:
		examScores.getAverageScore() == averageScore
		
		where:
		scoreList                           | averageScore
		[10,17,66,33,70,80]                 | 46
		[58.7,59.6,52.5,50.6,49.4,48.1]     | 53.15
		[44]                                | 44
	}
}
