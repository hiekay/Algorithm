package BackTrack;
/**
 * ʹ�û��ݷ����0-1��������
 * @author LIn
 *
 */
public class package0_1 {

	private static int[] w = {2,2,3,4,5,5,6};  //����
	private static int[] v = {3,4,3,4,5,8,7};  //��ֵ
	private static int n = w.length;
	private static int[] x = new int[n];       //0-1�����Ƿ�ѡ��
	private static int C = 16;  //���������ɴ�С
	private static int max;  //��������ֵ
	
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
	 * (��֦)�жϱ����Ƿ�����
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
	 * ͨ�������Ƚϵó�����ֵ
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
