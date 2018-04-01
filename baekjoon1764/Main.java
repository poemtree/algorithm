package baekjoon1764;

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