import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        if(h.length == 0) return 0L;
        if(h.length == 1) return h[0];

        int maxArea = -1;
        
        for(int index = 0; index < h.length ; index++){
        
            int sizeLimit = h[index];
        
            // curr area
            int area = sizeLimit;
        
            // left area for sizeLimit
            for( int i = index-1 ; i >= 0 ; i-- ){
                if(h[i]< sizeLimit)
                    break;
                area += sizeLimit;
            }
        
            // right area for sizeLimit X
            for( int i = index+1 ; i < h.length ; i++ ){
                if(h[i] < sizeLimit)
                    break;
                area += sizeLimit;
            }
        
            if(area > maxArea)
                maxArea=area;
        }
        
        return maxArea;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
