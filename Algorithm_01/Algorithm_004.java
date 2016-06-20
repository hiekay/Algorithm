package Algorithm_01;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 动态规划求解
 * @author Administrator
 *
 */
public class Algorithm_004 {
	static DecimalFormat dec = new DecimalFormat("0.0000");
	static double v[][];  //表示取i个数时和为j的概率
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(input.hasNextInt()){
			int n = input.nextInt();
			int a = input.nextInt();
			int b = input.nextInt();
			int x = input.nextInt();
			v = new double[n+1][x+1];
			double sum = b - a + 1;
			for(int i=a;i<=b;i++){
				v[1][i] = 1.0 / sum;   //取1个数和为i的概率
			}
			for(int i=1;i<=n;i++){  //对n个数进行迭代
				for(int j=a;j<=b;j++){
					for(int k=1;k<=x;k++){
						if(k >= j){
//							print(v);
//							System.out.println();
							v[i][k] = v[i][k] + v[i-1][k-j] / sum;
						}
					}
				}
			}
			//输出取n个数和为x的概率
			System.out.println(dec.format(v[n][x]));
		}
	}
	
	private static void print(double[][] v){
		for(int i=0;i<v.length;i++){
			for(int j=0;j<v[i].length;j++){
				System.out.print(v[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
