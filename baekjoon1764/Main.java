package baekjoon1764;

/* [문제]
김진영이 듣도 못한 사람의 명단과, 보도 못한 사람의 명단이 주어질 때, 듣도 보도 못한 사람의 명단을 구하는 프로그램을 작성하시오.
*/

/* [입력]
첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다. 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과,
N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다. 이름은 띄어쓰기 없이 영어 소문자로만 이루어지며, 그 길이는 20 이하이다.
N, M은 500,000 이하의 자연수이다.
*/

/* [출력]
듣보잡의 수와 그 명단을 사전순으로 출력한다.
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
		int noHear = Integer.parseInt(st.nextToken()) , noSee = Integer.parseInt(st.nextToken());
		HashSet<String> noSet = new HashSet<>();
		HashSet<String> resultSet = new HashSet<>();
		String temp;
		for(int i = 0; i<noHear; i++)
			noSet.add(br.readLine());
		for(int i = 0; i<noSee; i++)
			if (noSet.add((temp=br.readLine()))){}
			else
				resultSet.add(temp);
		System.out.println(resultSet.size());
		Object[] obj = resultSet.toArray();
		Arrays.sort(obj);
		for(Object s : obj)
			System.out.println((String)s);
		br.close();
	}
}
