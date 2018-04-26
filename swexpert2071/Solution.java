package swexpert2071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     	StringTokenizer st =  new StringTokenizer(br.readLine());
     	int caseNum = Integer.parseInt(st.nextToken());
     	double result;
     	for(int i = 1; i <=caseNum; i++ ) {
     		result = 0;
     		st = new StringTokenizer(br.readLine());
     		for(int y=0; y<10; y++) {
     			result += Integer.parseInt(st.nextToken());
     		}
     		result = Math.round(result/10);
     		System.out.printf("#%d %.0f\n", i, result);
     	}
	}
}
