import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1011 {
	public static void main(String[] args) throws IOException {
		// 1. �Ÿ��� ����, �ִ밪(�̵��� �Ÿ��� ���� �� �ִ밪)�� 2�� ��Ÿ���� 1�� ����
		// 2. �Ÿ��� �������� �ִ밪�� �����ϸ� �ش������ ù��°�� ��Ÿ��
		// 3. �ִ밪�� �Ÿ��� �������� �ݿø��� �ϸ� ���� �� �ִ�.
		// 4. �۵�Ƚ���� �Ÿ� > �ִ밪 �����̸� �ִ밪 *2
		//			  �Ÿ� <= �ִ밪 �����̸� �ִ밪*2-1
		// ex) �ִ밪 6 -> 36 (31~36),(37~42)
		// ex) �ִ밪 7 -> 49 (43~49),(50~56)
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 0; t < test; t++) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			System.out.println(count(x,y));
		}

// 		�Ʒ��� �μ� Ǯ�� : �ð��ʰ������� �Ф�
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int test = Integer.parseInt(st.nextToken());
//		int x, y, cnt, step, distance, sum;
//		for (int t = 0; t < test; t++) {
//			st = new StringTokenizer(br.readLine());
//			x = Integer.parseInt(st.nextToken());
//			y = Integer.parseInt(st.nextToken());
//			cnt = 1;// ��ġ �۵� Ƚ�� (�������� �� 1���� �̵��ϱ� ������ 1�� �ʱ�ȭ)
//			step = 1;// �̵��ϴ� ������ ��
//			distance = y - x; // �������� �� 1���� �̵��ϱ� ������ -1 �� ���� ����
//			sum = 1; // �̵��� ������ ��
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
