package ui

import calculatorFunctions.*;

class Main {

	static main(args) {

		def examScores = new ExamScores()
		examScores.loadScores()
		
		def average = examScores.getAverageScore()
		def passRate = examScores.getPassRate(50)
		
		println "The average score was $average"
		println "The pass rate was $passRate"
	}
	
	

}


