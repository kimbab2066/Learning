package RealWorldAl.Chap1;

public class StackTest {
	public static void main(String[] args) {
		myStack stack = new myStack(5);
		stack.push(5);
		stack.push(3);
		stack.push(2);
		stack.push(1);
		stack.push(6);
		stack.show();
	}// end of main

}// end of class

class myStack {
	int top;
	int size;
	int[] stack;

	public myStack(int size) {
		this.size = size;
		stack = new int[size];
		top = -1;
	}

	public void push(int N) {
		stack[++top] = N;

	}// end of push

	public void pop(int N) {
		int pop = stack[top];
		stack[top--] = 0;
	}

	public void peek() {
		System.out.println("PEEK");
	}

	public void show() {
		for (int i = this.size - 1; i >= 0; i--) {
			System.out.println(stack[i]);
		}
	}
}// end of myStack