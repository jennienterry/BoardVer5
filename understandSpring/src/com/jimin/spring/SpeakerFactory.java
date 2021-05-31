package com.jimin.spring;
//외부 소스
import com.jimin.java.AppleSpeaker;
import com.jimin.java.HamanSpeaker;
import com.jimin.java.SonySpeaker;
import com.jimin.java.Speaker;

public class SpeakerFactory {
	public static Speaker choiceSpeaker(String brand) {
		switch(brand) {
		case "apple":
			return new AppleSpeaker(30);
		case "sony":
			return new SonySpeaker(40);
		case "haman":
			return new HamanSpeaker(50);
		}
		return null;
	}
}
