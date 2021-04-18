package kayak;

public class countUpandDownpart2 {
	static void countUpAndDown(int start, int end) {
		System.out.println(start);
		if (start < end)
			countUpAndDown(++start, end);
	}

	public static void main(String[] args) {
		countUpAndDown(0, 5);
	}

}
