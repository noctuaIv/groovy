
def message = "MOP injection using categories"

def encryptedMessage

use (StringEnhancements) {
	encryptedMessage = message.simpleEncrypt("test")
}
	println encryptedMessage


String.metaClass.prefix = "test"

String.metaClass.decrypt = {
	String result = ""
	(delegate-=prefix).toCharArray().each { result += it.previous()}
	result
}
	
println encryptedMessage.decrypt()

EnhancedCustomer.mixin Customer
EnhancedCustomer.mixin StringEnhancements

def ec = new EnhancedCustomer()
ec.mailingName = "Matt"
println ec.simpleEncrypt(ec.mailingName, "hello ")

