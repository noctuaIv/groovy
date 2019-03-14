def myName = "Matt charges \$ ${2+2} per hour"

def greeting = "Hello $myName"
String greeting2 = "Hello $myName"
myName = "John"
println greeting
println greeting2

println(greeting.equals(greeting2))

println "hello \\ Matt"
println (/hello \ $myName/)

def pattern3Letters = /\w\w\w/
println pattern3Letters

def myShopping = "tea 2 sugar milk eggs and cheese"

def pattern = /\smilk\s/

def result = myShopping =~ pattern

if (result)
{println "match"}
else
{println "no match"}

if (myShopping =~ /aa/) {println "it was found"}

def requiredPattern = /(\D+\s?)+/
println (myShopping ==~ requiredPattern)

def splitShopping = myShopping.split(/\s/)
println splitShopping.size()
println splitShopping
