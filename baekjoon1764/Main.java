package baekjoon1764;

/* [����]
�������� �赵 ���� ����� ��ܰ�, ���� ���� ����� ����� �־��� ��, �赵 ���� ���� ����� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/

/* [�Է�]
ù° �ٿ� �赵 ���� ����� �� N, ���� ���� ����� �� M�� �־�����. �̾ ��° �ٺ��� N���� �ٿ� ���� �赵 ���� ����� �̸���,
N+2° �ٺ��� ���� ���� ����� �̸��� ������� �־�����. �̸��� ���� ���� ���� �ҹ��ڷθ� �̷������, �� ���̴� 20 �����̴�.
N, M�� 500,000 ������ �ڿ����̴�.
*/

/* [���]
�躸���� ���� �� ����� ���������� ����Ѵ�.
*/

/*
�ԷµǴ� �� ���ڿ� ������ �������� ũ��� ��Ҹ� ���������� �����Ͽ� ����ϴ� ������ �ߺ��� �������� �ʴ� HashSet�� �̿��ϸ� ����
�������� ���� �� ������ Array�� sort �Լ��� ���ı��� ������ ������ �� �ִ�.

HashSet�� add �Լ��� �ߺ��� ���� �ԷµǸ� false�� ��ȯ�ϸ� ������� �ʴ´�. �̸� if���� ���ǹ����� ����ϸ� ���� ���� �����ذ��� ����
�ϸ� �Ǻ��� �躸�� HashSet�� ���� Array�� �ҷ��� sort �� ���̿� ��Ҹ� ����ϸ� ���̴�.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// �����Ͽ� �ԷµǴ� �赵 ���� ����� ���� ���� ����� ������ �����ϱ� ���� �� ������ ũ�⸦ �Է� �޴´�.
		int noHear = Integer.parseInt(st.nextToken()) , noSee = Integer.parseInt(st.nextToken());
		  
		HashSet<String> noSet = new HashSet<>();		// �����Ͽ� ���ڿ��� �Է¹����� �躸���� �Ǻ��� HashSet
		HashSet<String> resultSet = new HashSet<>();	// �Ǻ��� �躸���� ������ HashSet
		String temp;	// ���ڿ��� �Է¹޾� noSet���� �Ǻ��� �躸���� resultSet���� �����ϱ� ���� ����
		
		for(int i = 0; i<noHear; i++)	// �赵 ���� ����� ũ�� ��ŭ ���ڿ��� noSet�� add�Ѵ�.
			noSet.add(br.readLine());
		
		for(int i = 0; i<noSee; i++) {	// �赵 ���� ����� ����� noSet�� ���� ���� ����� ũ�� ��ŭ ���ڿ��� add�Ѵ�.
			// temp�� �Է� �޾� noSet�� add�ϸ� ���� �ߺ��� ���̶�� ������� �ʰ� false�� ��ȯ�Ͽ� else���� ����ȴ�.
			if (noSet.add((temp=br.readLine()))){}	
			else
				resultSet.add(temp);		// noSet�� ������� �ʴ´ٸ� �ߺ��� ���̹Ƿ� resultSet�� �����Ѵ�.
		}
		
		System.out.println(resultSet.size());	// ��� ���Ŀ� ���� resultSet�� ũ��(�躸���� ��)�� ����Ѵ�.
		Object[] obj = resultSet.toArray();		// Set�� Ư�� �� ��Ҹ� ����ϱ� ���ؼ� Array�� �Űܾ� �Ѵ�.
		Arrays.sort(obj);	// Array���� �����ϴ� sort �Լ��� �̿��ϸ� ������ ���� �� �� �ִ�.
		for(Object s : obj)	// for each �� Ȱ���ϸ� ���� Array�� ��Ҹ� ����� �� �ִ�.
			System.out.println((String)s);	// Object �̹Ƿ� String���� ����ȯ�Ͽ� ����ؾ� �Ѵ�.
		br.close();
	}
}