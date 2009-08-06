// Decompiled by Jad v1.5.7c. Copyright 1997-99 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packfields(5) packimports(3) nocasts braces 
// Source File Name:   Fortune.java

import java.awt.Graphics;
import java.util.Vector;

class VoronoiClass extends Vector
{
	public VoronoiClass (int width, int height, int points)
	{
		if(points > 0)
		{
			boolean flag = false;
			for(int x = 30; x < width; x += width/8)
			{
				int start_y = (flag ^= true) ? 0 : width/16;
//				for(int y = 30 + start_y; y < height; y += width/8)
				for(int y = 30 + start_y; y < height; y += height/2)
					addElement(new MyPoint(x, y));
			}

//			addElement(new MyPoint(10D, height / 2));
		}

		checkDegenerate();
	}


	public void checkDegenerate ()
	{
		if(size() > 1)
		{
			MyPoint min = (MyPoint)elementAt(0), next = min;
			for(int i = 1; i < size(); i++)
			{
				Object element = elementAt(i);
				if(element instanceof MyPoint)
				{
					if(((MyPoint)element).x <= min.x)
					{
						next = min;
						min = (MyPoint)element;
					}
					else if(((MyPoint)element).x <= min.x)
					{
						next = (MyPoint)element;
					}
				}
			}

			if(min.x == next.x && min != next)
			{
				min.x--;
				System.out.println("Moved point: " + next.x + " -> " + min.x);
			}
		}
	}

	public void paint (Graphics g, boolean flag)
	{
		for(int i = 0; i < size(); i++)
		{
			if(flag || !(elementAt(i) instanceof MyLine))
				((Paintable)elementAt(i)).paint(g);
		}
	}

	public void clear()
	{
		for(int i = 0; i < size(); i++)
		{
			if(elementAt(i) instanceof MyLine)
				removeElementAt(i--);
		}
	}
}
