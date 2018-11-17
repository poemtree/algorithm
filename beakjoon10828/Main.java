package beakjoon10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int turn = Integer.parseInt(br.readLine().toString());
		StringTokenizer st;
		Stack stack = new Stack();
		while(turn-- > 0) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
				case "push" :
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop" :
					stack.pop();
					break;
				case "size" :
					stack.size();
					break;
				case "empty" :
					stack.empty();
					break;
				case "top" :
					stack.top();
					break;
			}
		}
	}
	
}

class Stack {
	private Node top;
	private int count;
	
	public Stack() {
		top = null;
		count = 0;
	}
	
	//push X: 정수 X를 스택에 넣는 연산이다.
	public void push(int value) {
		if(count > 0) {
			Node newNode = new Node(top, value);
			top = newNode;
		} else {
			Node head = new Node(value);
			top = head;
		}
		count++;
	}
	//pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public void pop() {
		int result = -1;
		if(count > 0) {
			result = top.getValue();
			top=top.getPreviousNode();
			count--;
		}
		System.out.println(result);
	}
	//size: 스택에 들어있는 정수의 개수를 출력한다.
	public void size() {
		System.out.println(count);
	}
	//empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	public void empty() {
		System.out.println((count == 0)? 1 : 0);
	}
	//top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public void top() {
		System.out.println((count == 0)? -1 : top.getValue());
	}
}

class Node {
	private Node previousNode;
	private int value;
	
	public Node() {
		previousNode = null;
		value = 0;
	}
	
	public Node(int value) {
		previousNode = null;
		this.value = value;
	}
	
	public Node(Node previousNode, int value) {
		this.previousNode = previousNode;
		this.value = value;
	}
	
	public Node getPreviousNode() {
		return previousNode;
	}
	
	public int getValue() {
		return value;
	}
}