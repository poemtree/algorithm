package baekjoon10026;

/* [����]
���ϻ����� �������� �ʷϻ��� ���̸� ���� ������ ���Ѵ�. ����, ���ϻ����� ����� ���� �׸��� �ƴ� ����� ���� �׸����� �� �ٸ� �� �ִ�.

ũ�Ⱑ N��N�� �׸����� �� ĭ�� R(����), G(�ʷ�), B(�Ķ�) �� �ϳ��� ��ĥ�� �׸��� �ִ�. �׸��� �� ���� �������� �������� �ִµ�, ������ ����
������ �̷���� �ִ�. ��, ���� ������ �����¿�� ������ �ִ� ��쿡 �� ���ڴ� ���� ������ ���Ѵ�. (������ ���̸� ���� ������ ���ϴ� ��쵵 ���� �����̶� �Ѵ�)

���� ���, �׸��� �Ʒ��� ���� ��쿡

RRRBB
GGBBB
BBBRR
BBRRR
RRRRR

���ϻ����� �ƴ� ����� ���� �� ������ ���� �� 4���̴�. (���� 2, �Ķ� 1, �ʷ� 1) ������, ���ϻ����� ����� ������ 3�� �� �� �ִ�. (����-�ʷ� 2, �Ķ� 1)

�׸��� �Է����� �־����� ��, ���ϻ����� ����� ���� ���� �ƴ� ����� ���� �� ������ ���� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

/* [�Է�]
ù° �ٿ� N�� �־�����. (1 �� N �� 100)

��° �ٺ��� N�� �ٿ��� �׸��� �־�����.
 */

/* [���]
���ϻ����� �ƴ� ����� ���� ���� ������ ������ ���ϻ����� ����� ���� ���� ������ ���� �������� ������ ����Ѵ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static int n;
	public static char[][] grid;
	public static int[][] visit;
	public static int[] dx = {0, 1, -1, 0};
	public static int[] dy = {-1, 0, 0, 1};
	public static int cntNonBlind;
	public static int cntBlind;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		grid = new char[n][n];
		visit = new int[n][n];
		for(int i=0; i<n; i++) {
			grid[i] = br.readLine().toCharArray();
		}
		for(int i=0; i<n; i++) {
			for(int y=0; y<n; y++) {
				cntNonBlind += dfsNonBlind(grid[i][y], i, y)?1:0;
			}
		}
		System.out.print(cntNonBlind+ " ");
		visit = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int y=0; y<n; y++) {
				cntBlind += dfsBlind(grid[i][y], i, y)?1:0;
			}
		}
		System.out.print(cntBlind);
		br.close();
	}
	public static boolean dfsNonBlind(char c, int x, int y) {
		int nx;
		int ny;
		if(grid[x][y]==c && visit[x][y] == 0 ) {
			visit[x][y]++;
			for(int i=0; i<4; i++){
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					dfsNonBlind(grid[x][y], nx, ny);
				}
			};
			return true;
		} else {
			return false;
		}
	}
	public static boolean dfsBlind(int c, int x, int y) {
		int nx;
		int ny;
		if((grid[x][y] == c || grid[x][y]-c == 11 || grid[x][y]-c == -11)&& visit[x][y] == 0 ) {
			visit[x][y]++;
			for(int i=0; i<4; i++){
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					dfsBlind(grid[x][y], nx, ny);
				}
			}
			return true;
		} else {
			return false;
		}
	}
}