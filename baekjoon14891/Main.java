package baekjoon14891;
/* [문제]
총 8개의 톱니를 가지고 있는 톱니바퀴 4개가 아래 그림과 같이 일렬로 놓여져 있다. 또, 톱니는 N극 또는 S극 중 하나를 나타내고 있다.
톱니바퀴에는 번호가 매겨져 있는데, 가장 왼쪽 톱니바퀴가 1번, 그 오른쪽은 2번, 그 오른쪽은 3번, 가장 오른쪽 톱니바퀴는 4번이다.
이 때, 톱니바퀴를 총 K번 회전시키려고 한다. 톱니바퀴의 회전은 한 칸을 기준으로 한다. 회전은 시계 방향과 반시계 방향이 있고, 아래 그림과 같이 회전한다.
톱니바퀴를 회전시키려면, 회전시킬 톱니바퀴와 회전시킬 방향을 결정해야 한다. 톱니바퀴가 회전할 때, 서로 맞닿은 극에 따라서 옆에 있는 톱니바퀴를
회전시킬 수도 있고, 회전시키지 않을 수도 있다. 톱니바퀴 A를 회전할 때, 그 옆에 있는 톱니바퀴 B와 서로 맞닿은 톱니의 극이 다르다면, B는 A가 회전한
방향과 반대방향으로 회전하게 된다. 예를 들어, 아래와 같은 경우를 살펴보자.
두 톱니바퀴의 맞닿은 부분은 초록색 점선으로 묶여있는 부분이다. 여기서, 3번 톱니바퀴를 반시계 방향으로 회전했다면, 4번 톱니바퀴는 시계 방향으로
회전하게 된다. 2번 톱니바퀴는 맞닿은 부분이 S극으로 서로 같기 때문에, 회전하지 않게 되고, 1번 톱니바퀴는 2번이 회전하지 않았기 때문에, 회전하지
않게 된다. 따라서, 아래 그림과 같은 모양을 만들게 된다.
위와 같은 상태에서 1번 톱니바퀴를 시계 방향으로 회전시키면, 2번 톱니바퀴가 반시계 방향으로 회전하게 되고, 2번이 회전하기 때문에, 3번도 동시에
시계 방향으로 회전하게 된다. 4번은 3번이 회전하지만, 맞닿은 극이 같기 때문에 회전하지 않는다. 따라서, 아래와 같은 상태가 된다.
톱니바퀴의 초기 상태와 톱니바퀴를 회전시킨 방법이 주어졌을 때, 최종 톱니바퀴의 상태를 구하는 프로그램을 작성하시오.
 */

/* [입력]
첫째 줄에 1번 톱니바퀴의 상태, 둘째 줄에 2번 톱니바퀴의 상태, 셋째 줄에 3번 톱니바퀴의 상태, 넷째 줄에 4번 톱니바퀴의 상태가 주어진다. 상태는 8개의
정수로 이루어져 있고, 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.
다섯째 줄에는 회전 횟수 K(1 ≤ K ≤ 100)가 주어진다. 다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다. 각 방법은 두 개의 정수로 이루어져 있고, 첫 번째
정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다. 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.
 */

/* [출력]
총 K번 회전시킨 이후에 네 톱니바퀴의 점수의 합을 출력한다. 점수란 다음과 같이 계산한다.

1번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 1점
2번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 2점
3번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 4점
4번 톱니바퀴의 12시방향이 N극이면 0점, S극이면 8점
 */

/*
톱니바퀴가 회전할 때 톱니바퀴의 배열을 회전시키면 너무 많은 작업이 소요되기 때문에 헤드라는 배열을 따로 만들어 각 톱니바퀴의 12시 방향 톱니를
저장하고 이를 이동시켜 계산을 쉽게 한다.. 지정하여 회전하는 톱니바퀴는 무조건 회전하므로 이동 방향을 0으로 하여 회전 시키고 다음 부터는 왼쪽(-1),
오른쪽(+1) 방향으로 톱니바퀴가 회전 되는지 판단한다.. 이때 가장 왼쪽(배열의 0), 가장 오른쪽(배열의 3) 톱니바퀴인지도 확인해야 한다.
회전 유무를 판단할 때에는 이동 방향에 따라 확인하는 톱니의 위치가 다른데, 왼쪽일 경우 현재 톱니바퀴의 6번톱니와 왼쪽 톱니바퀴의 2번톱니를 비교하고
오른쪽은 현재 톱니바퀴의 2번째 톱니와 오른쪽 톱니바퀴의 2번째 톱니가 같은지 비교하면 된다.. 이는 각 톱니의 헤드에 2 또는 6을 더한 뒤 8로 나누어 쉽게
구할 수 있다.
회전 방향은 시계(+1), 반시계(-1)로 주어지는데 헤드는 회전 방향이 시계일 경우 -1, 반시계일 경우 +1이 되므로 입력된 값을 빼주어 헤드가 되는 톱니를 계산한다.
이때 인덱스 범위 0~7을 넘어가지 않도록 체크해주면 된다. 출력되는 점수 계산은 각 톱니바퀴의 번호를 2의 승으로 계산하여 구하면 된다..
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] wheel = new char[4][8];
	static int[] head = new int[4];
	public static void main(String[] args) throws IOException {
		int hap = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int i = 0;i<4; i++) {
			wheel[i] = br.readLine().toString().toCharArray();
		}
		for(int i = Integer.parseInt(br.readLine()); i>0; i--) {
			st = new StringTokenizer(br.readLine());
			turnWheel(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken()), 0);
		}
		for(int i=0; i<4; i++) {
			if(wheel[i][head[i]]=='1')
				hap += (int) Math.pow(2, i);
		}
		System.out.print(hap);
		br.close();
	}	
	public static void turnWheel(int n, int d, int w) {
		if(n>0 && w<1) {
			if(wheel[n][(head[n]+6)%8] != wheel[n-1][(head[n-1]+2)%8]) {
				turnWheel(n-1, -1 * d, -1);
			}			
		}
		if(n<3 && w>-1) {
			if(wheel[n][(head[n]+2)%8] != wheel[n+1][(head[n+1]+6)%8]) {
				turnWheel(n+1, -1 * d, 1);
			}			
		}
		head[n] -= d;
		if(head[n]==8) head[n]=0;
		if(head[n]==-1) head[n]=7;	
	}
}
