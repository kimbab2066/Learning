package 자료구조;

import java.io.*;

public class 스택 {
	static int[] stack;
	static int size = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		stack = new int[N];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			String oper = str[0];
			if (oper.equals("push")) {
				int X = Integer.valueOf(str[1]);
				push(X);
			} else if (oper.equals("pop")) {
				sb.append(pop() + "\n");
			} else if (oper.equals("size")) {
				sb.append(size() + "\n");
			} else if (oper.equals("empty")) {
				sb.append(empty() + "\n");
			} else if (oper.equals("top")) {
				sb.append(top() + "\n");
			}
		}
		System.out.println(sb);
	}// end of main

	static void push(int x) {
		stack[size] = x;
		size++;
	}

	static int pop() {
		if (size == 0) {
			return -1;
		}
		int result = stack[size - 1];
		size--;
		return result;
	}

	static int size() {
		return size;
	}

	static int empty() {
		return size > 0 ? 0 : 1;
	}

	static int top() {
		return size > 0 ? stack[size - 1] : -1;
	}
}// end of class