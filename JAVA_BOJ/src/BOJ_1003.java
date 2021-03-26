import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.IOException;

public class BOJ_1003 {
	static int[] dp; // 0과 1을 저장할 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Scanner sc = new Scanner(System.in);
		// int testCase = sc.nextInt();
		// Scanner는 BufferedReader보다 느리다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int [][] memo = new int[41][2]; // 각 숫자가 0과 1이 몇번씩 나오는지 배열에 메모
		memo[0][0] = 1;
		memo[1][1] = 1; // [0][1], [1][0]은 0으로 자동초기화됨.
	
		int testCase = Integer.parseInt(br.readLine());
		for(int i=2; i<41; i++) {
			// 0과 1은 초기화했으니 i는 2부터
			for(int j=0; j<2; j++) {
				// 0인지 1인지 확인하기위해 j는 0,1만
				memo[i][j] = memo[i-2][j]+ memo[i-1][j];
			}
		}
		
		for(int i=0; i<testCase; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(memo[n][0]+ " "+ memo[n][1]);
		}
	}

}
