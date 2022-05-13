package Java;

abstract class Player {
	abstract void play(int pos);

	abstract void stop();

}

class AudioPlayer extends Player {

	@Override
	void play(int pos) {
		System.out.println(pos + "위치부터 play.");
	}

	@Override
	void stop() {
		System.out.println("멈춤");
	}

}

public class Chap7_Abstract {
	public static void main(String[] args) {
		Player ap = new AudioPlayer(); // 다형성
		ap.play(100);
		ap.stop();
	}
}
