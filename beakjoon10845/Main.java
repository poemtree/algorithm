package beakjoon10845;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Queue queue = new Queue();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int turn = Integer.parseInt(br.readLine());
		
		String command = "";
		StringTokenizer st;
		
		while(turn-->0) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			switch(command) {
			case "push" :
				int X = Integer.parseInt(st.nextToken());
				queue.push(X);
				break;
			case "pop" : 
				System.out.println(queue.pop());
				break;
			case "size" : 
				System.out.println(queue.size());
				break;
			case "empty" :
				System.out.println(queue.empty()); 
				break;
			case "front" : 
				System.out.println(queue.front());
				break;
			case "back" : 
				System.out.println(queue.back());
				break;
			}
		}
		br.close();
	}

}

class Queue {
	private Node front;
	private Node real;
	private int count;
	
	public Queue() { }
	
	//push X: 정수 X를 큐에 넣는 연산이다.
	public void push(int X) {
		if(count > 0) {
			Node newNode = new Node(X);
			real.setNextNode(newNode);
			real = newNode;
		} else {
			Node newNode = new Node(X);
			front = newNode;
			real = newNode;
		}
		count++;
	}
	
	//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int pop() {
		int result = -1;
		if(count > 0) {
			result = front.getValue();
			if(front.equals(real)) {
				front = null;
				real = null;
			} else {
				front = front.getNextNode();
			}
			count--;
		}
		return result;
	}
	
	//size: 큐에 들어있는 정수의 개수를 출력한다.
	public int size() {
		return count;
	}
	
	//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
	public int empty() {
		return (count>0)?0:1;
	}
	
	//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int front() {
		return (count>0)?front.getValue():-1;
	}
	
	//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	public int back() {
		return (count>0)?real.getValue():-1;
	}
}

class Node {
	private Node nextNode;
	private int value;

	public Node() {	}
	
	public Node(int value) {
		this.value = value;
	}
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	public Node getNextNode() {
		return nextNode;
	}
	
	public int getValue() {
		return value;
	}
	
}