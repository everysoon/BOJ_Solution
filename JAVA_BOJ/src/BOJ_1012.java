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

	// DFS ����
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());
		int ans = 0; // �������� ����
		for (int t = 0; t < test; t++) {
			st = new StringTokenizer(br.readLine());

			m = Integer.parseInt(st.nextToken()); // ���߹� ���α���
			n = Integer.parseInt(st.nextToken()); // ���߹� ���α���
			int k = Integer.parseInt(st.nextToken()); // ���� �ɾ����ִ� ��ġ ����
			arr = new boolean[n][m];
			check = new boolean[n][m];

			ans = 0;

			for (int i = 0; i < k; i++) {
				// ���� ��ġ �ޱ�
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				// x == ��, y == ��
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
		// ��ǥ ���� �߸��� ���
		if (row < 0 || row >= n || cal < 0 || cal >= m) {
			return false;
		}
		// �ٳ�� ��ǥ�� ��� || ���� �ƴѰ��
		if (check[row][cal] == true || arr[row][cal] == false) {
			return false;
		}
		return true;

	}

	public static void dfs(int x, int y) {
		// 1. ���� ��带 �湮ó���Ѵ�.
		// 2. ���� ��忡�� ��,��,��,���� ���� �� �� �ִ��� Ȯ���Ѵ�.(�̶� ������ �ʰ�����, ���� ���翩�θ� Ȯ��)
		// - �� �� �ִٸ� dfs()�޼ҵ带 ȣ���Ѵ�.
		// 3. 2���� �ݺ��Ͽ� �� �̻� �� �� �ִ� ��尡 ���� ������ �ݺ��Ѵ�.
		// - dfsȣ�� �ϳ��� ����Ǹ� ������ �Ѱ�(������ �Ѱ�)��� �����ϸ� ��!
		check[x][y] = true;
		// '��'
		if (checkLocation(x - 1, y)) {
			dfs(x - 1, y);
		}
		// '��'
		if (checkLocation(x + 1, y)) {
			dfs(x + 1, y);
		}
		// '��'
		if (checkLocation(x, y - 1)) {
			dfs(x, y - 1);
		}
		// '��'
		if (checkLocation(x, y + 1)) {
			dfs(x, y + 1);
		}
	}
}
