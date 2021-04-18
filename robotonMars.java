package kayak;

//i have a return statement just for checking unit cases, 
//i am printing the result in the function itself as i don't want to return all the values and print in main method.

public class robotonMars {
	public static int[] cartesiangrid(String s) {
		char xaxisoyaxis = 'y';
		int positiveornegative = 0, prev = 0, xaxis = 0, yaxis = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'L' || s.charAt(i) == 'R') {
				if (i != 0 && s.charAt(i - 1) == 'F')
					positiveornegative = 0;
				if (positiveornegative == 0) {
					positiveornegative = (s.charAt(i) == 'L') ? -1 : 1;
					prev = (s.charAt(i) == 'L') ? -1 : 1;
				} else {
					prev = prev == -1 ? 1 : -1;
					positiveornegative = positiveornegative * prev;
				}
				xaxisoyaxis = (xaxisoyaxis == 'y') ? 'x' : 'y';
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
		}
		int[] result = new int[2];
		result[0] = xaxis;
		result[1] = yaxis;
		System.out.println("For:" + s + "  " + "[" + xaxis + "," + yaxis + "]");
		return result;
	}

	public static void main(String[] args) {
		cartesiangrid("LFFFRFFFRRFFF");
		cartesiangrid("FF");
		cartesiangrid("FFRF");
		cartesiangrid("FFRRRFF");
		cartesiangrid("FFLFF");
	}

}
