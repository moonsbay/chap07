package com.example;

import util.Alpha;
import util.VT100;

public class DecoAlphaExamle {
	static class DecoAlpha extends Alpha{
	public void show() {
		super.show();
		VT100.cursorMove(getLine()+1, getColumn());
		VT100.reset();
		VT100.print('=');
	 }
	}
	public static void main(String[] args) 	{	
	    VT100.clearScreen();
	    Alpha a = new DecoAlpha();
	    
	    a.show();
	    a.hide();
	    
	    VT100.reset();
	}
	
}
