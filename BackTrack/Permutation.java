package BackTrack;

public class Permutation {

	private static int[] s = {1,2,3,4,5,6,7,8};
	private static int n = s.length;
	private static int[] x = new int[n];
	
	/**
	 * ������ϵ�����
	 * @param limit  ����ѡ���ض��������Ӽ�
	 * ע��allΪ��������,spΪ�޶�Ԫ����ż����䡣
	 */
	public static void all_permutation(String limit){
		switch(limit){
		case "all":backtrack(0);break;
		case "sp":backtrack1(0);break;
		}
	}
	

	/**
	 * ���ݷ��󼯺ϵ��������У����εݹ�
	 * ע���Ƿ���ݵ�����Ϊ����
	 * @param t
	 */
	private static void backtrack(int t){
		if(t >= n)
			output(s);
		else
			for (int i = t; i < n; i++) {
				swap(i, t, s);
				backtrack(t+1);
				swap(i, t, s);
			}
		
	}

	/**
	 * ���ݷ��󼯺���Ԫ����ż����������,���εݹ�
	 * @param t
	 */
	private static void backtrack1(int t){
		if(t >= n)
			output(s);
		else
			for (int i = t; i < n; i++) {
				swap(i, t, s);
				if(legal(x, t))
					backtrack1(t+1);
				swap(i, t, s);
			}
		
	}
	
	/**
	 * ���Ӽ���Ԫ����ż�Խ����ж�
	 * @param x
	 * @param t
	 * @return
	 */
	private static boolean legal(int[] x, int t) {
		boolean bRet = true;   //�ж��Ƿ���Ҫ��֦
		
		//��ż���,��ÿ��һ�����ж���ż��ͬ
		for (int i = 0; i < t - 2; i++) {
			bRet &= ((s[i+2] - s[i]) % 2 == 0);
		}
		    
		return bRet;
	}


	/**
	 * Ԫ�ؽ���
	 * @param i
	 * @param j
	 */
	private static void swap(int i, int j,int[] s) {
		int tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}
	
	/**
	 * �Ӽ��������
	 * @param x
	 */
	private static void output(int[] s) {
		for (int i = 0; i < s.length; i++) {
				System.out.print(s[i]);
		}
		System.out.println();	
	}
}
