package Algorithm_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Algorithm_002 {

	public static void main(String[] args) {
		//��ĳ���ַ���ASCII����Ϊkey��������ֵĴ�����Ϊvalue
		Map<Integer,Integer> aMap = new HashMap<Integer,Integer>();
		
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			String a = input.nextLine();
			String b = input.nextLine();
			char[] chars = a.toCharArray();
			for(char c:chars){
				if(aMap.keySet().contains((int)c)){
					int temp = aMap.get((int)c);
					aMap.put((int)c, temp + 1);
				}else{
					aMap.put((int)c, 1);
				}
			}
			
			
			char[] chars1 = b.toCharArray();
			boolean flag = true;
			for(char c:chars1){
				if(aMap.keySet().contains((int)c)){
					int temp = aMap.get((int)c);
					if(temp == 1){
						//˵��ֻ��һ��
						aMap.remove((int)c);
					}else{
						//˵������һ��
						aMap.put((int)c, temp - 1);
					}
				}else{
					flag = false;
					break;
				}
			}
			
			if(flag){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
			aMap.clear();		
		}
			
	}
}
