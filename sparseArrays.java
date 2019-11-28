import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        // output array has same size of queries
        // each value in queries is a key to search on DB, so don't change anything on queries, only run by position in parallel over queries/output and search on each iteration by query value
        // strings are the db, for each query , same strings have to be counted, so they can be grouped because the important values are their KEY and the COUNTER of repetitions,so convert strings to HashMap collection (<K,V> )
        int[] output = new int[queries.length];
        Map<String,Integer> stringCounter = new HashMap<>();
        Integer counter;
        for(String s : strings){
            counter = stringCounter.get(s);
            counter = counter == null ? 1 : (counter + 1);
            stringCounter.put(s,counter);
        }
        for(int i=0; i<queries.length; i++){
            counter = stringCounter.get(queries[i]);
            counter = counter == null ? 0 : counter;
            output[i] = counter;
        }

        return output;        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
