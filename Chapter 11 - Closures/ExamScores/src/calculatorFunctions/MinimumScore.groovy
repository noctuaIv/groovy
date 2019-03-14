package calculatorFunctions


class MinimumScore implements ExamCalculationInterface {

	@Override
	def execute(examScores) {
		def lowest = 100
		for (int i = 0; i<examScores.size(); i++)
		{
			if (examScores[i]< lowest)
			{lowest= examScores[i]}
		}
		lowest
	}
}
