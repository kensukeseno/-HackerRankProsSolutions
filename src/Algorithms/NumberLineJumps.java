package Algorithms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class ResultNumberLineJumps {

	/*
	 * Complete the 'kangaroo' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts following parameters:
	 *  1. INTEGER x1
	 *  2. INTEGER v1
	 *  3. INTEGER x2
	 *  4. INTEGER v2
	 */

	public static String kangaroo(int x1, int v1, int x2, int v2) {
		// Write your code here
		int location1 = x1;
		int location2 = x2;
		
		String ans = "NO";
		
		if(x1 == x2) {
			ans = "YES";
		}
		if(x1 < x2) {
			if(v1 > v2) {
				while(location1 <= location2){
					if(location1 == location2) {
						ans = "YES";
						break;
					}
					location1 += v1;
					location2 += v2;
				}
			}
		}
		if(x1 > x2) {
			if(v1 < v2) {
				while(location1 >= location2){
					if(location1 == location2) {
						ans = "YES";
						break;
					}
					location1 += v1;
					location2 += v2;
				}
			}
		}
		return ans;
	}
}

public class NumberLineJumps {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int x1 = Integer.parseInt(firstMultipleInput[0]);

		int v1 = Integer.parseInt(firstMultipleInput[1]);

		int x2 = Integer.parseInt(firstMultipleInput[2]);

		int v2 = Integer.parseInt(firstMultipleInput[3]);

		String result = ResultNumberLineJumps.kangaroo(x1, v1, x2, v2);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}

