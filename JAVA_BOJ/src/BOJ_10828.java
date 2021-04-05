import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_10828 {
	static int top = -1;
	static int[] arr = new int[10000];
	static int size = 0;
// 스택 구현하기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int test = Integer.parseInt(st.nextToken());

		for (int t = 0; t < test; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			if (st.countTokens() == 1) {
				int x = Integer.parseInt(st.nextToken());
				push(x);
			} else {
				if (command.equals("top")) {
					System.out.println(top() + "");
				} else if (command.equals("size")) {
					System.out.println(size() + "");
				} else if (command.equals("pop")) {
					System.out.println(pop() + "");
				} else if (command.equals("empty")) {
					System.out.println(isEmpty() + "");
				}
			}
		}
	}

	public static int top() {
		if (top == -1) {
			return -1;
		} else {
			return arr[top];
		}
	}

	public static void push(int x) {
		arr[++top] = x;
		++size;
	}

	public static int pop() {
		if (top == -1) {
			return -1;
		}
		--size;
		return arr[top--];
	}

	public static int isEmpty() {
		if (top == -1) {
			return 1;
		}
		return 0;
	}

	public static int size() {
		return size;
	}

}
