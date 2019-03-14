package ui

import java.awt.event.ItemEvent;

class ExamScores {

	def scores  
	
	def loadScores()
	{
		//this method simulates loading the scores from the database 
		scores = [81,87,43,80,66,80,51,89,32,82,37,91,87,72]
	}

	def analyse(closure) {
		closure(scores)
	}

	def getAverageScore() {
		scores.sum() / scores.size()
	}
	
	def getPassRate(int passMark) {
		scores.findAll{it >= passMark}.size() / scores.size()
	}
	
	String toString() {
		"${scores.size()} with ${getAverageScore()}"
	}
	
	
}
