package com.example.demo.assorted;


/*
INPUT - Stack of Strings for Operation

RULES
* pop the numbers for all operations
Integer : push the num
POP': remove the top number
"DUP": push duplicate of tope number
"+": push the sum of top 2 number
"-": push the result of top 1 - top 2

Error Conditions:
not 20 bit unsigned int
empty stack
stack indexing error ( unpresent value in stack)
Return the top value from stack

EX -  "13 DUP 4 POP 5 DUP + DUP + -"
13	 	13
DUP		13, 13
4		13, 13, 4
pop		13, 13
5		13, 13, 5
DUP		13, 13, 5, 5
+		13, 13, 10
DUP		13, 13, 10, 10
+		13, 13, 20
-		13, 7
  return 7.

Error EX
5 6 + -
3 DUP 5 - -

*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

public class WordMachine {
	public static final int MAX = 0xFFFFF;
	public static final int MIN = 0;
	private static final Pattern NUMERIC = Pattern.compile("\\d+");
	private final Stack<Integer> stack = new Stack<>();
	private static final Map<String, Runnable> OPERATIONS = new HashMap<>();
	{
		OPERATIONS.put("POP", this::pop);
		OPERATIONS.put("DUP", this::dup);
		OPERATIONS.put("+", this::add);
		OPERATIONS.put("-", this::sub);
	}

	public int solution(String S) {
		try {
			Arrays.stream(S.split(" ")).forEach(this::applyCommand);
			return pop();
		} catch (IllegalArgumentException e) {
			return -1;
		}
	}

	private void applyCommand(String s) {
		if (NUMERIC.matcher(s).matches()) {
			push(Integer.valueOf(s));
		} else {
			OPERATIONS.get(s).run();
		}
	}

	private void push(int i) {
		withinRange(i);
		stack.push(i);
	}

	private int pop() {
		return stack.pop();
	}

	private void dup() {
		hasElements(1);
		push(stack.peek());
	}

	private void add() {
		hasElements(2);
		push(stack.pop() + stack.pop());
	}

	private void sub() {
		hasElements(2);
		push(stack.pop() - stack.pop());
	}

	private int hasElements(int i) {
		if(stack.size() < i){
			throw new IllegalArgumentException("Too few elements available");
		}
		return i;
	}

	private int withinRange(int i){
		if(i < MIN || i > MAX){
			throw new IllegalArgumentException("Input under/overflow");
		}
		return i;
	}
}