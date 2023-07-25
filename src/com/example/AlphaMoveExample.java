package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class AlphaMoveExample {
	static class AlphaMove extends Alpha{
		public AlphaMove() {
//			super();
			line = 1;     //패키지가 달라도 프로텍티드 필드라는 것은 상속관계에서는 접속 허용하는 것
			column =1;
		}
		void right() {
			hide();
			column++;
			show();
		}
		void down() {
			hide();
			line++;
			show();
		}
		void left() {
			hide();
			column--;
			show();
		}
		void up() {
			hide();
			line--;
			show();
		}
	}
	
	enum Direction {
		Up, Down, Left, Right
	}
	
	static class MoveTimerTask extends TimerTask{
		AlphaMove alphaMove = new AlphaMove();
		
		Direction direction = Direction.Right;
		
//		int count;
		@Override
		public void run() {
			switch(direction) {
			case Right:
				alphaMove.right();
				break;
			case Down:
				alphaMove.down();
				break;
			case Left:
				alphaMove.left();
				break;
			case Up:
		       alphaMove.up();
		       break;
			default:
				break;
			}
			
			if(alphaMove.getLine()==1 && alphaMove.getColumn()==1) {
				direction = Direction.Right;
//				count ++ ;
			}else if(alphaMove.getLine()==1 && alphaMove.getColumn()==40)
				direction = Direction.Down;
			else if(alphaMove.getLine()==20 && alphaMove.getColumn()==40)
				direction = Direction.Left;
			else if(alphaMove.getLine()==20 && alphaMove.getColumn()==1)
				direction = Direction.Up;
			
//			if(count == 10) {
//			   alphaMove.hide();
//				cancel();   //TimerTask에 있는 타이머 종료 매서드
	//		}
				
		}
	}
	static Timer timer = new Timer();
	
	public static void main(String[] args) throws InterruptedException {
		
		VT100.clearScreen();
		
		for(int i=0; i<100; i++) {
		MoveTimerTask t = new MoveTimerTask();
		int speed = (int)(Math.random()*300+10);
		timer.schedule(t, 0, speed); // null에 TimerTask 인스턴스가 와야한다
		}
/*		AlphaMove am = new AlphaMove();
		for(int i=0;i<10;i++) {
			am.right();
			Thread.sleep(400);
		}
		for(int i=0;i<10;i++) {
			am.down();
			Thread.sleep(300);
		}
		for(int i=0;i<10;i++) {
			am.left();
			Thread.sleep(200);
		}
		for(int i=0;i<10;i++) {
			am.up();
			Thread.sleep(100);
		}*/
		VT100.reset();
		
	}

}
