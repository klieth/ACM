import java.util.*;

class Triangle {
	public static void main(String[] args) {
		Scanner lines = new Scanner(System.in);
		String line = "";
		while (!(line = lines.nextLine()).equals("-1")) {
			String[] triangle = line.split(" ");
			List<Double> t = new ArrayList<Double>();
			for (String s : triangle) {
				t.add(Double.parseDouble(s));
			}
			double area = ( t.get(0) * (t.get(3) - t.get(5)) + 
					t.get(2) * (t.get(5) - t.get(1)) + 
					t.get(4) * (t.get(1) - t.get(3)));
			if (Math.abs(area) < .01) {
				System.out.println("Not a Triangle");
				continue;
			}

			double s1 = dist(t.get(0),t.get(1),t.get(2),t.get(3));
			double s2 = dist(t.get(0),t.get(1),t.get(4),t.get(5));
			double s3 = dist(t.get(2),t.get(3),t.get(4),t.get(5));
			boolean s1e = Math.abs(s1-s2)<.01;
			boolean s2e = Math.abs(s2-s3)<.01;
			boolean s3e = Math.abs(s1-s3)<.01;

			if (s1e && s2e && s3e) {
				System.out.print("Equilateral Acute");
			} else if (!s1e && !s2e && !s3e) {
				System.out.print("Scalene ");
				List<Double> sides = new ArrayList<Double>();
				sides.add(s1);
				sides.add(s2);
				sides.add(s3);
				Collections.sort(sides);
				double a = sides.get(0) * sides.get(0);
				double b = sides.get(1) * sides.get(1);
				double c = sides.get(2) * sides.get(2);
				if (Math.abs(a + b - c) < .001) {
					System.out.print("Right");
				} else if (a + b < c)  {
					System.out.print("Obtuse");
				} else {
					System.out.print("Acute");
				}
			} else {
				System.out.print("Isosceles ");
				if (s1e) {
					double a = s1 * s1;
					double b = s2 * s2;
					double c = s3 * s3;
					if (Math.abs(a + b - c) < .001) {
						System.out.print("Right");
					} else if (a + b < c)  {
						System.out.print("Obtuse");
					} else {
						System.out.print("Acute");
					}
				} else if (s2e) {
					double a = s3 * s3;
					double b = s2 * s2;
					double c = s1 * s1;
					if (Math.abs(a + b - c) < .001) {
						System.out.print("Right");
					} else if (a + b < c)  {
						System.out.print("Obtuse");
					} else {
						System.out.print("Acute");
					}
				} else {
					double a = s1 * s1;
					double b = s3 * s3;
					double c = s2 * s2;
					if (Math.abs(a + b - c) < .001) {
						System.out.print("Right");
					} else if (a + b < c)  {
						System.out.print("Obtuse");
					} else {
						System.out.print("Acute");
					}
				}
			}
			System.out.println();
		}
		System.out.println("End of Output");
	}

	public static double dot(double x1, double y1, double x2, double y2) {
		return (x1*x2) + (y1*y2);
	}

	public static double dist(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2-x1) * (x2-x1) + (y2-y1) * (y2-y1));
	}
}
