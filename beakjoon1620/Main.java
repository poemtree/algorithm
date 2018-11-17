package beakjoon1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int monsterNum = Integer.parseInt(st.nextToken());
		int testNum = Integer.parseInt(st.nextToken());
		String input = "";
		
		String[] arrangedByNum = new String[monsterNum];

		String[][] arrangedByName = new String[monsterNum][2];
		
		for(int i = 0; i < monsterNum; i++) {
			arrangedByNum[i] = br.readLine();
			arrangedByName[i][0] = arrangedByNum[i];
			arrangedByName[i][1] = String.valueOf(i+1);
		}
		sort(arrangedByName, 0, monsterNum-1);
		
		while(testNum --> 0) {
			input = br.readLine();
			if(input.charAt(0) < 65) {
				System.out.println(arrangedByNum[Integer.parseInt(input)-1]);
			} else {
				System.out.println(search(arrangedByName, input, 0, monsterNum-1));
			}
		}
		
	}
	
	public static void sort(String[][] data, int l, int r) {
		String pivot = data[(l+r)/2][0];
		int left = l;
		int right = r;
		
		 do{
	            while(data[left][0].compareTo(pivot) < 0) left++;
	            while(data[right][0].compareTo(pivot) > 0) right--;
	            if(left <= right){    
	                String[] temp = data[left];
	                data[left] = data[right];
	                data[right] = temp;
	                left++;
	                right--;
	            }
	        }while (left <= right);
	        
	        if(l < right) sort(data, l, right);
	        if(r > left) sort(data, left, r);
	}
	
	public static String search(String[][] data, String name, int l, int r) {
		String result="";
		int pivot = (l+r)/2;
		if(data[pivot][0].equals(name)) {
			result = data[pivot][1];
		} else if(data[pivot][0].compareTo(name) > 0) {
			result = search(data, name, l, pivot-1);
		} else {
			result = search(data, name, pivot+1, r);
		}
		return result;
	}
	
}