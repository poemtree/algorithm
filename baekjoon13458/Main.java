package baekjoon13458;

/* [����]
�� N���� �������� �ְ�, ������ �����帶�� �����ڵ��� �ִ�. i�� �����忡 �ִ� �������� ���� Ai���̴�.
�������� �Ѱ������� �ΰ��������� �� ������ �ִ�. �Ѱ������� �� �濡�� ������ �� �ִ� �������� ���� B���̰�, 
�ΰ������� �� �濡�� ������ �� �ִ� �������� ���� C���̴�.
������ �����忡 �Ѱ������� ���� 1�� �־�� �ϰ�, �ΰ������� ���� �� �־ �ȴ�.
�� �����帶�� ���û����� ��� �����ؾ� �Ѵ�. �� ��, �ʿ��� ������ ���� �ּҰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

/* [�Է�]
ù° �ٿ� �������� ���� N(1 �� N �� 1,000,000)�� �־�����.
��° �ٿ��� �� �����忡 �ִ� �������� �� Ai (1 �� Ai �� 1,000,000)�� �־�����.
��° �ٿ��� B�� C�� �־�����. (1 �� B, C �� 1,000,000)
 */

/* [���]
�� �����帶�� ���û��� ��� �����ϱ� ���� �ʿ��� �������� �ּ� ���� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		long cnt = 0;
		int[] ary = new int[Integer.parseInt(st.nextToken())];
		 st = new StringTokenizer(br.readLine());
		for(int i = 0; i<ary.length; i++)
			ary[i] = Integer.parseInt(st.nextToken());
		 st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		for(int i = 0; i<ary.length; i++) {
			ary[i] -= b;
			if(ary[i]>0){
                cnt += (ary[i]%c==0)?ary[i]/c+1:ary[i]/c+2;
			} else {
                cnt++;
            }
		}
		System.out.println(cnt);
	}
}
