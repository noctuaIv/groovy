package ui

class ExamScores {

	def scores = [72,43,29,96,93,33,49,32,44,45,44,29,60,61,66,66,59] as Integer[]
	
	def analyse(closure) {
		closure(scores)
		
	}
	
	def analyseWithPassmark(passmark, closure) 
	{
		//do something here with passmark
		closure(scores)
	}	
}
