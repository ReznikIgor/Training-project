package collectionFunc;

import java.util.Iterator;
import java.util.List;

public class CollectionApp {
	public static void main(String[] args) {
		
		CollectionManip cc = new CollectionManip();
		
		List l1 = cc.getList1();
		List l2 = cc.getList2();
		
		cc.iterateOverList(l1);
		System.out.println();
		cc.iterateOverList(l2);
		System.out.println();
		
		cc.iterateUsingIterator(l1);
		System.out.println();
		
		cc.collContains(l1, l2);
		cc.containsNumb(l1, "3");
		cc.containsNumb(l2, "5");
		
		cc.addElements(l1, l2);
		System.out.println();
		
		cc.removeDiffElements(l1, l2);
		System.out.println();
		
		cc.clearCol(l1);
		
		l1 = cc.getList1();
		
		cc.removeUsingIterator(l1);
	}

}
