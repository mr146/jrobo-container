package collection;

import java.util.ArrayList;

import com.google.inject.Inject;

public class ClassWithCollection {
	@Inject CollectionContent []collection;
	public void printCollection()
	{
		System.out.println("collection contains:");
		if(collection == null)
			System.out.println("null collection");
		for(CollectionContent collectionContent : collection)
			collectionContent.action();
	}
}
