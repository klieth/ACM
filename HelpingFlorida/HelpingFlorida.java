import java.util.*;


public class HelpingFlorida {
	static boolean debug = true;
	static Map<String, Integer> candidates;
	static List<List<String>> ballots;

	public static void main(String[] args) {
		Scanner lines = new Scanner(System.in);
		while (true) {
			candidates = new HashMap<String, Integer>();
			ballots = new ArrayList<List<String>>();
			Scanner data = new Scanner(lines.nextLine());
			int numCandidates = data.nextInt();
			int numBallots = data.nextInt();
			if (numCandidates == 0 && numBallots == 0) {
				if (debug) System.err.println("quitting");
				break;
			}
			for (int i = 0; i < numBallots; i++) {
				Scanner b = new Scanner(lines.nextLine());
				ballots.add(new ArrayList<String>());
				while (b.hasNext()) {
					String name = b.next();
					ballots.get(i).add(name);
					if (!candidates.containsKey(name)) {
						candidates.put(name,0);
					}
				}
			}
			if (debug) {
				for (List<String> l : ballots) {
					for (String s : l) {
						System.out.print(s + " ");
					}
					System.out.println();
				}
			}
			int round = 0;
			while (true) {
				round++;
				List<List<String>> toRemoveBallot = new ArrayList<List<String>>();
				for (List<String> b : ballots) {
					boolean valid = false;
					for (String s : b) {
						if (candidates.containsKey(s)) {
							candidates.put(s, candidates.get(s) + 1);
							valid = true;
							break;
						}
					}
					if (!valid) {
						toRemoveBallot.add(b);
					}
				}
				for (List<String> b : toRemoveBallot) {
					if (debug) System.out.println("--removing " + b.get(0));
					ballots.remove(b);
					if (debug) System.out.println("Ballots remaining: " + ballots.size());
				}
				int max = 0, min = numBallots + 1;
				String maxName = "NONE";
				for (String s : candidates.keySet()) {
					int votes = candidates.get(s);
					if (votes > max) {
						max = votes;
						maxName = s;
					}
					if (votes < min) {
						min = votes;
					}
				}
				if (max == min) {
					if (candidates.keySet().size() == 1) {
						if (debug) System.out.println("rounds: " + round);
						System.out.println(maxName + " won");
						break;
					}
					if (debug) System.out.println("rounds: " + round);
					String result = "it is a tie between ";
					for (String s : candidates.keySet()) {
						result += s + " and ";
					}
					System.out.println(result.substring(0, result.length() - 5));
					break;
				} else if (max > ballots.size()/2.0) {
					if (debug) System.out.println("rounds: " + round);
					System.out.println(maxName + " won");
					break;
				} else {
					List<String> toRemove = new ArrayList<String>();
					for (String s : candidates.keySet()) {
						if (candidates.get(s) == min) {
							toRemove.add(s);
						}
					}
					for (String s : toRemove) {
						candidates.remove(s);
					}
					if (debug) System.out.print("resetting...");
					for (String s : candidates.keySet()) {
						candidates.put(s, 0);
					}
					if (debug) System.out.println("reset");
				}
			}
		}
	}
}
