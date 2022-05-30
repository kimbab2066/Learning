package Java.Chap9;

import java.util.Objects;

public class hashCode {
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c1.equals(c2));
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
	}
}

class Card {
	String kind;
	int number;

	Card() {
		this("SPADE", 1);
	}

	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	public int hashCode() {
		return Objects.hash(kind,number);
	}

	public boolean equals(Object obj) {

		if (!(obj instanceof Card)) {
			return false;
		}

		Card c = (Card) obj;
		return this.kind.equals(c.kind) && this.number == c.number;
	}

	public String toString() {
		return "kind:" + this.kind + ", number:" + this.number;
	}

}
