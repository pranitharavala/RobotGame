package kayak;

import java.util.ArrayList;
import java.util.List;

class Robot1 extends Thread {
	static String name;
	static int seconds;
	static String instructions;

	Robot1(String name, int seconds, String instructions) {
		Robot1.name = name;
		Robot1.seconds = seconds;
		Robot1.instructions = instructions;
	}

	public void run() {
		try {
			Robotgame.grid(name, seconds, instructions);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Robot2 extends Thread {
	static String name;
	static int seconds;
	static String instructions;

	Robot2(String name, int seconds, String instructions) {
		Robot2.name = name;
		Robot2.seconds = seconds;
		Robot2.instructions = instructions;
	}

	public void run() {
		try {
			Robotgame.grid(name, seconds, instructions);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Robot3 extends Thread {
	static String name;
	static int seconds;
	static String instructions;

	Robot3(String name, int seconds, String instructions) {
		Robot3.name = name;
		Robot3.seconds = seconds;
		Robot3.instructions = instructions;
	}

	public void run() {
		try {
			Robotgame.grid(name, seconds, instructions);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Robotgame {
	static int winner = 0;
	static int noofseconds = 0;
	static List<String> names = new ArrayList<>();
	static List<Integer> winnerDetails = new ArrayList<>();
	static List<Integer> xaxisDetails = new ArrayList<>();
	static List<Integer> yaxisDetails = new ArrayList<>();

	public static void main(String[] args) {
		Robot1 thread_1 = new Robot1("Joe", 3, "FRFLLFRF");
		Robot2 thread_2 = new Robot2("Bill", 1, "FFFFFLF");
		Robot3 thread_3 = new Robot3("Jim", 2, "LFRF");
		System.out.println("The race has STARTED!");
		thread_1.start();
		thread_2.start();
		thread_3.start();
		try {
			thread_1.join();
			thread_2.join();
			thread_3.join();
		} catch (InterruptedException ex) {
		}
		System.out.println(noofseconds + "s The race has ENDED!");
		for (int i = 0; i < winnerDetails.size(); i++) {
			System.out.println(names.get(i) + " is #" + winnerDetails.get(i) + ", at [" + xaxisDetails.get(i) + ","
					+ yaxisDetails.get(i) + "]");
		}
	}

	public static void grid(String name, int seconds, String instructions) throws InterruptedException {
		char xaxisoyaxis = 'y';
		int positiveornegative = 0, prev = 0, xaxis = 0, yaxis = 0;
		int x = 1;
		for (int i = 0; i < instructions.length(); i++) {
			if (instructions.charAt(i) == 'L' || instructions.charAt(i) == 'R') {
				if (i != 0 && instructions.charAt(i - 1) == 'F')
					positiveornegative = 0;
				if (positiveornegative == 0) {
					positiveornegative = (instructions.charAt(i) == 'L') ? -1 : 1;
					prev = (instructions.charAt(i) == 'L') ? -1 : 1;
				} else {
					prev = prev == -1 ? 1 : -1;
					positiveornegative = positiveornegative * prev;
				}
				xaxisoyaxis = (xaxisoyaxis == 'y') ? 'x' : 'y';
				try {
					Thread.sleep(seconds * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String moves = (instructions.charAt(i) == 'L' || instructions.charAt(i) == 'R') ? "Turns" : "Moves";
				System.out.println(x + "s  " + name + ": " + moves + " " + instructions.charAt(i));
				noofseconds = x;
				x = x + seconds;
				continue;
			}
			if (xaxisoyaxis == 'x') {
				if (positiveornegative < 0)
					xaxis -= 1;
				if (positiveornegative >= 0)
					xaxis += 1;
			} else if (xaxisoyaxis == 'y') {
				if (positiveornegative < 0)
					yaxis -= 1;
				if (positiveornegative >= 0)
					yaxis += 1;
			}
			if (i > 0) {
				try {
					Thread.sleep(seconds * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			String moves = (instructions.charAt(i) == 'L' || instructions.charAt(i) == 'R') ? "Turns" : "Moves";
			System.out.println(x + "s  " + name + ": " + moves + " " + instructions.charAt(i));
			noofseconds = x;
			x = x + seconds;
		}
		names.add(name);
		winnerDetails.add(++Robotgame.winner);
		xaxisDetails.add(xaxis);
		yaxisDetails.add(yaxis);
	}
}
