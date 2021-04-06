import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int test = Integer.parseInt(br.readLine());
		String[] tmp = new String[test];
		for (int t = 0; t < test; t++) {
			tmp[t] = br.readLine();
		}
		Arrays.sort(tmp, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});
		for (int i = 1; i < test; i++) {
			// 중복되지않는 단어만 출력!
			if (!tmp[i].equals(tmp[i - 1])) {
				bw.write(tmp[i] + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
