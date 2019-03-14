def myName = """Matt charges 


${2+2} per 

hour"""

def greeting = "Hello $myName"
String greeting2 = /Hello $myName/
myName = "John"
println greeting
println greeting2

println(greeting.is(greeting))

def myStringBuilder = new StringBuilder()
myStringBuilder << "Start " << "middle"
myStringBuilder << " end"
println myStringBuilder.toString()

def emptyGreeting = greeting -= "Matt"
println emptyGreeting