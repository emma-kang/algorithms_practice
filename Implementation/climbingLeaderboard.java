import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length]; 
        
        ArrayList<Integer> board = new ArrayList<Integer>();

        for(int i=0; i<scores.length; i++){
            if(i==0)
                board.add(scores[i]);
            else {
                if(scores[i] != scores[i-1])
                    board.add(scores[i]);
            }
        }

        int mid = Math.round(board.size()/2);

        for(int j=0; j<alice.length; j++){
            if(alice[j] >= board.get(0)) result[j] = 1;
            else if(alice[j] < board.get(board.size()-1)) result[j] = board.size()+1;
            else if(alice[j] > board.get(mid)){
                int uRank = 1;
                for(int x=1; x < mid; x++){
                    if(alice[j] >= board.get(x)) ++uRank;
                }
                result[j] = uRank;
            }
            else {
                int rank = mid+1;
                for(int y=mid; y<alice.length; y++){
                    if(alice[j] < board.get(y)) ++rank;
                }

                result[j] = rank;  
            }
        }
        
        return result;
        
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
