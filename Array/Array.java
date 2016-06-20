package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Array {
	/**
	 * Ѱ�������е���Сֵ�����ֵ
	 * ÿ�αȽ��������������ϴ�����Max�Ƚϣ���С����Min�Ƚ�,�Ƚϴ���Ϊ1.5N
	 * @param a
	 */
	public static MaxMin FindMaxAndMin(int[] a){
		int Max = a[0];
		int Min = a[0];
		int len = a.length;
		for(int i = 0; i < len-1; i += 2){
			if(i+1 > len){   //���鳤��Ϊż��ʱ�����һλ
				if(a[i] > Max){
					Max = a[i];
				}
				if(a[i] < Min){
					Min = a[i];
				}
			}
			//�Ƚ����ڵ��������ϴ�����Max�Ƚϣ���С����Min�Ƚ�
			if(a[i] > a[i+1]){
				if(a[i] > Max){
					Max = a[i];
				}
				if(a[i+1] < Min){
					Min = a[i+1];
				}
			}else{
				if(a[i+1] > Max){
					Max = a[i+1];
				}
				if(a[i] < Min){
					Min = a[i];
				}
			}
		}
		return new MaxMin(Max,Min);
	}
	
	/**
	 * �ҳ������еڶ������
	 * @param a
	 * @return
	 */
	public static int findSecMax(int[] a){
		int len = a.length;
		int max = a[0];
		int sec_max = Integer.MIN_VALUE;
		for(int i = 0; i < len; i++){
			if(a[i] > max){
				sec_max = max;
				max = a[i];
			}else{
				if(a[i] > sec_max){
					sec_max = a[i];
				}
			}
		}
		return sec_max;
	}
	
	/**
	 * �����������ҳ��������ظ�Ԫ��������
	 * @param a
	 * @return
	 */
	public static int findMostFrequnentInArray(int[] a){
		int result = 0;
		int size = a.length;
		if(size == 0){
			return Integer.MAX_VALUE;
		}
		
		//��¼ÿ��Ԫ�س��ֵĴ���
		Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		for(int i = 0; i < size; i++){
			if(m.containsKey(a[i])){
				m.put(a[i], m.get(a[i]) + 1);
			}else{
				m.put(a[i], 1);
			}
		}
		
		//�õ������ҳ����ִ�������Ԫ��
		int most = 0;
		Iterator it = m.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry) it.next();
			int key = (int) entry.getKey();
			int value = (int) entry.getValue();
			if(value > most){
				result = key;
				most = value;
			}
		}
		return result;
	}
	
	/**
	 * ������������������a={3,4,5,6,5,6,7,8}���������������Ԫ��֮��Ϊ1��
	 *        ��������9���ҳ����������е�һ�γ��ֵ��±�
	 * �����������Ծ������(���ٱ���)
	 * @param a  ��������
	 * @param t  ��������
	 * @return
	 */
	public static int findIndex(int[] a, int t){
		int len = a.length;
		int i = 0;
		while(i < len){
			if(a[i] == t){
				return i;
			}else{
				i += Math.abs(t - a[i]);
			}
		}
		return -1;
	}
	/**
	 * ��������������ӵ��ڶ�ֵ���������(��ʹ��ɢ�к����Կռ任ʱ��)
	 * ʱ�临�Ӷ�ȡ���������㷨
	 * @param a  
	 * @param sum
	 */
	public static void findSum(int[] a, int sum){
		Arrays.sort(a);
		int begin = 0;
		int end = a.length - 1;
		while(begin < end){
			if(a[begin] + a[end] < sum){
				begin++;
			}else if(a[begin] + a[end] > sum){
				end--;
			}else{
				System.out.print(a[begin] + "," + a[end]);
				begin++;
				end--;
			}
		}
	}

}

//�����ֵ����Сֵʱ����
class MaxMin{
	int Max;
	int Min;
	public MaxMin(int Max,int Min){
		this.Max = Max;
		this.Min = Min;
	}
}