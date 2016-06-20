package BackTrack;
/**
 * 使用回溯法解决0-1背包问题
 * @author LIn
 *
 */
public class package0_1 {

	private static int[] w = {2,2,3,4,5,5,6};  //重量
	private static int[] v = {3,4,3,4,5,8,7};  //价值
	private static int n = w.length;
	private static int[] x = new int[n];       //0-1决定是否被选择
	private static int C = 16;  //背包可容纳大小
	private static int max;  //背包最大价值
	
	public static void main(String[] args) {
		backtrack(0);
		System.out.println(max);
	}

	private static void backtrack(int t) {
		if (t >= n) 
			process(x);
		else
			for (int i = 0; i <= 1; i++) {
				x[t] = i;
				if(legal(t)) 
					backtrack(t+1);
			}
	}

	/**
	 * (剪枝)判断背包是否已满
	 * @param t
	 * @return
	 */
	private static boolean legal(int t) {
		int sum = 0;
		for (int i = 0; i < t; i++) {
			sum += x[i] * w[i];
		}
		return (sum <= C);
	}
	
	/**
	 * 通过遍历比较得出最优值
	 * @param x
	 */
	private static void process(int[] x) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i] * v[i];
		}
		
		if(max < sum)
			max = sum;
	}
	
}
