package aop

import groovy.lang.GroovyInterceptable
import groovy.lang.MetaClass;

class HotelLogger implements GroovyInterceptable {

	@Override
	public Object invokeMethod(String name, Object args) {
		System.out.println(" LOGGER: ${new Date()} $name method called with arguments $args")
		this.metaClass.getMetaMethod(name, args).invoke(this, args)
	}

	@Override
	public void setProperty(String propertyName, Object newValue) {
		System.out.println(" LOGGER: ${new Date()} $propertyName property set with value $newValue")
		this.@"$propertyName" = newValue
	}
} 