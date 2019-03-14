package ui

class ExamScores {

	def scores  
	
	def loadScores()
	{
		//this method simulates loading the scores from the database 
		scores = [81,87,43,80,66,80,51,89,32,82,37,91,87,72]
	}
	
	def getAverageScore() {
		def authentication = new Authentication() 
		if (authentication.isUserAuthenticated()) { 
			scores.sum() / scores.size()
		}
		else { null }
	}
	
	def getPassRate(int passMark) {
		def authentication = new Authentication() 
		if (authentication.isUserAuthenticated()) {  
			scores.findAll{it >= passMark}.size() / scores.size()
		}
		else { null }
	}
	
	String toString() {
		"${scores.size()} with ${getAverageScore()}"
	}
	
	
}
