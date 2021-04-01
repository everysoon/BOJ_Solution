import java.util.LinkedList;
import java.util.Queue;

public class DFS_BFS {
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int M, N; // M은 가로 N은 세로길이

	public static void main(String[] args) {
		// arr가 0으로 모두 초기화되어있다고 하고, 1이 있는 상하좌우를 검사하는 dfs,bfs
	}

	public static void dfs(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			// 상하좌우 확인해주기
			int cx = x + dx[i];
			int cy = y + dy[i];
			if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
				if (!visit[cx][cy] && arr[cx][cy] == 1) {
					dfs(cx, cy);
				}
			}
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> qu = new LinkedList<int[]>();
		qu.add(new int[] { x, y });
		while (!qu.isEmpty()) {
			// 큐가 비었을 때 까지 반복
			x = qu.peek()[0];
			y = qu.peek()[1];
			visit[x][y] = true;
			qu.poll(); // 큐에서 추출
			for (int i = 0; i < 4; i++) {
				// 상하좌우 검사
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
					if (!visit[cx][cy] && arr[cx][cy] == 1) {
						// 방문하지 않는 노드면 방문한 것으로 표시하고 큐에 삽입.
						qu.add(new int[] { cx, cy });
						dfs(cx, cy);
					}
				}
			}
		}
	}
}
