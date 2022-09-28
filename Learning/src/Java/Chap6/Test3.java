package Java.Chap6;

public class Test3 {
	public static void main(String[] args) {
		MyTv t = new MyTv();
		t.channel = 100;
		t.volume = 0;
		System.out.println("CH: " + t.channel + ", VOL: " + t.volume);

		t.channelDown();
		t.volumeDown();
		System.out.println("CH: " + t.channel + ", VOL: " + t.volume);

		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH: " + t.channel + ", VOL: " + t.volume);
	}
}// end of class

class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	void turnOnOff() {
		if (isPowerOn) {
			isPowerOn = false;
		} else {
			isPowerOn = true;
		}
	}// end of turnOnOff

	void volumeUp() {
		if (volume < MAX_VOLUME) {
			volume++;
		}
	}// end of volumeUp

	void volumeDown() {
		if (volume > MAX_VOLUME) {
			volume--;
		}
	}// end of volumeDown

	void channelUp() {

		if (channel == MAX_CHANNEL) {
			channel = MIN_CHANNEL;
		}
		channel++;
	}// end of channelUp

	void channelDown() {

		if (channel == MIN_CHANNEL) {
			channel = MAX_CHANNEL;
		}
		channel--;
	}// end of channelDown
}// end of class