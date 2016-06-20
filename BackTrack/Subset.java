package BackTrack;
/**
 * ���ݷ�
 * Ϊ�˷�������㷨,ʹ���˽϶��ȫ�ֱ���
 * ���ݹ�������Ҫ����backtrack���Ĵ�����ʵ�ּ�֦,������Ҫ�޸�output����
 * @author LIn
 *
 */
public class Subset {
		
	private static int[] s = {1,2,3,4,5,6,7,8};
	private static int n = s.length;
	private static int[] x = new int[n];
	
	/**
	 * ������ϵ��Ӽ�
	 * @param limit  ����ѡ���ض��������Ӽ�
	 * ע��allΪ�����Ӽ�,numΪ�޶�Ԫ���������Ӽ�,
	 *    spΪ�޶�Ԫ����ż����ͬ���Һ�С��8��
	 */
	public static void all_subset(String limit){
		switch(limit){
		case "all":backtrack(0);break;
		case "num":backtrack1(0);break;
		case "sp":backtrack2(0);break;
		}
	}
	

	/**
	 * ���ݷ��󼯺ϵ������Ӽ������εݹ�
	 * ע���Ƿ���ݵ�����Ϊ����
	 * @param t
	 */
	private static void backtrack(int t){
		if(t >= n)
			output(x);
		else
			for (int i = 0; i <= 1; i++) {
				x[t] = i;
				backtrack(t+1);
			}
		
	}
	
	/**
	 * ���ݷ��󼯺ϵ�����(Ԫ�ظ���С��4)���Ӽ������εݹ�
	 * @param t
	 */
	private static void backtrack1(int t){
		if(t >= n)
			output(x);
		else
			for (int i = 0; i <= 1; i++) {
				x[t] = i;
				if(count(x, t) < 4)
					backtrack1(t+1);
			}
		
	}

	/**
	 * (��֦)
	 * �����������Ӽ�Ԫ��С��4,�ж�0~t֮���ѱ�ѡ�е�Ԫ�ظ�����
	 *        ��Ϊ��ʱt֮���Ԫ�ػ�δ���ݹ�,������֮���Ԫ��
	 *        �Ƿ�Ӧ�ñ��ݹ����
	 * @param x
	 * @param t
	 * @return
	 */
	private static int count(int[] x, int t) {
		int num = 0;
		for (int i = 0; i <= t; i++) {
			if(x[i] == 1){
				num++;
			}
		}
		return num;
	}

	/**
	 * ���ݷ��󼯺���Ԫ����ż����ͬ���Һ�С��8���Ӽ�,���εݹ�
	 * @param t
	 */
	private static void backtrack2(int t){
		if(t >= n)
			output(x);
		else
			for (int i = 0; i <= 1; i++) {
				x[t] = i;
				if(legal(x, t))
					backtrack2(t+1);
			}
		
	}
	
	/**
	 * ���Ӽ���Ԫ����ż�Խ����жϣ�����Ԫ�ص������С��8
	 * @param x
	 * @param t
	 * @return
	 */
	private static boolean legal(int[] x, int t) {
		boolean bRet = true;   //�ж��Ƿ���Ҫ��֦
		int part = 0;  //��ż���жϵĻ�׼
		
		for (int i = 0; i <= t; i++) {  //ѡ���һ��Ԫ����Ϊ��ż���жϵĻ�׼
			if(x[i] == 1){
				part = i;
				break;
			}
		}
		
		for (int i = 0; i <= t; i++) {
			if(x[i] == 1){
				bRet &= ((s[part] - s[i]) % 2 == 0);
			}
				
		}

		int sum = 0;
		for(int i = 0; i <= t; i++){
			if(x[i] == 1)
				sum += s[i];
		}
		bRet &= (sum < 8);
		    
		return bRet;
	}


	/**
	 * �Ӽ��������
	 * @param x
	 */
	private static void output(int[] x) {
		for (int i = 0; i < x.length; i++) {
			if(x[i] == 1){
				System.out.print(s[i]);
			}
		}
		System.out.println();	
	}

}
