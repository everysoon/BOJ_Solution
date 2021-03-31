import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1010 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\n");
		int test = Integer.parseInt(input[0]);
		long[][] d ; 
		// 조합 : nCr (서로 다른 n개에서 r(n>=r)를 택하는 경우
		// 서쪽에는 n개의 사이트(다리 짓기 좋은 곳), 동쪽에는 m개의 사이트
		// 한 사이트에는 최대 한개의 다리만 연결 가능
		// n<=m 이라 최대로 다리를 지으려면 n개만큼 지어야 함.
		// 주의사항 * 다리는 겹쳐질 수 없음.
		//       * int로 놓으면 범위에 벗어나서 long으로 해줘야 함!!! ㅠㅠ
		for (int t = 0; t < test; t++) {
			input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			d = new long [n+1][m+1];
			for (int i = 0; i <= m; i++) {
				// n이 1이면 m개의 개수만큼 지을수 있는 경우의 수가 있기때문에 d[1][i]를 모두 i(m)의 수로 초기화
				d[1][i] = i;
			}

			// ex) d[n][m] = n개의 사이트와 m개의 사이트를 잇는 모든 경우의 수
			// ex) n = 2이고 m = 4라면, d[2][4] = ( d[1][3]+ d[1][2] + d[1][1] )
			for (int i = 2; i <= n; i++) {
				for (int j = i; j <= m; j++) {
					// j=i 부터 시작하는이유 : 한 군데에 여러 다리를 잇는 경우이라 불가능!
					for (int k = j; k >= i; k--) {
						// k의 반복범위가 k>=i인 이유 : 한 군데에 여러 다리를 잇는 경우이라 불가능!
						d[i][j] += d[i - 1][k - 1];
					}
				}
			}

			System.out.println(d[n][m]);

		}
	}
}
