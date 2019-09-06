/**
 * HackerRank Data Structures - Arrays - Array Manipulation
 * 2019-09-06
 * Emma Kang 
 * 
 * 10/16 test cases failed 
 * 3/10 : wrong answer
 * 7/10 : Your code did not execute within the time limits
 * need to consider efficient way 
 */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        int m = queries.length; 
        int[] result = new int[n];
        int max = 0;

        for(int i=0; i<m; i++){
            int a = queries[i][0]; 
            int b = queries[i][1];  
            int k = queries[i][2]; 

            for (int j=a-1; j<b; j++){
                result[j] += k;
            }
        }

        // find max value 
        for (int x=0; x<n; x++){
            if(max < result[x]) max = result[x];
        }

        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
