import groovy.transform.CompileStatic;
import groovy.transform.TypeChecked;


@CompileStatic
public Integer getSomeValue() {
	Integer variable1 = 10
	def variable2 = 5
	return (Integer)(variable1 + variable2)
}



def myString = 17
println myString.getClass()
myString = "Hello"
println myString.getClass()

String anotherString = "GoodBye"
println anotherString.getClass()
anotherString = 17
println anotherString.getClass()
println anotherString

Integer myInteger = getSomeValue()
println myInteger