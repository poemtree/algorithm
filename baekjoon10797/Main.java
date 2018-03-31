package baekjoon10797;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int  cont = 0;
		for(int i = 0, y = scn.nextInt(); i<5; i++)
			if(y==scn.nextInt())
				cont++;
		System.out.println(cont);
		scn.close();
	}
}