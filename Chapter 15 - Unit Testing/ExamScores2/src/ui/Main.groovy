package ui

import calculatorFunctions.*;

class Main {


	static main(args) {
		
		def examScores = new ExamScores()
		examScores.loadScores()
		
		def lowestScore = examScores.analyse {it.sort()[0]}
		def highestScore = examScores.analyse {it.sort()[-1]}
		
		println "The average score is ${examScores.getAverageScore()}"
		println "The Pass rate is ${examScores.getPassRate(50)}"
		println "The lowest score is $lowestScore"
		println "The highest score is $highestScore"
		
	}

}

