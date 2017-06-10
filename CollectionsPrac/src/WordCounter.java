import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
	Map<String, Integer> wordsContainer = new HashMap<>();

	public void add(String word) {
		if (wordsContainer.containsKey(word)) {
			int count = wordsContainer.get(word) + 1;
			wordsContainer.put(word, count);
		} else {
			wordsContainer.put(word, 1);
		}
	}

	public void print() {
		for (Map.Entry<String, Integer> m : wordsContainer.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
	}

	public void addAll(String line) {
		for (String str : line.split(" ")) {
			add(str);
		}
	}

	public int count(String word) {
		return wordsContainer.get(word);
	}

	public Map<Integer, ArrayList<String>> returnReperatWords() {
		Map<Integer, ArrayList<String>> map = new HashMap<>();
		for (Integer integer : wordsContainer.values()) {
			map.put(integer, new ArrayList<String>());
		}
		for (Map.Entry<String, Integer> map1 : wordsContainer.entrySet()) {
			for (Map.Entry<Integer, ArrayList<String>> map2 : map.entrySet()) {
				if (map1.getValue() == map2.getKey()) {
					ArrayList<String> list = map2.getValue();
					list.add(map1.getKey());
					map2.setValue(list);
				}
			}
		}
		return map;
	}

}
