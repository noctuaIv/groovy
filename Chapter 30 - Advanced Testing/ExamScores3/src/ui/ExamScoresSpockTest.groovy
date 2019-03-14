package ui

import groovy.mock.interceptor.MockFor
import groovy.mock.interceptor.StubFor
import spock.lang.Specification

class ExamScoresSpockTest extends Specification {

	def "test Average Score"() {
		setup:
		def examScores = new ExamScores()
		def authenticationStub = new MockFor(Authentication)
		
		authenticationStub.demand.isUserAuthenticated(0..1) { true }
		
		when:
		examScores.setScores(scoreList)
		
		then:
		authenticationStub.use {
			examScores.getAverageScore() == averageScore
		}
		
		
		where:
		scoreList                           | averageScore
		[10,17,66,33,70,80]                 | 46
		[58.7,59.6,52.5,50.6,49.4,48.1]     | 53.15
		[44]                                | 44
	}
}
