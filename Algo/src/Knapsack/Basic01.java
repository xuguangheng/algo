package Knapsack;

public class Basic01 {
	
	// Brute Force
	public int maxValue(int[] weights, int[] values, int capacity) {
		return maxValue(weights, values, capacity, 0);
	}

	private int maxValue(int[] weights, int[] values, int capacity, int i) {
		if(i == weights.length) return 0;
		if(weights[i] < capacity) {
			return Math.max(maxValue(weights, values, capacity, i+1), maxValue(weights, values, capacity - weights[i], i+1) + values[i]);
		}
		return maxValue(weights, values, capacity, i+1);
	}
	
	
	// DP
	public int maxValue1(int[] weights, int[] values, int capacity) {
		int n = weights.length;
		int[][] dp = new int[n+1][capacity+1];
		for(int i=1;i<=n;i++) {
			int weight = weights[i-1];
			int value = values[i-1];
			for(int v=0; v<=capacity; v++) {
				dp[i][v] = v < weight ? dp[i-1][v] : Math.max(dp[i-1][v], dp[i-1][v-weight] + value);
			}
		}
		
		return dp[n][capacity];
	}
	
	// Optimized DP
	public int maxValue2(int[] weights, int[] values, int capacity) {
		int n = weights.length;
		int[] dp = new int[capacity+1];
		for(int i=1;i<=n;i++) {
			int weight = weights[i-1];
			int value = values[i-1];
			for(int v=capacity; v>=0; v--) {
				dp[v] = v < weight ? dp[v] : Math.max(dp[v], dp[v-weight] + value);
			}
		}
		
		return dp[capacity];
	}

}
