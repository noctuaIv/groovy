void dbTest() {
	println "starting dbTest"
	Class.forName("non Existant Class")
	println "finishing dbTest"
}

void something() {
	try {
	dbTest()
	}
	catch (ClassNotFoundException e) {
		println "the class wasn't found"
		//throw new MyCustomException()
		throw new RuntimeException("the class wasn't found")
	}
}

something()
println "this is the end"