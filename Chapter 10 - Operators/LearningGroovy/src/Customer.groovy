import groovy.transform.TupleConstructor;

@TupleConstructor
class Customer {
	String mailingName
	String address
	final Date dateOfBirth

//	public Customer(String mailingName, Date dateOfBirth) {
//		this.mailingName = mailingName
//		this.dateOfBirth = dateOfBirth
//	}
	

	public void setAddress(String address) {
		this.address = address
		println "setAddress has been run"
	}

	public String getAddress() {
		throw new IllegalAccessException()

	}
}