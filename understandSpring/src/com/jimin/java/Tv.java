package com.jimin.java;

//Tv의 부모는 Object(최상위 객체) 생략해도 컴파일러가 자동으로 'extends Object' 넣어준다. /상속기호 : 자식->부모
public abstract class Tv extends Object { // 항상 부모가 됨 / 자식에서 부모로 (위로) 올라갈수록 추상적
	private Speaker speaker;
	private String brand;
	private int inch;
	private int maxChannel;
	private int maxVolume;
	// setter를 주면 값이 계속 바뀌기 떄문에 getter만 생성
	// getter : 객체 밖에서 내가 가지고 있는 값을 요청하면 주는거
	private int currentChannel;
	private int currentVolume;

	// 생성자 : 메소드와 다른점 -> 1) return타입이 없다, 2) 클래스명과 동일하다.
	// 생성자는 오버로딩 가능ㅇ
//	public Tv () {} //기본생성자는 컴파일러가 자동으로 만들어줄 때가 있다 -> 생성자가 하나도 없을 때 (Object꺼)

	public Tv(Speaker speaker, String brand, int inch, int maxChannel, int maxVolume) {
		super(); // 생략해도 컴파일러가 넣어준다.
		this.speaker = speaker;
		this.brand = brand;
		this.inch = inch;
		this.maxChannel = maxChannel;
		this.maxVolume = maxVolume;
		this.currentChannel = 1;
	}

	public String getBrand() {
		return brand;
	}

	public int getCurrentChannel() {
		return currentChannel;
	}

	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}

	public int getInch() {
		return inch;
	}

	public int getMaxChannel() {
		return maxChannel;
	}

	public int getMaxVolume() {
		return maxVolume;
	}

	public void channelUp() {
		if (currentChannel == maxChannel) {
			currentChannel = 1;
		} else {
			currentChannel++;
		}
		System.out.println(currentChannel);
	}
// currentChannel = currentChannel == maxChannel ? 1: currentChannel + 1; 삼항식

	public void channelDown() {
		if (currentChannel == 1) {
			currentChannel = maxChannel;
		} else {
			currentChannel--;
		}
		System.out.println(currentChannel);
	}
// currentChannel = currentChannel == 1 ? maxChannel : currentChannel - 1;
	
	public void volumeUp() {
		if (maxVolume > currentVolume) {
			currentVolume++;
			speaker.volumeUp();
		}
		System.out.printf("%s - speaker : %d\n", brand, currentVolume);
	}

	public void volumeDown() {
		if (currentVolume > 0) {
			currentVolume--; //화면상 볼륨이 낮아지는 기능
			speaker.volumeDown(); //실제 볼륨이 낮아지는 기능
		}
		System.out.printf("%s - speaker : %d\n", brand, currentVolume);
	}

	@Override
	public String toString() {
		return String.format("%s, %d인치, %d채널, %d볼륨", brand, inch, maxChannel, maxVolume);
		// 여기서는 super.과 this.이 같다.
	}
}
