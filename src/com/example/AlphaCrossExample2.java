package com.example;

import java.util.Timer;
import java.util.TimerTask;

import util.Alpha;
import util.VT100;

public class AlphaCrossExample2 {
	
	enum Direction {
		Up, Down, Left, Right
	}
	
	static class Cross extends Alpha{
		
		final Direction direction;
		public Cross() {
//			super();
			line = 10;     //패키지가 달라도 프로텍티드 필드라는 것은 상속관계에서는 접속 허용하는 것
			column = 20;
			
			direction = Direction.values()[(int)(Math.random()*4)];
			
			show();
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
		
		void move() {
			switch(direction) {
			case Up:
				up();
				break;
			case Down:
				down();
				break;
			case Left:
				left();
				break;
			case Right:
				right();
				break;
			}
		}
	}
	
	
	
//	static class MoveTimerTask extends TimerTask{
//		static int totalCount = 0;
		
//		AlphaMove alphaMove = new AlphaMove();
		
//		Direction direction = Direction.Right;
		
//		int count;
		
//		int direct = (int)(Math.random()+4);
		
//		public MoveTimerTask() {
//			totalCount++;
//		}
		
/*		public int randomdirection() {
			direct = (int)(Math.random()+4);
			return direct;
		}
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
			
			if(alphaMove.getLine()==0 && alphaMove.getColumn() == 20)
				alphaMove.hide();
				
			else if(alphaMove.getLine()==10 && alphaMove.getColumn()==40)	
				alphaMove.hide();
			else if(alphaMove.getLine()==20 && alphaMove.getColumn()==20)
				alphaMove.hide();
			else if(alphaMove.getLine()==10 && alphaMove.getColumn()==0)	
			    alphaMove.hide();
			
//			alphaMove.setLine(10);
//			alphaMove.setColumn(20);
//				
//		    if(direct == 1)//{
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
			
			if(count == 2) {
				   alphaMove.hide();
					cancel();   //TimerTask에 있는 타이머 종료 매서드
					totalCount--;
					if(totalCount == 0)
//						timer.cancel();
						VT100.reset();
						VT100.cursorMove(21, 1);
						System.out.println("Program End...");
						timer.cancel();
				}
				
		}
	}*/
	
	static class CrossTask extends TimerTask{
		static int count = 0;
		Cross alpha = new Cross();
		public CrossTask() {
			CrossTask.count++;
		}
	@Override
	public void run() {
		
		if(alpha.getLine()==1 || alpha.getLine()==20 || alpha.getColumn()==1 || alpha.getColumn()==40) {
			alpha.hide();
			this.cancel();  //super.cancel()과 같다,, 타이머까지 종료되지는 않는다
			CrossTask.count--;
			
			if(CrossTask.count==0) {
				VT100.cursorMove(21, 1);
			    VT100.reset();
			    System.out.println("Program End...");
				timer.cancel();
			}
			return; //벽에서 안지워지는 것 해결
		}
		alpha.move(); //벽에 닿아 바로 사라지는 것을 방지하기 위해 뒤에 놓았다	
	}
		
	}
	static Timer timer = new Timer();
	
	public static void main(String[] args) throws InterruptedException {
		
		VT100.clearScreen();
		for(int i=0; i<100; i++) {
			int speed = (int)(Math.random()*200+10);
		    timer.schedule(new CrossTask(), 0, speed); //여기서 run()이 호출되는데....왜왜왜
		    Thread.sleep(100);
		}
//		Cross c = new Cross();
		
//		for(;;) {
//		c.move();
//		
//		if(c.getLine()==1 || c.getColumn()==1 || c.getLine()==20 || c.getColumn()==40) {
//			c.hide();
//		    break;
//		}
//		Thread.sleep(100);
//		}
		
//		for(int i=0; i<10; i++) {
//		MoveTimerTask t = new MoveTimerTask();
//		int speed = (int)(Math.random()*300+10);
//		timer.schedule(t, 0, speed); // null에 TimerTask 인스턴스가 와야한다
//		}
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
