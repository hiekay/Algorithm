package String;
/**
 * 
 * @author LIn
 * ���ַ����Ĳ���
 */
public class StringOperation {
	/**
	 * ������������һ�������еĵ��ʷ�ת����"how are you"
	 *        ��Ϊ"you are how"
	 * ���������1.���巴ת;2.ÿ�����ʷ�ת
	 * @param s
	 * @return
	 */
	public static String swapWord(String s){
		char[] chars = s.toCharArray();
		//�������ַ��������ַ���ת����
		swap(chars, 0, chars.length-1);
		int begin = 0;
		for(int i = 1; i < chars.length; i++){
			if(chars[i] == ' '){
				swap(chars, begin, i-1);
				begin = i + 1;
			}
		}
		swap(chars, begin, chars.length-1);
		return new String(chars);
	}
	
	private static void swap(char[] a, int front, int end){
		while(front < end){
			char temp = a[end];
			a[end--] = a[front];
			a[front++] = temp;
		}
	}
	
	/**
	 * ͳ��һ���ַ����ж��ٸ�����
	 * @param s
	 * @return
	 */
	public static int wordCount(String s){
		boolean word = false;   //ǰ����ַ��Ƿ�ո�
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' '){
				word = true;
			}else if(!word){
				word = false;
				count++;
			}
		}
		return count;
	}

}
