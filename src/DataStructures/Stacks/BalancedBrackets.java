package DataStructures.Stacks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Result {

	/*
	 * Complete the 'isBalanced' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts STRING s as parameter.
	 */

	public static String isBalanced(String s) {
		// Write your code here
		//    	Assign numbers that sum to zero to each pair of brakets and put it to list
		List<Integer> bracketsStack = new ArrayList<>();
		for(int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
			case ('{'): bracketsStack.add(1);
			break;
			case ('}'): bracketsStack.add(-1);
			break;
			case ('['): bracketsStack.add(2);
			break;	
			case (']'): bracketsStack.add(-2);
			break;
			case ('('): bracketsStack.add(3);
			break;
			case (')'): bracketsStack.add(-3);
			break;
			}
		}

		//    	Add numbers on other side of list
		String yesNo = "YES";
		if(bracketsStack.size() % 2 == 1) {
			yesNo = "NO";
		}else {
			for(int i = 0; i < bracketsStack.size() / 2; i++) {
				if(bracketsStack.get(i) < 0) {
					yesNo = "NO";
					break;
				}
				int sum = bracketsStack.get(i) + bracketsStack.get(bracketsStack.size() - 1 - i);
				if(sum != 0) {
					yesNo = "NO";
					break;
				}
			}
		}
		return yesNo;
	}

}

public class BalancedBrackets {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				String s = bufferedReader.readLine();

				String result = Result.isBalanced(s);

				bufferedWriter.write(result);
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
