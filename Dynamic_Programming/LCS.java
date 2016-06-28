package Dynamic_Programming;
/**
 * 
 * @author LIn
 * LCS:Longest Common Sebsequence
 * 最长公共子序列
 */
public class LCS {
	
	public static int lcsLength(char[] x, char[] y){
		int m = x.length - 1;
		int n = y.length - 1;
		int k = m > n ? n : m;
		int[] c = new int[10];
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(x[i] == y[i]){
					if(i == 1)
						c[i-1] = 1;
					else
						c[i-1] = c[i-2] + 1;
				}
				else{
					c[i-1] = Math.max(c[i], c[i-1]) + 1;
				}
			}
		}
		
		return c[k-1];
	}

}
