package ui

import calculatorFunctions.*;

class Main {

	static def passMark = 50
	
	static main(args) {

		def examScores = new ExamScores()
		examScores.with {
			loadScores()

			def lowestScore = analyse {it.sort()[0]}
			def highestScore = analyse {it.sort()[-1]}

			println "The average score is ${getAverageScore()}"
			println "The Pass rate is ${getPassRate(owner.passMark)}"
			println "The lowest score is $lowestScore"
			println "The highest score is $highestScore"
		}
		
		def selectedProperty = "scores"
		println examScores[selectedProperty]
		selectedProperty = "passMark"
		println examScores[selectedProperty]
		
		println examScores.getProperties()
	}

}

