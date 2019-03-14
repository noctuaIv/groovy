

class IntegerExtensions {

	static def factorial(Integer self) {
		def result = 1
		(1..self).each {result *= it}
		result
	}
}
