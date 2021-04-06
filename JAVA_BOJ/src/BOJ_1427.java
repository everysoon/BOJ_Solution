import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String num = st.nextToken();
		char[] ch = num.toCharArray();
		Integer[] arr = new Integer[ch.length];
		for (int i = 0; i < ch.length; i++) {
			arr[i] = ch[i] - 48; // char -> intº¯È¯
		}
		Arrays.sort(arr, Collections.reverseOrder());
		for (int i = 0; i < arr.length; i++) {
			bw.write(String.valueOf(arr[i]));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
