import groovy.text.SimpleTemplateEngine

def template = 'Hello $name, today is $date'

def simpleTemplateEngine = new SimpleTemplateEngine()
def templateParameters = ["name" : "Matt", "date" : new Date()]

def output = simpleTemplateEngine.createTemplate(template).make(templateParameters)

println output
