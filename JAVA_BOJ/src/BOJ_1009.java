import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_1009 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int a, b, r;
		for (int j = 0; j < T; j++) {
			a = s.nextInt();
			b = s.nextInt();
			r = 1;

			for (int i = 0; i < b; i++) {
				r = (r * a) % 10; // 그냥 곱하면 범위 수를 넘어버리기 때문에 10씩 나눠생긴 나머지를 다시 곱함
			}
			if (r == 0) {
				r = 10;
			}
			System.out.println(r);
		}
		s.close();
//			if (a <= 10 && b <= 10) {
//				if (a == 1) {
//					System.out.println((int) a);
//				} else {
//					int data = (int) Math.pow(a, b);
//					System.out.println((int) (data % 10));
//				}
//			} else {
//				switch (a) {
//				case 2:
//					if (b % 4 == 0) {
//						System.out.println("2");
//					} else if (b % 4 == 1) {
//						System.out.println("4");
//					} else if (b % 4 == 2) {
//						System.out.println("8");
//					} else if (b % 4 == 3) {
//						System.out.println("6");
//					}
//					break;
//				case 3:
//					if (b % 4 == 0) {
//						System.out.println("3");
//					} else if (b % 4 == 1) {
//						System.out.println("9");
//					} else if (b % 4 == 2) {
//						System.out.println("7");
//					} else if (b % 4 == 3) {
//						System.out.println("1");
//					}
//					break;
//				case 4:
//					if (b % 4 == 0) {
//						System.out.println("4");
//					} else if (b % 4 == 1) {
//						System.out.println("6");
//					}
//					break;
//				case 5:
//					System.out.println("5");
//					break;
//				case 6:
//					System.out.println("6");
//					break;
//				case 7:
//					if (b % 4 == 0) {
//						System.out.println("1");
//					} else if (b % 4 == 3) {
//						System.out.println("3");
//					} else if (b % 4 == 2) {
//						System.out.println("2");
//					} else if (b % 4 == 1) {
//						System.out.println("10");
//					}
//					break;
//				case 8:
//					if (b % 4 == 0) {
//						System.out.println("6");
//					} else if (b % 4 == 3) {
//						System.out.println("2");
//					} else if (b % 4 == 2) {
//						System.out.println("4");
//					} else if (b % 4 == 1) {
//						System.out.println("8");
//					}
//					break;
//				case 9:
//					if (b % 4 == 0) {
//						System.out.println("9");
//					} else {
//						System.out.println("1");
//					}
//					break;
//
//				}
//			}
//		}

	}
}
