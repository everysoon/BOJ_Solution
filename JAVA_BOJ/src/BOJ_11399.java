import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());
		int[] p = new int[test]; // 돈 뽑는데 걸리는 시간 저장
		int[] min = new int[test];
		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int t = 0; t < test; t++) {
			p[t] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(p);
		min[0] = p[0];
		for (int i = 1; i < p.length; i++) {
			min[i] = p[i] + min[i - 1];
		}
		for (int i = 0; i < min.length; i++) {
			sum += min[i];
		}
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();

	}

}
