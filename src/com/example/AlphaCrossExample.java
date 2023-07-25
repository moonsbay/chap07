package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class AlphaCrossExample {
	static class AlphaMove extends Alpha{
		public AlphaMove() {
//			super();
			line = 10;     //패키지가 달라도 프로텍티드 필드라는 것은 상속관계에서는 접속 허용하는 것
			column = 20;
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
		static int totalCount = 0;
		
		AlphaMove alphaMove = new AlphaMove();
		
		Direction direction = Direction.Right;
		
		int count;
		
		int direct = (int)(Math.random()+4);
		
		public MoveTimerTask() {
			totalCount++;
		}
		
/*		public int randomdirection() {
			direct = (int)(Math.random()+4);
			return direct;
		}*/
		@Override
		public void run() {
			switch(direct) {
			case 1:
				alphaMove.right();
				break;
			case 2:
				alphaMove.down();
				break;
			case 3:
				alphaMove.left();
				break;
			case 4:
		       alphaMove.up();
		       break;
			default:
				break;
			}
			
			if(alphaMove.getLine()==0 || alphaMove.getLine() == 20 || alphaMove.getColumn()==0 || alphaMove.getColumn()==40)
				alphaMove.setLine(10);
			   alphaMove.setColumn(20);
//				alphaMove.hide();
//			   cancel();   //TimerTask에 있는 타이머 종료 매서드
				
				//			if(direct == 1)//{
//				direction = Direction.Right;
//			    count++;
//			}
//			else if(direct == 2)//(alphaMove.getLine()==1 && alphaMove.getColumn()==40)
//				direction = Direction.Down;
//			else if(direct == 3)//(alphaMove.getLine()==20 && alphaMove.getColumn()==40)
//				direction = Direction.Left;
//			else if(direct == 4)//(alphaMove.getLine()==20 && alphaMove.getColumn()==1)
//				direction = Direction.Up;
			
		   count++;
			
/*			if(count == 2) {
				   alphaMove.hide();
					cancel();   //TimerTask에 있는 타이머 종료 매서드
					totalCount--;
					if(totalCount == 0)
//						timer.cancel();
						VT100.reset();
						VT100.cursorMove(21, 1);
						System.out.println("Program End...");
						timer.cancel();
				}*/
				
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
