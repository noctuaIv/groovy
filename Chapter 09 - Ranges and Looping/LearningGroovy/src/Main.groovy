println 100.getClass()

10.times { println "Hello Matt - we are at position $it" }

def myRange = 5..<10

println myRange.getClass()

myRange.each {println "Hello Matt - we are at position $it" }

def secondRange = 10..1
secondRange.each {println "Hello Matt - we are at position $it" }
secondRange.step(2) {println "Hello Matt - we are at position $it" }

(1..5).each { println "number $it" }


ArrayList<Customer> customers = new ArrayList<Customer> ()
Customer customer1 = new Customer(mailingName: "Mr Matt Greencroft")
Customer customer2 = new Customer(mailingName: "Miss Mary Contrary")
Customer customer3 = new Customer(mailingName: "Dr Philip Dillip")

customers.add(customer1)
customers.add(customer2)
customers.add(customer3)

customers.each { println it.mailingName }