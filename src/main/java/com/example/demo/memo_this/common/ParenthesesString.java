package com.example.demo.memo_this.common;

public class ParenthesesString {
	public String str;
	public int openCount; // open parentheses count
	public int closeCount; // close parentheses count

	public ParenthesesString(String s, int openCount, int closeCount) {
		str = s;
		this.openCount = openCount;
		this.closeCount = closeCount;
	}

	public void addOpenString(String str) {
		openCount += 1;
		this.str = this.str + str;
	}

	public void addCloseString(String str) {
		closeCount += 1;
		this.str = this.str + str;
	}

	public boolean isClosedAt(int num) {
		return openCount == num && (openCount == closeCount);
	}
}
