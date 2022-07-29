package com.greatlearning.graded.project2.que1;

import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the total no. of floors in building");

		int totalFloors = scan.nextInt();

		int[] floorSize = new int[totalFloors];

		insertFloorSize(floorSize, scan);

		int[] originalFloorSize = new int[totalFloors];

		for (int i = 0; i < totalFloors; i++) {
			originalFloorSize[i] = floorSize[i];
		}

		mergeSort(floorSize, 0, floorSize.length - 1);

		FloorArrangement.floorArrangement(originalFloorSize, floorSize);

		scan.close();

	}

	private static void insertFloorSize(int[] floorSize, Scanner scan) {

		for (int index = 0; index < floorSize.length; index++) {
			System.out.println("Enter the floor size given on day : " + (index + 1));
			floorSize[index] = scan.nextInt();
		}

	}

	private static void mergeSort(int[] arr, int left, int right) {

		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);

			mergeConquer(arr, left, mid, right);
		}

	}

	private static void mergeConquer(int[] arr, int left, int mid, int right) {

		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] leftArr = new int[n1];
		int[] rightArr = new int[n2];

		for (int i = 0; i < n1; i++) {
			leftArr[i] = arr[left + i];
		}
		for (int j = 0; j < n2; j++) {
			rightArr[j] = arr[mid + 1 + j];
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = left;

		while (i < n1 && j < n2) {
			if (leftArr[i] >= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
				k++;
			} else {
				arr[k] = rightArr[j];
				j++;
				k++;
			}
		}

		while (i < n1) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}

}
