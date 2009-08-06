// Decompiled by Jad v1.5.7c. Copyright 1997-99 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packfields(5) packimports(3) nocasts braces 
// Source File Name:   Fortune.java

import java.awt.Graphics;

class MyLine
	implements Paintable
{

	MyLine(MyPoint mypoint, MyPoint mypoint1)
	{
		P1 = mypoint;
		P2 = mypoint1;
	}

	public void paint(Graphics g)
	{
		g.drawLine((int)P1.x, (int)P1.y, (int)P2.x, (int)P2.y);
	}

	MyPoint P1, P2;
}
