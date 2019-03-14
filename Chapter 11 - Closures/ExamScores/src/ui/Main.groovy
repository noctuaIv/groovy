package ui

import calculatorFunctions.*;

class Main {


	static main(args) {
		def examScores = new ExamScores()
		
		def firstScore = { scores ->
			scores[0]
		}
		
		def first = examScores.analyse(firstScore)
		println "The first score was $first"

		def averageScore = { scores ->
			def total = 0
			scores.each {total += it}
			total / scores.size()
		}
		
		def lowestScore = { scores ->
			def lowest = 100
			scores.each {
				if (it < lowest)
				{lowest= it}
			}
			
			lowest
		}
		
		def passed = { scores ->
			def result = 0
			scores.each {
				if (it > 50) {result++}
			}
			result
		}
		
		
		def average = examScores.analyse(averageScore)
		def lowest = examScores.analyse(lowestScore)
		def passedNumber = examScores.analyse(passed)

		println "The average score was $average"
		println "The lowerst score was $lowest"
		println "$passedNumber passed the exam"
		
		def numberOfCandidates = examScores.analyse {scores -> scores.size()}
		println "There were $numberOfCandidates candidates."	
		
		def testPassMark = examScores.analyseWithPassmark (50) {scores -> scores.size()}
		
		(20..30).step(2) {println it}
	}

}

