ArrayList<Customer> customers = new ArrayList<Customer>()
Customer customer1 = new Customer(mailingName: "Mr Matt Greencroft" )
Customer customer2 = new Customer(mailingName: "Miss Mary Contrary" )
Customer customer3 = new Customer(mailingName: "Dr Phillip Dillip" )

customers << customer1 << customer2 << customer3

def groovyCustomers = []
groovyCustomers << customer1 << customer2
groovyCustomers.leftShift(customer3)
groovyCustomers.add(new Customer(mailingName: "Mr Simon Pieman"))

println groovyCustomers
println groovyCustomers.size()

println "The first customer is ${groovyCustomers[0].getMailingName()}"
println "The last customer is ${groovyCustomers[-1].getMailingName()}"

groovyCustomers.each {println it.getMailingName()}
groovyCustomers.reverseEach {println it.getMailingName()}

def foundCustomer = groovyCustomers.find {it.getMailingName()[0] == "D"}
println foundCustomer.getMailingName()

def newCustomers = groovyCustomers.findAll {it.getMailingName().contains("i") }
println newCustomers*.getMailingName()

groovyCustomers.eachWithIndex {item, index -> println "The item ${item.getMailingName()} is in position $index"}

def mailingNames = groovyCustomers*.getMailingName()

println mailingNames.collect {it.toUpperCase()}
println mailingNames

mailingNames << "Mr Matt Greencroft" << "Mr Matt Greencroft" << "Mr Matt Greencroft"
println mailingNames
println mailingNames.unique()

println mailingNames.unique {first, second -> first[0] <=> second[0] }


def myNumbers = [1,3,5,11,123,2039,16]

println myNumbers.sum()
println myNumbers.sum {it * it}
println myNumbers.inject {previousResult, currentValue -> previousResult * currentValue}


def myMap = ["one":"Matt", "two": "James", "three": "David", "four": "Michael"]

println myMap.three
myMap << ["five" : "Dianne"]
println myMap
println myMap.getClass()
myMap << ["size()" : "Victoria"]

println myMap."size()"
myMap.each {key, value -> println "$value has a key of $key"}
myMap.findAll {key, value -> value[0] == "M"}.each {key, value -> println value}
println myMap.collect {key, value -> value.toUpperCase() }
def resultsMap = myMap.collectEntries {key, value -> [key,value.toUpperCase()]}
println resultsMap
println resultsMap.getClass()