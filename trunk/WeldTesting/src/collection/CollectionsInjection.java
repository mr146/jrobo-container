package collection;

import java.util.ArrayList;
import java.util.Collections;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

public class CollectionsInjection{
	@Inject ICollectionContent [] collectionContents;
	void action()
	{
		for(ICollectionContent cont : collectionContents)
			cont.action();
	}
}
