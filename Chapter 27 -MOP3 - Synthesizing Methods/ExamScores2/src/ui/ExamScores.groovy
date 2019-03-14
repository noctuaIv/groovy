package ui

import java.awt.event.ItemEvent;

class ExamScores {

	def scores  
	def passMark = 20
	
	def propertyMissing(String name) {
		passMark
	}
	
	def propertyMissing(String name, value) {
		this.passMark = value
	}
	
	def loadScores()
	{
		//this method simulates loading the scores from the database 
		scores = [81,87,43,80,66,80,51,89,32,82,37,91,87,72]
	}
	
	def methodMissing(String name, args) {
		if (name.startsWith("getScoreInPosition")) {
			def position = name -= "getScoreInPosition"
			scores[position.toInteger()]
		}
		else { throw new MissingMethodException(name, this.getClass(), args) }
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
