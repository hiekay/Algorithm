package BitOperation;

public class BitOperation {

	/**
	 * �ж�һ�����Ƿ�Ϊ2��n�η�
	 * ʱ�临�Ӷ�ΪO(logn)
	 * @param n
	 * @return
	 */
	public static boolean isPower(int n){
		if(n < 1){
			return false;
		}
		int i = 1;
		while(i <= n){
			if(i == n){
				return true;
			}
			i <<= 1;     //ÿ������һλ���൱��i *= 2
		}
		return false;
	}
	
	/**
	 * �ж�һ�����Ƿ�2��n�η�
	 * ��һ������2��n�η�����ô������Ķ����Ʊ�ʾ��ֻ��һλΪ1������λ��Ϊ0
	 * @param n
	 * @return
	 */
	public static boolean isPowerX(int n){
		if(n < 1){
			return false;
		}
		int m = n & (n-1);
		return m == 0;

	}
	
	/**
	 * ���������1�ĸ���,ÿλ�жϣ�ʱ�临�Ӷ�ΪO(n)
	 * @param n
	 * @return
	 */
	public static int countOne(int n){
		int count = 0;
		while(n > 0){
			if((n & 1) == 1){  //�ж����һλ�Ƿ�Ϊ1
				count++;
			}
			n >>= 1;  //��λ
		}
		return count;
	}
	/**
	 * ���������1�ĸ���,ÿ�μ���n&(n-1)��ÿ�ξ�Ϊ���һλ��1��ʱ�临�Ӷ�ΪO(m)
	 * @param n
	 * @return
	 */
	public static int countOneX(int n){
		int count = 0;
		while(n > 0){
			if(n != 0){  //�ж����һλ�Ƿ�Ϊ1
				n = n & (n-1);
				count++;
			}
			n >>= 1;  //��λ
		}
		return count;
	}

	
}
