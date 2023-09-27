package Algorithms;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

class ResultMigratoryBirds {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
    // Write your code here
    	arr.sort(Comparator.naturalOrder());
    	int maxCount = 0;
    	int count = 0;
    	int mostSighted = 0;
    	int sighted = 0;
    	
    	for(int i = 0; i < arr.size(); i++) {
    		if(arr.get(i) == sighted) {
    			count++;
    			if(count > maxCount) {
    				maxCount = count;
    				mostSighted = sighted;
    			}
    		}else {
    			count = 1;
    			sighted = arr.get(i);
    		}
    	}
    	return mostSighted;
    }

}

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = ResultMigratoryBirds.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
