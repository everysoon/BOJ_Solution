import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2751 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());
		int[] arr = new int[test];
		for (int t = 0; t < test; t++) {
			st = new StringTokenizer(br.readLine());
			arr[t] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
