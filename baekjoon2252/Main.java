package baekjoon2252;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int studentsNum = Integer.parseInt(st.nextToken());
		int checkNum = Integer.parseInt(st.nextToken());
		
		int[] priorities = new int[studentsNum+1];

		ArrayList<ArrayList<Integer>> prioritiesTable = new ArrayList<>();
		for(int i = 0; i <= studentsNum; i++) {
			prioritiesTable.add(new ArrayList<Integer>());
		}
		
		int shorterStudent;
		int tallerStudent;
		for(int i = 0; i < checkNum; i++) {
			st = new StringTokenizer(br.readLine());
			tallerStudent = Integer.parseInt(st.nextToken());
			shorterStudent = Integer.parseInt(st.nextToken());
			prioritiesTable.get(tallerStudent).add(shorterStudent);
			priorities[shorterStudent]++;
		}
		
		br.close();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= studentsNum; i++) {
			if(priorities[i] == 0) {
				q.add(i);
			}
		}
		
		int student;
		while(!q.isEmpty()) {
			student = q.remove();
			System.out.println(student+ " ");
			for(int remainingStudent : prioritiesTable.get(student)) {
				if(--priorities[remainingStudent] == 0) {
					q.add(remainingStudent);
				}
			}
		}		
	}

}
