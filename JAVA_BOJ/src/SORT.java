
public class SORT {
// ��������, ��������, ��������, ������, ��������, ������, ������� �ڵ�����

	// ��������
	public static void bubbleSort(int list[], int n) {
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (list[j] > list[j + 1]) {
					int tmp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = tmp;
				}
			}
		}
	}

	// ��������
	public static void selectionSort(int list[], int n) {
		int min; // �ּҰ�
		for (int i = 0; i < n - 2; i++) {
			min = i;
			for (int j = i + 1; j < n - 1; j++) {
				if (list[min] > list[j]) {
					min = j;
					int tmp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = tmp;
				}
			}
		}
	}

	// ��������
	public static void insertionSort(int list[], int n) {
		int i, j, temp;
		for (i = 1; i < n; i++) {
			temp = list[i];
			for (j = i - 1; j >= 0 && list[j] > temp; j--) {
				list[j + 1] = list[j];
			}
			list[j + 1] = temp;
		}
	}

	// ���������� ������� ���ĵ� �迭�� ���ؼ��� ���� ������ ���� : ���ԵǾ�� �� ��ġ�� ���� ��ġ�� ���� �������� �ӵ� �����ɸ�
	// 1. �����ؾ� �� ����Ʈ�� ������ ���ؿ� ���� �з�
	// 2. ���������� ���� �������� �κ� ����Ʈ ����
	// 3. �� �κ� ����Ʈ�� ���������̿��ؼ� ����
	// 4. ��� �κ� ����Ʈ�� ���ĵǸ� �ٽ� ��ü����Ʈ�� �� ���� ������ �κи���Ʈ�� ���� �� �˰��� �ݺ� (����Ʈ ���� 1�϶� ���� �ݺ�)
	public static void shellSort(int list[], int n) {
		int k = n / 2; // �ʱ� ���ݰ��� ������ ��
		int i, j;
		while (k > 0) {
			for (i = k; i < n; i++) {
				int temp = list[i];
				for (j = i - k; j >= 0 && list[j] > temp; j = j - k) {
					list[j + k] = list[j];
				}
				list[j + k] = temp;
			}
			k = k / 2;
		}
	}

	public static void merge(int list[], int left, int mid, int right) {
		int[] sorted = new int[list.length];
		int i = left;
		int j = mid + 1;
		int k = left;
		while (i <= mid && j <= right) {
			if (list[i] <= list[j]) {
				sorted[k++] = list[i++];
			} else {
				sorted[k++] = list[j++];
			}
		}
		if (i > mid) {
			for (int l = j; l < right; l++) {
				sorted[k++] = list[l];
			}
		} else {
			for (int l = i; l < mid; l++) {
				sorted[k++] = list[l];
			}
		}
		for (int l = left; l <= right; l++) {
			list[l] = sorted[l];
		}
	}

	public static void mergeSort(int list[], int left, int right) {
		int mid;
		if (left < right) {
			mid = (left + right) / 2;
			mergeSort(list, left, mid);
			mergeSort(list, mid + 1, right);
			merge(list, left, mid, right);
		}
	}

	public static void quickSort(int list[], int left, int right) {
		if (left < right) {
			int pivot = list[left]; // pivot�� ù ��°����
			int i = left;
			int j = right + 1;
			int temp;
			do {
				do {
					++i;
				} while (i <= right && list[i] < pivot);
				do {
					--j;
				} while (j >= left && list[j] > pivot);
				if(i<j) {
					temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}else {
					// ������ ���¸� pivot���� ��ü
					temp = list[j];
					list[j] = list[pivot];
					list[pivot] = temp;
				}
			} while (i < j);
			temp = list[left];
			list[left] = list[j];
			list[j] = temp;
			quickSort(list, left, j-1);
			quickSort(list, j+1, right);
		}
	}

	
}
