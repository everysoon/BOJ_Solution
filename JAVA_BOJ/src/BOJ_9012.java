import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 괄호문자열(VPS)인지 아닌지 판별하기
public class BOJ_9012 {
	static char[] vps = new char[51];
	static int top = -1;
	static char ch, popData;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());
		for (int t = 0; t < test; t++) {
			vps = new char[51];
			top = -1;
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			String vpsStr = st.nextToken();
			vps = vpsStr.toCharArray();
			String result = checkVPS(vps.length);
			bw.write(result);
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static String checkVPS(int len) {
		if (len % 2 == 0) {
			for (int i = 0; i < len; i++) {
				ch = vps[i];
				switch (ch) {
				case '(':
					++cnt;
					break;
				case ')':
					--cnt;
					if (cnt < 0) {
						return "NO\n";
					}
					break;
				}
			}
			if (cnt != 0) {
				return "NO\n";
			} else {
				return "YES\n";
			}
		} else {
			return "NO\n";
		}
	}
}
