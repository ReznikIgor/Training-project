import java.util.ArrayList;
import java.util.Map;

public class AppWordCounter {

	public static void main(String[] args) {
		WordCounter counter = new WordCounter();
		counter.add("fish");
		counter.add("sky");
		counter.add("pen");
		counter.add("flower");
		counter.add("sky");
		counter.add("desk");
		counter.print();
		System.out.println();

		counter.addAll("hoop loop spok hoop dock loop lock loop");
		counter.print();
		System.out.println("--------------------");

		System.out.println(counter.count("sky"));
		System.out.println("--------------------");

		Map<Integer, ArrayList<String>> repeat = counter.returnReperatWords();

		for (Map.Entry<Integer, ArrayList<String>> map : repeat.entrySet()) {
			System.out.print(map.getKey() + " " + map.getValue());
			System.out.println();
		}

	}
}
