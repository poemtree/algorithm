package baekjoon2667;

/* [����]
<�׸� 1>�� ���� ���簢�� ����� ������ �ִ�. 1�� ���� �ִ� ����, 0�� ���� ���� ���� ��Ÿ����. ö���� �� ������ ������ ����� ������ ������ ������
�����ϰ�, ������ ��ȣ�� ���̷� �Ѵ�. ���⼭ ����Ǿ��ٴ� ���� � ���� �¿�, Ȥ�� �Ʒ����� �ٸ� ���� �ִ� ��츦 ���Ѵ�. �밢���� ���� �ִ� ���
�� ����� ���� �ƴϴ�. <�׸� 2>�� <�׸� 1>�� �������� ��ȣ�� ���� ���̴�. ������ �Է��Ͽ� �������� ����ϰ�, �� ������ ���ϴ� ���� ���� ��������
���� �����Ͽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 */

/* [�Է�]
ù ��° �ٿ��� ������ ũ�� N(���簢���̹Ƿ� ���ο� ������ ũ��� ������ 5��N��25)�� �Էµǰ�, �� ���� N�ٿ��� ���� N���� �ڷ�(0Ȥ�� 1)�� �Էµȴ�.
 */

/* [���]
ù ��° �ٿ��� �� �������� ����Ͻÿ�. �׸��� �� ������ ���� ���� ������������ �����Ͽ� �� �ٿ� �ϳ��� ����Ͻÿ�.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static int n;
	public static char[][] map;
	public static int[][] visit;
	public static int[] dx = {0, 1, -1, 0};
	public static int[] dy = {-1, 0, 0, 1};
	public static int cntAddr;
	public static int cnt;
	public static ArrayList<Integer> cntAddrNum = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visit = new int[n][n];
		for(int i=0; i<n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		for(int i=0; i<n; i++) {
			for(int y=0; y<n; y++) {
				if(dfs(i, y)) {
					cntAddr++;
					cntAddrNum.add(cnt);
					cnt = 0;
				}
			}
		}
		System.out.println(cntAddr);
		Collections.sort(cntAddrNum);
		for(int i : cntAddrNum)
			System.out.println(i);
	}
	public static boolean dfs(int x, int y) {
		int nx;
		int ny;
		if(map[x][y]=='1' && visit[x][y] == 0 ) {
			visit[x][y]++;
			cnt++;
			for(int i=0; i<4; i++){
				nx = x + dx[i];
				ny = y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
					dfs(nx, ny);
				}
			};
			return true;
		} else {
			return false;
		}
	}
}