import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BOJ_1006 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 답은 나오는데 런타임 오류 (ArrayBoundOutOfIndex) 미 해결
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\n");
		int t = Integer.parseInt(input[0]);
		int count = 0;
		for (int i = 0; i < t; i++) {
			input = br.readLine().split(" ");
			int area = Integer.parseInt(input[0]);
			int w = Integer.parseInt(input[1]);
			
			int[] enemy1 = new int[area];
			int[] enemy2 = new int[area];
			int cnt[] = new int[area * 2];
			input = br.readLine().split(" ");
			
			for (int j = 0; j < area ; j++) {
				enemy1[j] = Integer.parseInt(input[j]);
			}
			input = br.readLine().split("\n");
			input = input[0].split(" ");

			for (int j = 0; j < area ; j++) {
				enemy2[j] = Integer.parseInt(input[j]);
	
			}
	
			for (int j = 0; j < area; j++) {
				if (j == 0) {
					if (enemy1[0] + enemy1[7] <= w) {
						cnt[0] = -1;
						cnt[7] = -1;
						count++;
//						j++;
					}
					if (enemy2[0] + enemy2[7] <= w) {
						cnt[8] = -1;
						cnt[15] = -1;
						count++;
//						j++;
					}
				}
				if (j <= 7) {
					if (enemy1[j] + enemy2[j] <= w) {
						cnt[j] = -1;
						cnt[j + 8] = -1;
						count++;
						j++;

					}
				}
				if (j < 7 && j >= 1) {
					if (enemy1[j] + enemy1[j + 1] <= w) {
						cnt[j] = -1;
						cnt[j + 1] = -1;
						count++;

					}
					if (enemy2[j] + enemy2[j + 1] <= w) {
						cnt[j] = -1;
						cnt[j + 1] = -1;
						count++;
					}
					j++;

				}

			}
			for (int j = 0; j < area * 2; j++) {
				if (cnt[j] == 0) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}