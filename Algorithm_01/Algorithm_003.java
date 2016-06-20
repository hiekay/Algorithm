package Algorithm_01;
/**
 * 
 * ������չ��
 * շת�ദ
 * 
 */
import java.util.Scanner;

public class Algorithm_003 {
	static int charLength = 12;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			int n = scanner.nextInt();
			int lines[] = new int[n];
			String res[]= new String[n];   //�洢���������
			for(int i=0;i<n;i++){
				lines[i] = scanner.nextInt();				
				res[i] = calculate(lines[i] - 1);
			}
			
			for(String s:res){
				System.out.println(s);
			}
		}
	}	
	
	//����ĳ���ַ����е�λ��
	private static String calculate(int line){
		char alpha[] = {'a','b','c','d','e','f','g','h','i','j','k','l'};
		StringBuilder sb = new StringBuilder();
		for(int i=charLength-1;i>=0;i--){
			int temp = line / factorical(i);
			line = line % factorical(i);
			
			sb.append(String.valueOf(alpha[temp]));
			for(int j=temp;j<alpha.length-1;j++){
				alpha[j] = alpha[j+1];
			}
		}
		return sb.toString();
	}

	//����׳˵ĺ���
	private static int factorical(int n) {
		if(n > 1){
			return n*factorical(n-1);
		}
		else{
			return 1;
		}
	}
	



	

}
