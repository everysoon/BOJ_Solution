
public class SORT {
// 버블정렬, 선택정렬, 삽입정렬, 쉘정렬, 병합정렬, 퀵정렬, 기수정렬 코드정리

	// 버블정렬
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

	// 선택정렬
	public static void selectionSort(int list[], int n) {
		int min; // 최소값
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

	// 삽입정렬
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

	// 삽입정렬이 어느정도 정렬된 배열에 대해서만 빠른 단점을 보안 : 삽입되어야 할 위치가 현재 위치랑 많이 떨어지면 속도 오래걸림
	// 1. 정렬해야 할 리스트를 일정한 기준에 따라 분류
	// 2. 연속적이지 않은 여러개의 부분 리스트 생성
	// 3. 각 부분 리스트를 삽입정렬이용해서 정렬
	// 4. 모든 부분 리스트가 정렬되면 다시 전체리스트를 더 적은 개수의 부분리스트로 만든 후 알고리즘 반복 (리스트 개수 1일때 까지 반복)
	public static void shellSort(int list[], int n) {
		int k = n / 2; // 초기 간격값은 길이의 반
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
			int pivot = list[left]; // pivot은 첫 번째원소
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
					// 엇갈린 상태면 pivot값과 교체
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
