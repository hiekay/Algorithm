package Array;
/**
 * 
 * @author LIn
 * ������������n���������ҳ�������С��k����
 * ���������                                                     ʱ�临�Ӷ�
 * 1.ȫ������(����)             O(nlogn)
 * 2.��������(ά�ִ�СΪk������)    O(nk)
 * 3.ά������(ÿ��ȥ�����Ԫ��)    O(nk)
 * 4.����ѡ���㷨                                             O(n)
 */
public class FindMin_K {
	//����ѡ���㷨��ʵ��
	private final static int CUTOFF = 10;  //�ضϷ�Χ
	//ѡ���㷨�����󣬵�k����СԪ����λ��k-1��
	public static void QuickSelect(int[] a, int left, int right, int k){
		if(left + CUTOFF <= right){
			int pivot = median3(a, left, right);
			
			//��ʼ����
			int i = left, j = right - 1;
			for( ; ; ){
				while(a[++i] < pivot){}
				while(a[--j] > pivot){}
				if(i < j){
					swap(a, i, j);
				}
				else{
					break;
				}
			}
			
			swap(a, i, right-1);    //�����׼��
			
			if(k <= i){
				QuickSelect(a, left, i - 1, k);
			}else{
				QuickSelect(a, i + 1, right, k);   
			}
			    
			
		}
		else{   //������������ò�������
			//InsertSort(a, left, right);
		}
	}
	
	/**
	 * �����������������ػ�׼��
	 * ��������������ֵ
	 */
	private static int median3(int[] a, int left, int right) {
		int center = (left + right) / 2;
		if(a[center] < a[left]){
			swap(a, left, center);
		}
		if(a[right] < a[left]){
			swap(a, left, right);
		}
		if(a[right] < a[center]){
			swap(a, center, right);
		}
		
		//����׼�������right-1λ����
		swap(a, center, right - 1);
		return a[right-1];
	}

	private static void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
