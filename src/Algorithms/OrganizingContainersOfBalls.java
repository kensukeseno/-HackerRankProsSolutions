package Algorithms;

import static java.util.stream.Collectors.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ResultOrganizingContainersOfBalls {

    /*
     * Complete the 'organizingContainers' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts 2D_INTEGER_ARRAY container as parameter.
     */

    public static String organizingContainers(List<List<Integer>> container) {
    // Write your code here
//    	Let's think about a spefific container.
//    	Denote the number of balls that have the number of the container and that are originally in a deffirent container WB (wrong at the beggining).
//    	Denote the number of balls that do not have the number of the container and that are originally in the container BD (balls with a different number).
//    	If WB and BD are the same, for the container it is possible to collect all balls with the number by swap operations.
    	
    	List<Integer> wbList = new ArrayList<>();
    	List<Integer> bdList = new ArrayList<>();
    	
    	for(int i = 0; i < container.size(); i++) {
    		wbList.add(container.get(i).stream().reduce(0, Integer::sum) - container.get(i).get(i));
    	}
    	
    	return "";

    }

}

public class OrganizingContainersOfBalls {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = ResultOrganizingContainersOfBalls.organizingContainers(container);

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
