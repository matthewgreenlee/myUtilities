package com.goldenpond.algorithm;

public class MergeSort {

	public void sort(int[] a) {
		int[] temp = new int[a.length];
		merge(a, temp, 0, a.length-1);
	}
	
	private void merge(int[] data, int[] temp, int low, int high) {
		if (low == high) {
			return;
		}
		int mid = (low + high)/2;
		merge(data, temp, low, mid);
		merge(data, temp, mid+1, high);
		for (int i = low; i <= high; i++) {
			temp[i] = data[i];
		}
		int j = low;
		int k = mid+1;
		for(int cur = low; cur <= high; cur++) {
			if (j > mid) {
				data[cur] = temp[k++];
			} else if (k > high) {
				data[cur] = temp[j++];
			} else if (temp[j] < temp[k]) {
				data[cur] = temp[j++];
			} else {
				data[cur] = temp[k++];
			}
		}
	}
}
