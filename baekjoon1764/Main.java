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

/*
입력되는 두 문자열 집합의 교집합의 크기와 요소를 사전순으로 정렬하여 출력하는 문제로 중복을 혀용하지 않는 HashSet을 이용하면 쉽게
교집합을 구할 수 있으며 Array의 sort 함수로 정렬까지 간단히 구현할 수 있다.

HashSet의 add 함수는 중복된 값이 입력되면 false를 반환하며 저장되지 않는다. 이를 if문의 조건문으로 사용하면 아주 쉽게 문제해결이 가능
하며 판별된 듣보잡 HashSet의 값을 Array로 불러와 sort 후 길이와 요소를 출력하면 끝이다.
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
		
		// 연속하여 입력되는 듣도 못한 사람과 보도 못한 사람의 집합을 구분하기 위해 각 집합의 크기를 입력 받는다.
		int noHear = Integer.parseInt(st.nextToken()) , noSee = Integer.parseInt(st.nextToken());
		  
		HashSet<String> noSet = new HashSet<>();		// 연속하여 문자열을 입력받으며 듣보잡을 판별할 HashSet
		HashSet<String> resultSet = new HashSet<>();	// 판별된 듣보잡을 저장할 HashSet
		String temp;	// 문자열을 입력받아 noSet에서 판별된 듣보잡을 resultSet으로 저장하기 위한 변수
		
		for(int i = 0; i<noHear; i++)	// 듣도 못한 사람의 크기 만큼 문자열을 noSet에 add한다.
			noSet.add(br.readLine());
		
		for(int i = 0; i<noSee; i++) {	// 듣도 못한 사람이 저장된 noSet에 보도 못한 사람으 크기 만큼 문자열을 add한다.
			// temp에 입력 받아 noSet에 add하며 만약 중복된 값이라면 저장되지 않고 false를 반환하여 else문이 실행된다.
			if (noSet.add((temp=br.readLine()))){}	
			else
				resultSet.add(temp);		// noSet에 저장되지 않는다면 중복된 값이므로 resultSet에 저장한다.
		}
		
		System.out.println(resultSet.size());	// 출력 형식에 맞춰 resultSet의 크기(듣보잡의 수)를 출력한다.
		Object[] obj = resultSet.toArray();		// Set의 특성 상 요소를 출력하기 위해선 Array로 옮겨야 한다.
		Arrays.sort(obj);	// Array에서 제공하는 sort 함수를 이용하면 정렬을 쉽게 할 수 있다.
		for(Object s : obj)	// for each 를 활용하면 쉽게 Array의 요소를 출력할 수 있다.
			System.out.println((String)s);	// Object 이므로 String으로 형변환하여 출력해야 한다.
		br.close();
	}
}