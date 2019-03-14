
def getLastLetters(someValue, length = 1) {
	def result = someValue.substring(someValue.length() - length)
	println "finished"
	result
}

println getLastLetters("Hello")
println getLastLetters("Hello",3)

def analyseVowels(myString) {
	def a = 0
	def e = 0
	def i = 0
	def o = 0
	def u = 0
	for (int counter = 0; counter < myString.length(); counter++) {
		if (myString.charAt(counter) == 'a') { a++}
		if (myString.charAt(counter) == 'e') { e++}
		if (myString.charAt(counter) == 'i') { i++}
		if (myString.charAt(counter) == 'o') { o++}
		if (myString.charAt(counter) == 'u') { u++}
	}
	[a,e,i,o,u]
}

def (a,e,i,o,u) = analyseVowels("The quick brown fox jumped over the lazy dog.")
println e
println o
