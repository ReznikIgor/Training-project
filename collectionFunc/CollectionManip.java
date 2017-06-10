package collectionFunc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionManip {
	public List createCol1() {
		List numbers1 = new ArrayList();
		numbers1.add("1");
		numbers1.add("2");
		numbers1.add("3");
		numbers1.add("4");
		numbers1.add("5");
		numbers1.add("6");
		numbers1.add("7");
		return numbers1;
	}

	private List createCol2() {
		List numbers2 = new ArrayList();
		numbers2.add("1");
		numbers2.add("2");
		numbers2.add("3");
		numbers2.add("4");
		return numbers2;
	}

	public List getList1() {
		return createCol1();
	}

	public List getList2() {
		return createCol2();
	}

	public void iterateOverList(List list) {
		for (Object numb : list) {
			System.out.println("Item in list1 :" + numb);
		}
	}

	public void iterateUsingIterator(List list) {
		for (Iterator it = list.iterator(); it.hasNext();) {
			Object numb = (Object) it.next();
			System.out.println(numb);

		}
	}

	public void collContains(List list1, List list2) {
		if (list1.containsAll(list2)) {
			System.out.println("List1 contains all elements from list2");
		} else {
			System.out.println("List1 don't contains all elements from list2");
		}
	}

	public void containsNumb(List list1, String numb) {
		if (list1.contains(numb)) {
			System.out.println("List contains this number");
		} else {
			System.out.println("This number not in list");
		}

	}

	public void addElements(List l1, List l2) {
		l1.addAll(l2);
		for (Object numb : l1) {
			System.out.println(numb);

		}
	}
	public void removeDiffElements(List l1, List l2){
		l1.retainAll(l2);
		for (Object numb : l1) {
			System.out.println(numb);

		}
	}
	
	public void clearCol(List l1){
		l1.clear();
		for (Object numb : l1) {
			System.out.println(numb);

		}
	}
	public void removeUsingIterator(List list1){
		while(!list1.isEmpty()){
			Iterator it = list1.iterator();
			Object o = it.next();
			System.out.println("Removing element "+ o);
			it.remove();
		}
	}
}
