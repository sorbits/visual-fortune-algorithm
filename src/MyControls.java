// Decompiled by Jad v1.5.7c. Copyright 1997-99 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packfields(5) packimports(3) nocasts braces 
// Source File Name:   Fortune.java

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyControls extends Panel
	implements ActionListener
{

	public MyControls(MyCanvas mycanvas)
	{
		running = true;
		canvas = mycanvas;
		String as[] = {
			"Suspend", "Resume", "Next event", "Next pixel", "Clear", "Restart"
		};
		buttons = new Button[as.length];
		for(int i = 0; i < as.length; i++)
		{
			buttons[i] = new Button(as[i]);
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}

		buttons[1].setEnabled(false);
		buttons[3].setEnabled(false);
	}

	public void actionPerformed(ActionEvent actionevent)
	{
		String s = actionevent.getActionCommand();
		if(s == "Suspend")
		{
			threadRunning(false);
			return;
		}
		if(s == "Resume")
		{
			threadRunning(true);
			return;
		}
		if(s == "Next event")
		{
			canvas.step();
			return;
		}
		if(s == "Next pixel")
		{
			canvas.singlestep();
			return;
		}
		if(s == "Clear")
		{
			threadRunning(false);
			canvas.clear();
			return;
		}
		if(s == "Restart")
		{
			canvas.restart();
			threadRunning(true);
		}
	}

	public void threadRunning(boolean flag)
	{
		if(flag != running)
		{
			if(running = flag)
			{
				buttons[0].setEnabled(true);
				buttons[1].setEnabled(false);
				buttons[3].setEnabled(false);
				thread.resume();
				return;
			}
			buttons[0].setEnabled(false);
			buttons[1].setEnabled(true);
			buttons[3].setEnabled(true);
			thread.suspend();
		}
	}

	MyCanvas canvas;
	Thread thread;
	boolean running;
	Button buttons[];
}
