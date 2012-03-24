package mainpackage;

import one.implementation.IFoo;

import collection.ClassWithCollection;
import collection.CollectionContent;
import collection.ICollectionContent;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
	public static void main(String[] args) {
		(new Main()).run();
	}

	public void run() {
		oneImplementation();
		collection();
	}
	private void collection() {
		Injector injector = Guice.createInjector(new CollectionModule());
		ClassWithCollection classWithCollection = injector.getInstance(ClassWithCollection.class);
		classWithCollection.printCollection();
	}

	private void oneImplementation() {

		Injector injector = Guice.createInjector(new MyModule());
		IFoo foo = injector.getInstance(IFoo.class);
		foo.action();
	}

}
