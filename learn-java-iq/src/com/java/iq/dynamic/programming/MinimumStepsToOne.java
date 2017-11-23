package com.java.iq.dynamic.programming;

import java.util.Arrays;

public class MinimumStepsToOne {

	public static void main(String[] args) {
		System.out.println(getMinSteps(13));
	}

	static int getMinSteps(int n) {
		int dp[] = new int[n + 1];
		dp[1] = 0; // trivial case
		for (int i = 2; i <= n; i++) {
			dp[i] = 1 + dp[i - 1];
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}

}
