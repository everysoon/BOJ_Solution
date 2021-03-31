import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1010 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\n");
		int test = Integer.parseInt(input[0]);
		long[][] d ; 
		// ���� : nCr (���� �ٸ� n������ r(n>=r)�� ���ϴ� ���
		// ���ʿ��� n���� ����Ʈ(�ٸ� ���� ���� ��), ���ʿ��� m���� ����Ʈ
		// �� ����Ʈ���� �ִ� �Ѱ��� �ٸ��� ���� ����
		// n<=m �̶� �ִ�� �ٸ��� �������� n����ŭ ����� ��.
		// ���ǻ��� * �ٸ��� ������ �� ����.
		//       * int�� ������ ������ ����� long���� ����� ��!!! �Ф�
		for (int t = 0; t < test; t++) {
			input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			d = new long [n+1][m+1];
			for (int i = 0; i <= m; i++) {
				// n�� 1�̸� m���� ������ŭ ������ �ִ� ����� ���� �ֱ⶧���� d[1][i]�� ��� i(m)�� ���� �ʱ�ȭ
				d[1][i] = i;
			}

			// ex) d[n][m] = n���� ����Ʈ�� m���� ����Ʈ�� �մ� ��� ����� ��
			// ex) n = 2�̰� m = 4���, d[2][4] = ( d[1][3]+ d[1][2] + d[1][1] )
			for (int i = 2; i <= n; i++) {
				for (int j = i; j <= m; j++) {
					// j=i ���� �����ϴ����� : �� ������ ���� �ٸ��� �մ� ����̶� �Ұ���!
					for (int k = j; k >= i; k--) {
						// k�� �ݺ������� k>=i�� ���� : �� ������ ���� �ٸ��� �մ� ����̶� �Ұ���!
						d[i][j] += d[i - 1][k - 1];
					}
				}
			}

			System.out.println(d[n][m]);

		}
	}
}
