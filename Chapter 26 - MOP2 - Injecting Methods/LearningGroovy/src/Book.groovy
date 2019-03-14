import groovy.lang.GroovyInterceptable
import groovy.lang.MetaClass;


class Book implements GroovyInterceptable {
	
	String title
	
	def doSomething() {
		System.out.println("DoSomething was run")
	}

	@Override
	public Object invokeMethod(String name, Object args) {
		System.out.println("Invoke Method was run")
		this.metaClass.getMetaMethod(name, args).invoke(this, args)
		return null;
	}

	@Override
	public Object getProperty(String propertyName) {
		System.out.println("Get Property was run")
		return "hello";
	}

	@Override
	public void setProperty(String propertyName, Object newValue) {
		System.out.println("Set Property was run")

	}

	

}
