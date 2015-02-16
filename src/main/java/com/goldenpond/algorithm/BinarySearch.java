package com.goldenpond.algorithm;

public class BinarySearch {

	public int search(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while(low <= high) {
			int mid = (high + low)/2;
			int midVal = a[mid];
			if (midVal > key) {
				high = mid - 1;
			} else if (midVal < key){
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
