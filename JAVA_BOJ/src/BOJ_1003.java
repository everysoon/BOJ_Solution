import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;

public class BOJ_1003 {
	static int[] dp; // 0�� 1�� ������ �迭

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Scanner sc = new Scanner(System.in);
		// int testCase = sc.nextInt();
		// Scanner�� BufferedReader���� ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int [][] memo = new int[41][2]; // �� ���ڰ� 0�� 1�� ����� �������� �迭�� �޸�
		memo[0][0] = 1;
		memo[1][1] = 1; // [0][1], [1][0]�� 0���� �ڵ��ʱ�ȭ��.
	
		int testCase = Integer.parseInt(br.readLine());
		for(int i=2; i<41; i++) {
			// 0�� 1�� �ʱ�ȭ������ i�� 2����
			for(int j=0; j<2; j++) {
				// 0���� 1���� Ȯ���ϱ����� j�� 0,1��
				memo[i][j] = memo[i-2][j]+ memo[i-1][j];
			}
		}
		
		for(int i=0; i<testCase; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(memo[n][0]+ " "+ memo[n][1]);
		}
	}

}
