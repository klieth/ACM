import java.util.*;


public class Program {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		Scanner stdin = new Scanner(System.in);
		while (stdin.hasNext()) {
			Scanner line = new Scanner(stdin.nextLine().replaceAll("[,.;\'`\"()/:-]+"," "));
			while (line.hasNext()) {
				String word = line.next().toLowerCase();
				if (map.containsKey(word)) {
					map.put(word, map.get(word) + 1);
				} else {
					map.put(word,1);
				}
			}
		}
		int max = 0;
		List<String> words = new ArrayList<String>();
		for (String s : map.keySet()) {
			int num = map.get(s);
			if (num > max) {
				words = new ArrayList<String>();
				words.add(s);
				max = num;
			} else if (num == max)  {
				words.add(s);
			}
		}

		/*
		for (String s : map.keySet()) {
			System.out.println(s + ": " + map.get(s));
		}
		*/
		System.out.println(max + " occurrences");
		for (String s : words) {
			System.out.println(s);
		}
	}
}
