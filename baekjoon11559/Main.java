package baekjoon11559;
/* [문제]
뿌요뿌요의 룰은 다음과 같다.

필드에 여러 가지 색깔의 뿌요를 놓는다. 뿌요는 중력의 영향을 받아 아래에 바닥이나 다른 뿌요가 나올 때까지 아래로 떨어진다.
뿌요를 놓고 난 후, 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다.
뿌요들이 없어지고 나서 위에 다른 뿌요들이 있다면, 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.
아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데, 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다.
터질 수 잇는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.

남규는 최근 뿌요뿌요 게임에 푹 빠졌다. 이 게임은 1:1로 붙는 대전게임이라 잘 쌓는 것도 중요하지만, 상대방이 터뜨린다면 연쇄가 몇 번이 될지 바로 파악할 수 있는 능력도
필요하다. 하지만 아직 실력이 부족하여 남규는 자기 필드에만 신경 쓰기 바쁘다. 상대방의 필드가 주어졌을 때, 연쇄가 몇 번 연속으로 일어날지 계산하여 남규를 도와주자!
 */

/* [입력]
12*6의 문자가 주어진다.
이때 .은 빈공간이고 .이 아닌것은 각각의 색깔의 뿌요를 나타낸다.
R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.(모두 대문자로 주어진다.)
입력으로 주어지는 필드는 뿌요들이 전부 아래로 떨어진 뒤의 상태(즉 뿌요 아래에 빈 칸이 있는 경우는 없음) 이다.
 */

/* [출력]
현재 주어진 상황에서 몇연쇄가 되는지 출력하라. (하나도 터지지 않는다면 0을 출력하면 된다.)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int ySize = 6;
	static int xSize = 12;
	static char[][] map = new char[xSize][ySize];
	static boolean[][] visit = new boolean[xSize][ySize];
	static int dx[] = {0, 1, -1, 0};
	static int dy[] = {-1, 0, 0, 1};
	static int boomCnt;
	static ArrayList<puyo> puyoCnt = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i < xSize; i++) 
			map[i] = br.readLine().toString().toCharArray();				
		while(checkPuyo()) {
			boomCnt++;
			drawMap();
		}
		System.out.print(boomCnt);
	}
	public static boolean checkPuyo() {
		boolean flag = false;
		for(int x=0;x<xSize; x++){
			for(int y=0; y<ySize; y++ ) {
				if(map[x][y]!= '.' && !visit[x][y]) {
					countPuyo(x, y, map[x][y]);
					if(puyoCnt.size()>=4) {
						flag = true;
						boomPuyo();
					}
					puyoCnt.clear();
				}
			}
		}	
		return flag;
	}
	public static void countPuyo(int x, int y, char color) {
		int nx;
		int ny;
		if(map[x][y] == color && !visit[x][y]) {
			visit[x][y] = true;
			puyoCnt.add(new puyo(x, y));
			for(int i=0; i<4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx >= 0 && nx < xSize && ny >= 0 && ny < ySize) 
					countPuyo(nx, ny, color);				
			}
		}
	}
	public static void boomPuyo() {
		for(int i=0; i<puyoCnt.size(); i++)
			map[puyoCnt.get(i).x][puyoCnt.get(i).y] = '.';
	}
	public static void drawMap() {
		int downX=0;
		for(int i=0; i<ySize; i++)
			visit[xSize-1][i]=false;
		for(int x=xSize-2; x>=0; x--) {
			for(int y=ySize-1; y>=0; y--) {
				visit[x][y]=false;
				if(map[x][y]!='.' && map[x+1][y]=='.') {
					downX=x+2;
					while(downX<xSize && map[downX][y]=='.'){
						downX++;
					}
					map[downX-1][y]=map[x][y];
					map[x][y]='.';
					downX=0;
				}
			}
		}
	}
	static class puyo{
		int x;
		int y;
		puyo(){
			super();
		}
		puyo(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}
