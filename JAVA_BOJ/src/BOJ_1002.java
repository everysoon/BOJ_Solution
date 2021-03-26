import java.util.Scanner;

public class BOJ_1002 {
	public static void main(String[] args) {
		// 풀이참고함
		// 두 원의 반지름의 중점 사이의 거리를 d 라고 하자
		// 1. 원이 두 점에서 만나는 경우 r2-r1<d<r1+r2
		// 2. 두 원이 외접하는 경우(한 점에서 만남) d = r1+r2
		// 3. 두 원이 내접하는 경우(한 점에서 만남) d = r2-r1 과 d !=0
		// 4. 하나의 원이 다른원을 포함하는 경우(안 만남) d<r2-r1
		// 5. 두 원이 멀리 떨어져 만나지않는 경우 d> r1+r2
		// 6. 두 원이 일치하는경우( 무수히 많은 점에서 만남) d=0, r1=r2
		// sqrt는 루트 , pow는 제곱함수, abs는 절대값 함수
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double d = 0;
		for (int i = 0; i < n; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			d = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
			if(r1+r2 < d) {
				//두 원이 멀리 떨어져서 안 만남
				System.out.println("0");
			}else if(Math.abs(r1-r2)>d) {
				// 하나의 원이 다른원을 포함
				System.out.println("0");
			}else if(d==0 && r1== r2) {
				//두 원이 일치
				System.out.println("-1");
			}else if(d== (r1+r2)) {
				//두 원이 내접
				System.out.println("1");
			}else if(d == Math.abs(r1-r2)) {
				//두 원이 외접
				System.out.println("1");
			}else {
				//원이 두 점에서 만나는 경우
				System.out.println("2");
			}
			
		}
		sc.close();
	}
}
