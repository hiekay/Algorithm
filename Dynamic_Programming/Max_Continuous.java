package Dynamic_Programming;
/**
 * 
 * @author LIn
 * ��̬�滮��
 * ��������˻�/����������
 */
public class Max_Continuous {
	/**
	 * ��������������ȡ�������е����ɸ������������,�ҳ����г˻�����������
	 * ����˼·�����ǵ������Ĵ���,����������������п��ܳ�Ϊ�˻�����������,
	 *        ����Ҫͬʱ����¼�ҳ����˻�����С�˻�
	 * �ݹ�ṹ��maxEnd = max(max(maxEnd * a[i], minEnd * a[i]), a[i]);
	 * 	      minEnd = min(min(maxEnd * a[i], minEnd * a[i]), a[i]);
	 * ʱ�临�Ӷȣ�O(n)
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
	 * ��������������ȡ�������е����ɸ������������,�ҳ����к�����������
	 * ����˼·����С��0ʱ���,���򷵻ؽϴ��
	 * �ݹ�ṹ��nAll = max(nStart, nAll);
	 * ʱ�临�Ӷȣ�O(n)
	 * @param a
	 * @return
	 */
	public double maxSumSubstring(double[] a){
		double nStart = a[0];
		double nAll = a[0];
		for (int i = 1; i < a.length; i++) {
			if(nStart < 0)   //����ȫ�Ǹ���ʱ����0
				nStart = 0;
			nStart += a[i];
			if(nStart > nAll)
				nAll = nStart; 
		}
		return nAll;
	}

}
