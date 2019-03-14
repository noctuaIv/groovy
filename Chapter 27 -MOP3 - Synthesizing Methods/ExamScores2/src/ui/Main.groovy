package ui

import calculatorFunctions.*;

class Main {

	static def passMark = 50
	
	static main(args) {

		def examScores = new ExamScores()
		examScores.loadScores()
		
		println examScores.getScoreInPosition5()
		
		examScores.hello = 15
		println examScores.hello
		println examScores.passMark

	}
}

