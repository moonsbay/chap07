package com.example;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
	
	static class A extends TimerTask{
		@Override
		public void run() {
			System.out.println("oneshot...");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		TimerTask t1 = new A();
//		timer.schedule(t1, 1000);
		timer.schedule(t1, 0, 1000);
		
		System.out.println("Program End...");
	}

}
