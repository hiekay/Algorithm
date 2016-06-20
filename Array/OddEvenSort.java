package Array;
/**
 * 
 * @author LIn
 * ��������������һ���������飬���������������˳��ʹ����������
 *        λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
 *        Ҫ��ʱ�临�Ӷ�ΪO(n)
 */
public class OddEvenSort {
	/**
	 * ������һͷһβ����ָ��ͬʱ���м�ɨ�裬
	 *     ��ͷָ����ָΪż��βָ����ָΪ�棬�򽻻�
	 * @param a
	 */
	public static void OddEvenSort(int[] a){
		if(a.length == 0){
			return;
		}
		
		int begin = a[0];
		int end = a[a.length - 1];
		
		while(begin < end){
			//���beginָ��ָ�����������������������
			if(IsOddNumber(begin)){
				begin++;
			}
			//���beginָ��ָ�����ż����������������
			else if(IsOddNumber(end)){
				end--;
			}
			else{
			//��������(����ż�෴)������
				swap(a, begin, end);
			}
			
		}
	}
	/**
	 * ������һǰһ������ָ���������ɨ�裬����jָ������ʱ������
	 *     ǰָ��i��ʹ����������䵽ǰ�벿��
	 * @param a
	 */
	public static void OddEvenSort2(int[] a, int low, int high){
		int i = low - 1;
		for(int j = low; j < high; j++){
			//a[j]ָ������������
			if(IsOddNumber(a[j])){
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i+1, high);
		
	}
	
	private static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	private static boolean IsOddNumber(int data){
		return (data & 1) == 1;
	}

}
