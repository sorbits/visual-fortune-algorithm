// Decompiled by Jad v1.5.7c. Copyright 1997-99 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packfields(5) packimports(3) nocasts braces 
// Source File Name:   Fortune.java

import java.awt.Graphics;
import java.io.PrintStream;

class ArcTree
{
	public void insert (MyPoint mypoint, double d, EventQueue eventqueue)
	{
		if(Arcs == null)
		{
			Arcs = new ArcNode(mypoint);
			return;
		}
		try
		{
			ParabolaPoint parabolapoint = new ParabolaPoint(mypoint);
			parabolapoint.init(d);
			Arcs.init(d);
			Arcs.insert(parabolapoint, d, eventqueue);
			return;
		}
		catch(Throwable _ex)
		{
			System.out.println("*** error: No parabola intersection during ArcTree.insert()");
		}
	}

	public void checkBounds (MyCanvas mycanvas, double d)
	{
		if(Arcs != null)
		{
			Arcs.init(d);
			Arcs.checkBounds(mycanvas, d);
		}
	}

	public void paint (Graphics g, double d, boolean flag, boolean drawBeach)
	{
		if(Arcs != null)
		{
			Arcs.init(d);
			Arcs.paint(g, d, 0.0D, flag, drawBeach);
		}
	}

	ArcNode Arcs;
}
