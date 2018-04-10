package baekjoon1012;

/* [����]
������ ������ �ѳ��� ������ �������� ����� ���߸� ����ϱ�� �Ͽ���. ����� ���� �ʰ� ���߸� ����Ϸ��� ���߸� �������κ��� ��ȣ�ϴ� ����
�߿��ϱ� ������, �ѳ��� ���� ������ ȿ������ �����������̸� �����ϱ�� ����Ѵ�. �� �����̴� ���߱�ó�� �����ϸ� ������ ��� �������ν� ���߸�
��ȣ�Ѵ�. Ư��, � ���߿� �����������̰� �� ������ ��� ������ �� �����̴� ������ �ٸ� ���߷� �̵��� �� �־�, �� ���ߵ� ���� �������� ����
��ȣ���� �� �ִ�.

(�� ������ �����¿� �� ���⿡ �ٸ� ���߰� ��ġ�� ��쿡 ���� �������ִٰ� �����Ѵ�)

�ѳ��� ���߸� ����ϴ� ���� ���� ���ؼ� ���߸� �������� �ɾ���Ҵ�. ���ߵ��� ���ִ� ������ �����������̰� �� ������ ������ �ǹǷ� ���� ����
���ִ� ���ߵ��� �� ������ �����ִ��� �����ϸ� �� �� ������ �����̰� �ʿ����� �� �� �ִ�.

���� ��� ���߹��� �Ʒ��� ���� �����Ǿ� ������ �ּ� 5������ �����������̰� �ʿ��ϴ�.

(0�� ���߰� �ɾ��� ���� ���� ���̰�, 1�� ���߰� �ɾ��� �ִ� ���� ��Ÿ����.)
 */

/* [�Է�]
�Է��� ù �ٿ��� �׽�Ʈ ���̽��� ���� T�� �־�����. �� ���� �ٺ��� ������ �׽�Ʈ ���̽��� ���� ù° �ٿ��� ���߸� ���� ���߹��� ���α��� M(1 �� M �� 50)��
���α��� N(1 �� N �� 50), �׸��� ���߰� �ɾ��� �ִ� ��ġ�� ���� K(1 �� K �� 2500)�� �־�����. �� ���� K�ٿ��� ������ ��ġ X(0 �� X �� M-1), Y(0 �� Y �� N-1)�� �־�����.
 */

/*
�� �׽�Ʈ ���̽��� ���� �ʿ��� �ּ��� ������������ ���� ���� ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	
	static int[][] map = null;
	static int[][] visit = null;
	static int k[][] = null;
	static int dx[] = {0, 1, -1, 0};
	static int dy[] = {-1, 0, 0, 1};
	static int m = 0;
	static int n = 0;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=Integer.parseInt(st.nextToken()); i>0; i--) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = new int[Integer.parseInt(st.nextToken())][2];
			map = new int[m][n];
			visit = new int[m][n];
			for(int y = 0; y<k.length; y++) {
				st = new StringTokenizer(br.readLine());
				k[y][0] =  Integer.parseInt(st.nextToken());
				k[y][1] =  Integer.parseInt(st.nextToken());
				map[k[y][0]][k[y][1]]+=1;				
			};
			for(int y=0; y<k.length; y++){
				if(dfs(k[y][0],k[y][1]))
					cnt++;
			};
			System.out.println(cnt);
			cnt=0;
		};
		br.close();
	}
	
	public static boolean dfs(int x, int y){
		if(visit[x][y]==0&&map[x][y]==1) {
			visit[x][y]++;
			for(int i=0; i<4; i++){
				if(dx[i]+x >= 0 && dy[i]+y >= 0 && dx[i]+x < m && dy[i]+y < n )
					dfs(dx[i]+x, dy[i]+y);
			}
			return true;
		} else {
			return false;
		}
	}	
}