package baekjoon10798;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String[] str = new String[5];
		int len = 0;
		for(int i = 0; i<5;i++){
			str[i] = scn.nextLine();
			if(len<str[i].length())
				len=str[i].length();
		}
		for(int i = 0; i<len; i++)
			for(int j = 0; j<5; j++)
				if(str[j].length()>=i+1)
					System.out.print(str[j].charAt(i));
		scn.close();
	}
}