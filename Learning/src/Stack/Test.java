package Stack;

public class Test {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack();// 초기 공간 X
		Stack<Integer> stack2 = new Stack(10);// 초기 공간 O

		stack.push(10);
		stack.push(40);
		stack.push(50);
		stack.push(20);
		stack.push(70);

		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println("==========");
		stack.show();
		System.out.println("==========");
		stack.pop();
		System.out.println("==========");
		stack.show();
		System.out.println("==========");
	}// end of main
}
