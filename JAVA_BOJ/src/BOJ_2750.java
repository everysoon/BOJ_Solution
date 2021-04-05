import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2750 {
	public static void main(String[] args) throws IOException {
		// N개의 수 오름차순 정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());
		int[] arr = new int[test];

		for (int t = 0; t < test; t++) {
			st = new StringTokenizer(br.readLine());
			arr[t] = Integer.parseInt(st.nextToken());
		}
//		Arrays.sort(arr); //<- 이게 더 빨라!
		for (int i = 0; i < arr.length; i++) {
		for (int j = i+1; j < arr.length; j++) {
			if (arr[i] > arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
	}
		for (int t = 0; t < test; t++) {
			bw.write(arr[t] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
