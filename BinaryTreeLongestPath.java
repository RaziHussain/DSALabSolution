package Com;

import java.util.ArrayList;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
	}
}

class TreeNodeOperation {
	public static ArrayList<Integer> findLongestPathofTree(TreeNode node) {
		// if rootnode is null;
		ArrayList<Integer> al = null;

		if (node == null) {
			al = new ArrayList<>();
			return al;
		}
		ArrayList<Integer> leftNode = findLongestPathofTree(node.left);

		ArrayList<Integer> rightNode = findLongestPathofTree(node.right);

//		if (leftNode.size() == rightNode.size()) {
//			return al;
//		}

		if (leftNode.size() > rightNode.size()) {
			leftNode.add(node.data); // store that node values
		} else {
			rightNode.add(node.data); // store that node values
		}

		if (leftNode.size() > rightNode.size()) {
			return leftNode;
		} else {
			return rightNode;
		}
	}

	public static void displayNodeData(TreeNode node) {
		if (node != null) {
			displayNodeData(node.left);
			System.out.print(" " + node.data);
			displayNodeData(node.right);
			// System.out.println(" "+ node.data);

		}
	}

}

public class BinaryTreeLongestPath {
	public static void main(String[] args) {
		TreeNode rootNode = new TreeNode(100);
		TreeNode node20 = new TreeNode(20);
		TreeNode node130 = new TreeNode(130);
		TreeNode node10 = new TreeNode(10);
		TreeNode node50 = new TreeNode(50);
		TreeNode node5 = new TreeNode(5);
		TreeNode node110 = new TreeNode(110);
		TreeNode node140 = new TreeNode(140);

		// join all the nodes to left and right

		rootNode.left = node20;
		rootNode.right = node130;

		node20.left = node10;
		node20.right = node50;

		node10.left = node5;

		node130.left = node110;
		node130.right = node140;

		TreeNodeOperation.displayNodeData(rootNode);
		System.out.println();

		System.out.println("\nLongest Path of Tree is ");
		ArrayList<Integer> output = TreeNodeOperation.findLongestPathofTree(rootNode);
		System.out.println();
		int size = output.size();
		if (size == 0) {
			System.out.println("Node is empty");
		} else {
			for (int i = 0; i < size; i++) {
				System.out.print(" " + output.get(i));
			}
		}

	}

}
