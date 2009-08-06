// Decompiled by Jad v1.5.7c. Copyright 1997-99 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packfields(5) packimports(3) nocasts braces 
// Source File Name:   Fortune.java

import java.awt.Graphics;
import java.util.Vector;

class DelaunayClass extends Vector
{

	public void paint(Graphics g)
	{
		for(int i = 0; i < size(); i++)
		{
			((Paintable)elementAt(i)).paint(g);
		}

	}

}
