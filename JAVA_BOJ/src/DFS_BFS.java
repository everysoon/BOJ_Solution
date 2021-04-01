import java.util.LinkedList;
import java.util.Queue;

public class DFS_BFS {
	static int[][] arr;
	static boolean[][] visit;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int M, N; // M�� ���� N�� ���α���

	public static void main(String[] args) {
		// arr�� 0���� ��� �ʱ�ȭ�Ǿ��ִٰ� �ϰ�, 1�� �ִ� �����¿츦 �˻��ϴ� dfs,bfs
	}

	public static void dfs(int x, int y) {
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			// �����¿� Ȯ�����ֱ�
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
			// ť�� ����� �� ���� �ݺ�
			x = qu.peek()[0];
			y = qu.peek()[1];
			visit[x][y] = true;
			qu.poll(); // ť���� ����
			for (int i = 0; i < 4; i++) {
				// �����¿� �˻�
				int cx = x + dx[i];
				int cy = y + dy[i];

				if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
					if (!visit[cx][cy] && arr[cx][cy] == 1) {
						// �湮���� �ʴ� ���� �湮�� ������ ǥ���ϰ� ť�� ����.
						qu.add(new int[] { cx, cy });
						dfs(cx, cy);
					}
				}
			}
		}
	}
}
