package com.greatlearning.graded.project2.que2;

class Node {
	int data;
	Node left, right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class SkewedBST {

	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void convertBSTtoSkewed(Node root) {

		if (root == null) {
			return;
		}

		convertBSTtoSkewed(root.left);
		Node rightNode = root.right;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		convertBSTtoSkewed(rightNode);
	}

	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		traverseRightSkewed(root.right);
	}

	public static void main(String[] args) {
		SkewedBST.node = new Node(50);
		SkewedBST.node.left = new Node(30);
		SkewedBST.node.right = new Node(60);
		SkewedBST.node.left.left = new Node(10);
		SkewedBST.node.right.left = new Node(55);

		convertBSTtoSkewed(node);
		traverseRightSkewed(headNode);
	}
}
