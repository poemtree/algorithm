package baekjoon14501;
/* [����]
�������� ���ϰ� �ִ� �����̴� ��縦 �Ϸ��� �Ѵ�.
���ú��� N+1��° �Ǵ³� ��縦 �ϱ� ���ؼ�, ���� N�� ���� �ִ��� ���� ����� �Ϸ��� �Ѵ�.
�����̴� �񼭿��� �ִ��� ���� ����� ������� ��Ź�� �߰�, �񼭴� �Ϸ翡 �ϳ��� ���� �ٸ� ����� ����� ��Ƴ��Ҵ�.
������ ����� ����� �Ϸ��ϴµ� �ɸ��� �Ⱓ Ti�� ����� ���� �� ���� �� �ִ� �ݾ� Pi�� �̷���� �ִ�.
N = 7�� ��쿡 ������ ���� ��� ����ǥ�� ����.

	1��	2��	3��	4��	5��	6��	7��
Ti	3	5	1	1	2	4	2
Pi	10	20	10	20	15	40	200

1�Ͽ� �����ִ� ����� �� 3���� �ɸ���, ������� �� ���� �� �ִ� �ݾ��� 10�̴�. 5�Ͽ� �����ִ� ����� �� 2���� �ɸ���,
���� �� �ִ� �ݾ��� 15�̴�.
����� �ϴµ� �ʿ��� �Ⱓ�� 1�Ϻ��� Ŭ �� �ֱ� ������, ��� ����� �� ���� ����. ���� �� 1�Ͽ� ����� �ϰ� �Ǹ�, 
2��, 3�Ͽ� �ִ� ����� �� �� ���� �ȴ�. 2�Ͽ� �ִ� ����� �ϰ� �Ǹ�, 3, 4, 5, 6�Ͽ� �����ִ� ����� �� �� ����.
����, N+1�� °���� ȸ�翡 ���� ������, 6, 7�Ͽ� �ִ� ����� �� �� ����.
��� ���� �� �� �ִ� ����� �ִ� ������ 1��, 4��, 5�Ͽ� �ִ� ����� �ϴ� ���̸�, �� ���� ������ 10+20+15=45�̴�.
����� ������ ���� ��, �����̰� ���� �� �ִ� �ִ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

/* [�Է�]
ù° �ٿ� N (1 �� N �� 15)�� �־�����.
��° �ٺ��� N���� �ٿ� Ti�� Pi�� �������� ���еǾ �־�����, 1�Ϻ��� N�ϱ��� ������� �־�����. (1 �� Ti �� 5, 1 �� Pi �� 1,000)
 */

/* [���]
ù° �ٿ� �����̰� ���� �� �ִ� �ִ� ������ ����Ѵ�.
 */

/*
������ ��� ����� �� �� ���� ū ���� ����ϴ� �˰���.. ù�� ���� �������� ���� �ݺ��ϸ鼭 ����� ���� Ž�� �Ѵ�.. �̵��� ��¥�� �����
���� ���� ���� �Ѿ�� ���� ���� ����� ���� ��� �� ������ �Լ��� ���ȣ�� �ϸ鼭 ��� ��츦 Ž�� �Ѵ�..  
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] table = null;
	static int term;
	static int maxPi;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		term = Integer.parseInt(br.readLine());
		table = new int[term][2];
		for(int i = 0; i < term; i++) {
			st = new StringTokenizer(br.readLine());
			table[i][0] = Integer.parseInt(st.nextToken());
			table[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < term; i++) {
			work(i+table[i][0], i+table[i][0],table[i][1]);	// ù �� ���� ������ �� ���� �� ���� ����� ���� ��쿡�� ���� ����.. ��� ����� ���� Ž��
		}
		System.out.println(maxPi);
		br.close();		
	}
	public static void work(int nowDay, int lastDay, int tot) {
		if(nowDay<term) {	// ����� ���� ��� ������ ���� �ʰ� �ϴ��� Ȯ��..
			work(nowDay+1,nowDay, tot);
			if(nowDay + table[nowDay][0] <= term) {
				tot += table[nowDay][1];
				work(nowDay+table[nowDay][0], nowDay, tot);
			}
		} else {	// �ش����� ������ ���� �ʰ� ���� ��� ������ ����� ���� �� ��� ���� Ȯ��
			if(lastDay<=term)	// ������ ����� ������ �� �ȿ� ���´ٸ� pi�� �� �� ū ���� ����
				maxPi = maxPi>tot?maxPi:tot;
		}
	}
}
