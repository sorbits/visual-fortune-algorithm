// Decompiled by Jad v1.5.7c. Copyright 1997-99 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packfields(5) packimports(3) nocasts braces 
// Source File Name:   Fortune.java

import java.awt.Graphics;

class EventQueue
{
	public void insert (EventPoint p)
	{
		if(Events != null)
			Events.insert(p);

		if(p.Prev == null)
			Events = p;
	}

	public void remove (EventPoint eventpoint)
	{
		if(eventpoint.Next != null)
			eventpoint.Next.Prev = eventpoint.Prev;

		if(eventpoint.Prev != null)
				eventpoint.Prev.Next = eventpoint.Next;
		else	Events = eventpoint.Next;
	}

	public EventPoint pop ()
	{
		EventPoint eventpoint = Events;
		if(eventpoint != null)
		{
			Events = Events.Next;
			if(Events != null)
			{
				Events.Prev = null;
			}
		}
		return eventpoint;
	}

	public void paint(Graphics g, boolean flag)
	{
		for(EventPoint eventpoint = Events; eventpoint != null; eventpoint = eventpoint.Next)
		{
			if(flag || !(eventpoint instanceof CirclePoint))
			{
				eventpoint.paint(g);
			}
		}

	}


	EventPoint Events;
}
