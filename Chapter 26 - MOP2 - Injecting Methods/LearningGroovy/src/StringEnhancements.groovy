@Category(String)
class StringEnhancements {
	
	static def simpleEncrypt(value,prefix) {
		String result = ""
		value.toCharArray().each { result += it.next()}
		prefix + result
	}
	
	static def simpleDecrypt(value,prefix) {
		String result = ""
		(value-=prefix).toCharArray().each { result += it.previous()}
		result
	}

}
