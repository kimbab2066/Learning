package Java.Chap7;

class Parent {
	private int prv; // same class
	int dft; // same package
	protected int prt;// same package and another package child
	public int pub;// unlimit

	public void printMembers() {
		System.out.println(prv);
		System.out.println(dft);
		System.out.println(prt);
		System.out.println(pub);
	}
}

public class AccessModifier {
	public static void main(String[] args) {
		Parent p = new Parent();
//		System.out.println(p.prv);
		System.out.println(p.dft);
		System.out.println(p.prt);
		System.out.println(p.pub);
	}
}
