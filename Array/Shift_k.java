package Array;
/**
 * 
 * @author LIn
 * ��������һ������ѭ������kλ�������������12345678����2λ��Ϊ78123456
 * �㷨���̣�
 * 1.������������У���123456������������ʽ��Ϊ65432178
 * 2.�����ұ������У���78������������ʽ��Ϊ65432187
 * 3.ȫ����������������ʽ��Ϊ78123456
 * 
 * ʱ�临�Ӷȣ�O(n)
 */
public class Shift_k {
	
	public static void shift_k(int[] a, int k){
		int n = a.length;
		k = k % n;     //����k��n��
		reverse(a, 0, n - k - 1);
		reverse(a, n - k, n - 1);
		reverse(a, 0, n - 1);
	}
	
	private static void reverse(int[] a, int b, int e){
		for( ; b < e; b++,e--){
			int temp = a[e];
			a[e] = a[b];
			a[b] = temp;
		}
	}
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8};
		shift_k(a, 2);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}

}
