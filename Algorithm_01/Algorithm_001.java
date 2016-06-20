package Algorithm_01;

import java.util.*;

public class Algorithm_001 {

	static int charLength = 12;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			String lines[] = new String[n];
			int res[]= new int[n];   //�洢���������
			for(int i=0;i<n;i++){
				lines[i] = scanner.next();
				res[i] = calculate(lines[i]);
			}
			for(int s:res){
				System.out.println(s);
			}
		}

	}
	
	//����ĳ���ַ����е�λ��
	private static int calculate(String line){
		Set<Character> s = new TreeSet<Character>();
		for(char c:line.toCharArray()){
			s.add(c);
		}
		
		//�洢ÿһ���ַ��ڸ��������ǵڼ����Ԫ�أ�Ȼ����ֵ�洢��counts������
		int counts[] = new int[s.size()];
		char[] chars = line.toCharArray();
		
		for(int i=0;i<chars.length;i++){
			Iterator<Character> iterator = s.iterator();
			int temp = 0;
			Character next;
			while(iterator.hasNext()){
				next = iterator.next();
				if(next == chars[i]){
					counts[i] = temp;
					s.remove(next);
					break;
				}
				else{
					temp++;
				}
			}
		}
		
		int sum = 1;
		for(int i=0;i<counts.length;i++){
			sum += counts[i] * factorical(charLength - 1);
			
		}
		return sum;
	}
	
	//����׳˵ĺ���
	private static int factorical(int n){
		if(n > 1){
			return n*factorical(n-1);
		}
		else{
			return 1;
		}
	}
	
}
