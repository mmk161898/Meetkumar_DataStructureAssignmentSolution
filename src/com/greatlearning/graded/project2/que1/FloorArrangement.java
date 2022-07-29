package com.greatlearning.graded.project2.que1;

import java.util.Stack;

public class FloorArrangement {

	/**
	 * This method is used to check at which day which floor needs to build
	 */
	public static void floorArrangement(int[] originalFloorSize, int[] floorSize) {
		System.out.println("The order of construction is as follows \n");
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		for (int index = 0; index < originalFloorSize.length; index++) {
			if (originalFloorSize[index] == floorSize[i]) {
				System.out.println("Day: " + (index + 1));
				System.out.print(originalFloorSize[index]);
				while (!stack.isEmpty() && stack.get(stack.size() - 1) >= floorSize[i + 1]) {
					System.out.print(" " + stack.pop());
					i++;
				}
				i++;
				System.out.println();
			} else {
				System.out.println("Day: " + (index + 1) + "\n");
				stack.push(originalFloorSize[index]);
			}
		}

	}

}
