package swexpert2072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
     	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     	StringTokenizer st =  new StringTokenizer(br.readLine());
     	int caseNum = Integer.parseInt(st.nextToken());
     	int result, temp;
     	for(int i = 1; i <=caseNum; i++ ) {
     		result = 0;
     		st = new StringTokenizer(br.readLine());
     		for(int y=0; y<10; y++) {
     			temp = Integer.parseInt(st.nextToken());
     			if(temp%2==1) {
     				result += temp;
     			}
     		}
     		System.out.printf("#%d %d\n", i, result);
     	}
	}
}
