import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1012 {
	static boolean check[][];
	static boolean arr[][];
	static int n, m;

	// DFS 문제
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());
		int ans = 0; // 지렁이의 개수
		for (int t = 0; t < test; t++) {
			st = new StringTokenizer(br.readLine());

			m = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
			n = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
			int k = Integer.parseInt(st.nextToken()); // 배추 심어져있는 위치 개수
			arr = new boolean[n][m];
			check = new boolean[n][m];

			ans = 0;

			for (int i = 0; i < k; i++) {
				// 배추 위치 받기
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				// x == 열, y == 행
				arr[y][x] = true;

			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (checkLocation(i, j) == true) {
						ans++;
						dfs(i, j);
					}
				}
			}
			bw.write(String.valueOf(ans) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean checkLocation(int row, int cal) {
		// 좌표 값이 잘못된 경우
		if (row < 0 || row >= n || cal < 0 || cal >= m) {
			return false;
		}
		// 다녀온 좌표일 경우 || 밭이 아닌경우
		if (check[row][cal] == true || arr[row][cal] == false) {
			return false;
		}
		return true;

	}

	public static void dfs(int x, int y) {
		// 1. 현재 노드를 방문처리한다.
		// 2. 현재 노드에서 상,하,좌,우의 노드로 갈 수 있는지 확인한다.(이때 범위의 초과여부, 배추 존재여부를 확인)
		// - 갈 수 있다면 dfs()메소드를 호출한다.
		// 3. 2번을 반복하여 더 이상 갈 수 있는 노드가 없을 때까지 반복한다.
		// - dfs호출 하나가 종료되면 구역이 한개(지렁이 한개)라고 생각하면 됨!
		check[x][y] = true;
		// '상'
		if (checkLocation(x - 1, y)) {
			dfs(x - 1, y);
		}
		// '하'
		if (checkLocation(x + 1, y)) {
			dfs(x + 1, y);
		}
		// '좌'
		if (checkLocation(x, y - 1)) {
			dfs(x, y - 1);
		}
		// '우'
		if (checkLocation(x, y + 1)) {
			dfs(x, y + 1);
		}
	}
}
