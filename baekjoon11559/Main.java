package baekjoon11559;
/* [����]
�ѿ�ѿ��� ���� ������ ����.

�ʵ忡 ���� ���� ������ �ѿ並 ���´�. �ѿ�� �߷��� ������ �޾� �Ʒ��� �ٴ��̳� �ٸ� �ѿ䰡 ���� ������ �Ʒ��� ��������.
�ѿ並 ���� �� ��, ���� �� �ѿ䰡 4�� �̻� �����¿�� ����Ǿ� ������ ����� ���� �� �ѿ���� �Ѳ����� ��������.
�ѿ���� �������� ���� ���� �ٸ� �ѿ���� �ִٸ�, ���� �߷��� ������ �޾� ���ʴ�� �Ʒ��� �������� �ȴ�.
�Ʒ��� �������� ���� �ٽ� ���� ���� �ѿ���� 4�� �̻� ���̰� �Ǹ� �� ������ �Ǵµ�, ���� �� �ѿ���� �������� �ٽ� ������ �ݺ��� ������ 1���⾿ �þ��.
���� �� �մ� �ѿ䰡 ���� �׷��� �ִٸ� ���ÿ� ������ �ϰ� ���� �׷��� �������� �ѹ��� ���Ⱑ �߰��ȴ�.

���Դ� �ֱ� �ѿ�ѿ� ���ӿ� ǫ ������. �� ������ 1:1�� �ٴ� ���������̶� �� �״� �͵� �߿�������, ������ �Ͷ߸��ٸ� ���Ⱑ �� ���� ���� �ٷ� �ľ��� �� �ִ� �ɷµ�
�ʿ��ϴ�. ������ ���� �Ƿ��� �����Ͽ� ���Դ� �ڱ� �ʵ忡�� �Ű� ���� �ٻڴ�. ������ �ʵ尡 �־����� ��, ���Ⱑ �� �� �������� �Ͼ�� ����Ͽ� ���Ը� ��������!
 */

/* [�Է�]
12*6�� ���ڰ� �־�����.
�̶� .�� ������̰� .�� �ƴѰ��� ������ ������ �ѿ並 ��Ÿ����.
R�� ����, G�� �ʷ�, B�� �Ķ�, P�� ����, Y�� ����̴�.(��� �빮�ڷ� �־�����.)
�Է����� �־����� �ʵ�� �ѿ���� ���� �Ʒ��� ������ ���� ����(�� �ѿ� �Ʒ��� �� ĭ�� �ִ� ���� ����) �̴�.
 */

/* [���]
���� �־��� ��Ȳ���� ��Ⱑ �Ǵ��� ����϶�. (�ϳ��� ������ �ʴ´ٸ� 0�� ����ϸ� �ȴ�.)
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
