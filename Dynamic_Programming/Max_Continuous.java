package Dynamic_Programming;
/**
 * 
 * @author LIn
 * 动态规划：
 * 最大连续乘积/递增子数组
 */
public class Max_Continuous {
	/**
	 * 问题描述：任意取出数组中的若干个连续的数相乘,找出其中乘积最大的子数组
	 * 解题思路：考虑到负数的存在,即负负得正的情况有可能成为乘积最大的子数组,
	 *        故需要同时并记录找出最大乘积和最小乘积
	 * 递归结构：maxEnd = max(max(maxEnd * a[i], minEnd * a[i]), a[i]);
	 * 	      minEnd = min(min(maxEnd * a[i], minEnd * a[i]), a[i]);
	 * 时间复杂度：O(n)
	 * @param a
	 * @return
	 */
	public double maxProductSubstring(double[] a){
		double maxEnd = a[0];
		double minEnd = a[0];
		double maxResult = a[0];
		
		for (int i = 1; i < a.length; i++) {
			double end1 = maxEnd * a[i], end2 = minEnd * a[i];
			maxEnd = Math.max(Math.max(end1, end2), a[i]);
			minEnd = Math.min(Math.min(end1, end2), a[i]);
			maxResult = Math.max(maxEnd, maxResult);
		}
		return maxResult;
	}
	
	/**
	 * 问题描述：任意取出数组中的若干个连续的数相加,找出其中和最大的子数组
	 * 解题思路：和小于0时清空,否则返回较大和
	 * 递归结构：nAll = max(nStart, nAll);
	 * 时间复杂度：O(n)
	 * @param a
	 * @return
	 */
	public double maxSumSubstring(double[] a){
		double nStart = a[0];
		double nAll = a[0];
		for (int i = 1; i < a.length; i++) {
			if(nStart < 0)   //数组全是负数时返回0
				nStart = 0;
			nStart += a[i];
			if(nStart > nAll)
				nAll = nStart; 
		}
		return nAll;
	}

}
