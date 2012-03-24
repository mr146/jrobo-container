package mainpackage;

import com.google.inject.AbstractModule;
import one.implementation.*;

public class MyModule extends AbstractModule{

	@Override
	protected void configure() {
		bind(IFoo.class).to(Foo.class);
	}
	
}
