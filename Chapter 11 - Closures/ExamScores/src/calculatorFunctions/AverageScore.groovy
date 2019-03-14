package calculatorFunctions
import ExamCalculationInterface;


class AverageScore implements ExamCalculationInterface {

	@Override
	def execute(examScores) {
		def total = 0
		for (int i = 0; i < examScores.size(); i++)
			{
				total += examScores[i]
			}
		total / examScores.size()
	}


}
