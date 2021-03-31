import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1011 {
	public static void main(String[] args) throws IOException {
		// 1. 거리의 개수, 최대값(이동한 거리의 값들 중 최대값)이 2번 나타나며 1씩 증가
		// 2. 거리의 범위에서 최대값의 제곱하면 해당범위의 첫번째를 나타냄
		// 3. 최대값은 거리의 제곱근의 반올림을 하면 구할 수 있다.
		// 4. 작동횟수는 거리 > 최대값 제곱이면 최대값 *2
		//			  거리 <= 최대값 제곱이면 최대값*2-1
		// ex) 최대값 6 -> 36 (31~36),(37~42)
		// ex) 최대값 7 -> 49 (43~49),(50~56)
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 0; t < test; t++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			System.out.println(count(x,y));
		}

// 		아래는 민선 풀이 : 시간초과에러남 ㅠㅠ
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int test = Integer.parseInt(st.nextToken());
//		int x, y, cnt, step, distance, sum;
//		for (int t = 0; t < test; t++) {
//			st = new StringTokenizer(br.readLine());
//			x = Integer.parseInt(st.nextToken());
//			y = Integer.parseInt(st.nextToken());
//			cnt = 1;// 장치 작동 횟수 (마지막은 꼭 1광년 이동하기 때문에 1로 초기화)
//			step = 1;// 이동하는 광년의 수
//			distance = y - x; // 마지막은 꼭 1광년 이동하기 때문에 -1 뺀 합을 구함
//			sum = 1; // 이동한 광년의 합
//			while (true) {
//				if (step == 1) {
//					sum += 1;
//				} else if (step == 2) {
//					sum += 2;
//				}
//				cnt++;
//				if (distance == sum) {
//					break;
//				}
//				if (distance - sum == 2 || (distance - sum) % 2 == 0) {
//					step = 2;
//				} else if (distance - sum == 1 || (distance - sum) % 2 == 1) {
//					step = 1;
//				}
//			}
//			// System.out.println(cnt);
//			bw.write(cnt);
//		}
//
//		bw.flush();
//		br.close();
//		bw.close();

	}

	public static int count(double x, double y) {
		double distance = y - x;
		double max = Math.round(Math.sqrt(distance));
		if (distance > Math.pow(max, 2)) {
			return (int) max * 2;
		} else {
			return (int) max * 2 - 1;
		}
	}
}
