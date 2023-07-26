package com.example;

import util.Alpha;
import util.Color;
import util.VT100;

public class EarthWormExample {
	
	enum Direction{Up, Down, Left, Right
		
	}
	
    static class Worm extends Alpha{
    	Direction direction;
    	int nowline;
   	    int nowcolumn;
        Color nowfg;
    	Color nowbg;
    	char nowch;
    	public Worm() {
    	   line = (int)(Math.random()*20 + 1);
    	   column = (int)(Math.random()*40 + 1);
    	   direction = Direction.values()[(int)(Math.random()*4)];
    	   show();
    	}
    	public void Worm_next(int nowline, int nowcolumn) {
    		line = nowline;
    		column = nowcolumn;
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
    
	public static void main(String[] args) throws InterruptedException {
		VT100.clearScreen();
		
		Worm ss = new Worm();
		for(int i=0; i<5; i++) {
		   ss.move();
		   Thread.sleep(500);
		   ss.nowbg = ss.getBg();
		   ss.nowfg = ss.getFg();
		   ss.nowch = ss.getCh();
		   if(i==4) {
			   ss.nowline = ss.getLine();
			   ss.nowcolumn = ss.getColumn();
			   ss.Worm_next(ss.nowline, ss.nowcolumn);
		   }
		   
		}
		VT100.reset();

	}

}
