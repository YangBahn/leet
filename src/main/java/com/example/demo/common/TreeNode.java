package com.example.demo.common;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;

	public TreeNode(int x) {
		val = x;
		left = right = next = null;
	}

}
