package kayak;

public class countUppart1 {
	static boolean countUpcheck = true;
	static int prevstart = 0;

	static void countUp(int start, int end) {
		System.out.println(start);
		if (start < end && countUpcheck)
			countUp(++start, end);
		else {
			countUpcheck = false;
			if (start > prevstart)
				countUp(--start, end);
		}
	}

	public static void main(String[] args) {
		prevstart = 1;
		countUp(1, 5);
	}

}
