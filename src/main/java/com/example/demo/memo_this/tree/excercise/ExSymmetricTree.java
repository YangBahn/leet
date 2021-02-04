package com.example.demo.memo_this.tree.excercise;
import com.example.demo.common.TreeNode;
import lombok.experimental.UtilityClass;

public class ExSymmetricTree {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(6)
				.setLeft(
						new TreeNode(3)
								.setLeft(new TreeNode(1))
								.setRight(new TreeNode((2))))
				.setRight(new TreeNode(3)
						.setLeft(new TreeNode(2))
						.setRight(new TreeNode(1))
				);

		boolean output = BinaryTree.isMirror(tree.getLeft(), tree.getRight());
		System.out.println("Symmetric: " + output);
	}

	/*
	 if both null return true
	 compare cur left root and right root have same value
	 	recusively:
	 		(branch left/right nodes need to be compared diagonally)
	 		call itself with left.left, right.right
			call itself with left.right right.left
	*/
	@UtilityClass
	class BinaryTree {
		boolean isMirror(TreeNode left, TreeNode right) {
			return false;
		}

	}


}