package Algorithm_01;

import java.util.Scanner;

/**
 * 回文串
 * 例："aa","bob","testset"
 * Description:给定一个串，通过添加一个字母将其
 * 变成回文串
 * @author Administrator
 *
 */

public class Algorithm_005 {
	final String Y = "YES";
	final String N = "NO";
	
	public String isPalindrome(String input){
		if(input == null || "".equals(input)){
			return Y;
		}
		int length = input.length();
		//若超过10个字符直接返回NO
		if(length > 10){
			return N;
		}
		StringBuilder sb = new StringBuilder(input);
		for(int i=0;i<length;i++){
			sb.deleteCharAt(i);
			String temp = sb.toString();
			if(sb.reverse().toString().equals(temp)){
				return Y;
			}else{
				sb = new StringBuilder(input);
				continue;
			}
		}
		return N;

	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String input;
		while(cin.hasNext()){
			input = cin.next();
			System.out.println(new Algorithm_005().isPalindrome(input));		
		}

	}

}
