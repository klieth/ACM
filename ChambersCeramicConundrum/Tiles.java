public class Tiles {
	public static void main(String[] args) {
		Scanner lines = new Scanner(System.in);
		int datasets = Integer.parseInt(lines.nextLine());
		for (int cur = 1; cur <= datasets; cur++) {
			CustomQueue t = new CustomQueue(lines.nextLine());
			// create new floor
			boolean[][] floor = new boolean[6][6];
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					boolean[i][j] = false;
				}
			}
			System.out.println("Data set " + cur);
			Coord loc;
			while ((loc = nextOpenSpace(floor)) != null) { // more pieces to place and a piece fits
				t.index = 0;
				int piece;
				while ((piece = t.next()) != null) {
				}
				if (piece == null) {
					System.out.println("The floor may not be tiled.");
					break;
				}
			}

			// nextOpenSpace(floor);
			// 
		}
	}

	public static Coord nextOpenSpace(boolean[][] floor) {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6 j++) {
				if (!floor[i][j]) {
					return new Coord(i,j);
				}
			}
		}
		return null;
	}
}

class CustomQueue {
	// indices 0 to 8 refer to A through I
	int[] tiles = int[9];
	boolean[] placed = boolean[9];
	int index = 0;

	public CustomQueue(String s) {
		Scanner scan = new Scanner(s);
		for (int i = 0; i < 9; i++) {
			tiles[i] = scan.nextInt();
			placed[i] = false;
		}
	}

	public int next() {
		for (int i = index + 1; i < 9; i++) {
			if (placed[i]) continue;
			index = i;
			return tile[i];
		}
		return null;
	}
}

class Coord {
	int x,y;
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
