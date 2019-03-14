ArrayList<Customer> customers = new ArrayList<Customer>()
Customer customer1= new Customer(mailingName: "Mr Matt Greencroft")
Customer customer2= new Customer(mailingName: "Miss Mary Contrary")
Customer customer3= new Customer(mailingName: "Dr Phillip Dillip")

customers << customer1 << customer2 << customer3

def shiftingStrings = new ShiftingStrings()
shiftingStrings << "Hello " 
shiftingStrings <<"Matt"
shiftingStrings << "!"
println shiftingStrings

ShiftingStrings shiftingStrings2

println shiftingStrings2.equals(shiftingStrings)
shiftingStrings2?.leftShift("hello")

println shiftingStrings.getID()
println shiftingStrings2?.getID()

def today = "Tuesday" 
def result = today?: "not Monday"
println result

println customers*.getMailingName()
customers*.setAddress("1 The High Street")

println "abc" <=> "cba"
println "bbb" <=> "bbb"
println 409 <=> 121

println "A".hashCode()
println "a".hashCode()

println "a" <=> "A"
