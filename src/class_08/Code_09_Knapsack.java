package class_08;
import java.util.Scanner;

public class Code_09_Knapsack {
    
	public static int maxValue(int[] c, int[] p, int bag) {
		int[][] dp = new int[c.length + 1][bag + 1];
		for (int i = c.length - 1; i >= 0; i--) {
			for (int j = bag; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];
				if (j + c[i] <= bag) {
					dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
				}
			}
		}
		return dp[0][0];
	}


    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int bag = sc.nextInt();
		System.out.println();
        int[] c = new int[count];
        int[] p = new int[count];
		for (int i = 0; i < count; i++) {
			c[i] = sc.nextInt();
		}
		System.out.println();
		for (int i = 0; i < count; i++) {
			p[i] = sc.nextInt();
		}
        System.out.println();
		System.out.println(maxValue(c, p, bag));
	    
        
    }
}
