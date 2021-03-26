import java.util.Scanner;

public class BOJ_1002 {
	public static void main(String[] args) {
		// Ǯ��������
		// �� ���� �������� ���� ������ �Ÿ��� d ��� ����
		// 1. ���� �� ������ ������ ��� r2-r1<d<r1+r2
		// 2. �� ���� �����ϴ� ���(�� ������ ����) d = r1+r2
		// 3. �� ���� �����ϴ� ���(�� ������ ����) d = r2-r1 �� d !=0
		// 4. �ϳ��� ���� �ٸ����� �����ϴ� ���(�� ����) d<r2-r1
		// 5. �� ���� �ָ� ������ �������ʴ� ��� d> r1+r2
		// 6. �� ���� ��ġ�ϴ°��( ������ ���� ������ ����) d=0, r1=r2
		// sqrt�� ��Ʈ , pow�� �����Լ�, abs�� ���밪 �Լ�
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
				//�� ���� �ָ� �������� �� ����
				System.out.println("0");
			}else if(Math.abs(r1-r2)>d) {
				// �ϳ��� ���� �ٸ����� ����
				System.out.println("0");
			}else if(d==0 && r1== r2) {
				//�� ���� ��ġ
				System.out.println("-1");
			}else if(d== (r1+r2)) {
				//�� ���� ����
				System.out.println("1");
			}else if(d == Math.abs(r1-r2)) {
				//�� ���� ����
				System.out.println("1");
			}else {
				//���� �� ������ ������ ���
				System.out.println("2");
			}
			
		}
		sc.close();
	}
}
