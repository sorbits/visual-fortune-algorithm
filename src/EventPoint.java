// Decompiled by Jad v1.5.7c. Copyright 1997-99 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packfields(5) packimports(3) nocasts braces 
// Source File Name:   Fortune.java

import java.io.PrintStream;

class EventPoint extends MyPoint
{

	EventPoint(MyPoint mypoint)
	{
		super(mypoint);
	}

	EventPoint(double d, double d1)
	{
		super(d, d1);
	}

	public void insert(EventPoint eventpoint)
	{
		if(eventpoint.x > x || eventpoint.x == x && eventpoint.y > y)
		{
			if(Next != null)
			{
				Next.insert(eventpoint);
				return;
			} else
			{
				Next = eventpoint;
				eventpoint.Prev = this;
				return;
			}
		}
		if(eventpoint.x != x || eventpoint.y != y || (eventpoint instanceof CirclePoint))
		{
			eventpoint.Prev = Prev;
			eventpoint.Next = this;
			if(Prev != null)
			{
				Prev.Next = eventpoint;
			}
			Prev = eventpoint;
			return;
		} else
		{
			eventpoint.Prev = eventpoint;
			System.out.println("Double point ignored: " + eventpoint.toString());
			return;
		}
	}

	public void action(MyCanvas mycanvas)
	{
		mycanvas.Arcs.insert(this, mycanvas.XPos, mycanvas.Events);
	}

	EventPoint Prev, Next;
}
