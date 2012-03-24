package mainpackage;

import javax.enterprise.inject.Instance;

import one.implementation.Foo;
import one.implementation.IFoo;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import collection.CollectionsInjection;

public class Main {
	private WeldContainer container;
	private ContainerWrap myContainer;

	private <T1, T2, T> T apply(Class<T> resultClass, T1 t1, T2 t2){
		return null;
	}
	
	private <T1, T> T apply(Class<T> resultClass, T1 t1){
		return null;
	}
	
	private <T1 extends Integer> String f(T1 t1)
	{
		return "b";
	}
	
	private <T1> String f(T1 t1)
	{
		return "a";
	}

	public Main() {
		String s = f(new Long(10));
		System.out.println(s);
		Integer x = apply(Integer.class, new Long(10));
		Integer z = apply(Integer.class, new Long(10), "asasas");
		String xxx = "asdf";
		Object obj = xxx;
		System.out.println(obj.getClass());
		container = new Weld().initialize();
		myContainer = container.instance().select(ContainerWrap.class).get();
	}

	public static void main(String[] args) {
		(new Main()).run();
	}

	private void run() {
		printContentInfo();
		oneImplementation();
		collections();
	}

	private void printContentInfo() {
		Instance<?> instance = container.instance();
		for (Object obj : instance)
			if (obj != null)
				System.out.println("weld container contains: "
						+ obj.getClass().toString());
		for (Object obj : myContainer.instance)
			if (obj != null)
				System.out.println("my container contains: "
						+ obj.getClass().toString());
	}

	private void collections() {
		CollectionsInjection xxx = container.instance().select(
				CollectionsInjection.class).get();
	}

	private void oneImplementation() {
		Foo x = (Foo) container.instance().select(IFoo.class).get();
		x.action();
	}
}
