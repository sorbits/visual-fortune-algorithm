// Decompiled by Jad v1.5.7c. Copyright 1997-99 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packfields(5) packimports(3) nocasts braces 
// Source File Name:   Fortune.java

import java.applet.Applet;
import java.awt.*;

public class Fortune extends Applet
	implements Runnable
{

	public void init()
	{
		setLayout(new BorderLayout());
		canvas = new MyCanvas(getSize().width, getSize().height - 50, 85);
		add("North", new MySettings(canvas));
		add("Center", canvas);
		add("South", controls = new MyControls(canvas));
	}

	public void start()
	{
		if(thread == null)
		{
			thread = controls.thread = new Thread(this);
			thread.start();
		}
	}

	public void run()
	{
		if(thread != null)
		{
			do
			{
				canvas.init();
				while(canvas.singlestep()) 
				{
					try
					{
						Thread.sleep(25L);
					}
					catch(InterruptedException _ex) { }
				}
				controls.threadRunning(false);
			} while(true);
		} else
		{
			return;
		}
	}


	MyCanvas canvas;
	MyControls controls;
	Thread thread;
}
