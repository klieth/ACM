
import java.util.*;

class SplitDecision {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String line;
		while (!(line = scan.nextLine()).equals("0 0 0")) {
			Scanner s = new Scanner(line);
			int you = s.nextInt();
			int dealer = s.nextInt() + s.nextInt();
			s = new Scanner(scan.nextLine());
			int cards = 0;
			int[] deck = new int[12];
			for (int i = 2; i < 12; i++) {
				deck[i] = s.nextInt();
				cards += deck[i];
			}
			System.out.println(you + " vs " + dealer);
			System.out.println(cards + ": " + Arrays.toString(deck));
			int minToWin = dealer - you + 1;
			float pw2gw1 = 0;
			for (int firstCard = 2; firstCard < minToWin; firstCard++) {
				if (deck[firstCard] == 0) continue;
				deck[firstCard]--;
				for (int secondCard = 2; secondCard < 12; secondCard++) {
					if (deck[secondCard] == 0) continue;
					deck[secondCard]--;
					int toWin = dealer - secondCard + 1;
					int count = 0;
					for (int thirdCard = toWin; thirdCard < 12; thirdCard++) {
						count++;
					}
					pw2gw1 = count/(cards - 2);
					deck[secondCard]++;
				}
				deck[firstCard]++;
			}
		}
	}
}
