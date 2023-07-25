package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.VT100;

public class BlinkTimerExample {
	static class Blink extends TimerTask{
		static int count;
		int num;
		public Blink() {
			num = count;
			count++;
		}
		@Override
		public void run() {
			System.out.println(num + "...");
		}
	}
	public static void main(String[] args) {
		VT100.clearScreen();
		Timer timer = new Timer();
		for(int i=0; i<2; i++) {
			Blink b = new Blink();
			timer.schedule(b, 0, 1000);
//			timer.schedule(null, 0, 1000);  상기 두줄 없이 이거 하나로도 된다.. 상기 두줄은 풀어 써본 것
		}
		VT100.reset();
	}

}
