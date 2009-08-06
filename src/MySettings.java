// Decompiled by Jad v1.5.7c. Copyright 1997-99 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/SiliconValley/Bridge/8617/jad.html
// Decompiler options: packfields(5) packimports(3) nocasts braces 
// Source File Name:   Fortune.java

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class MySettings extends Panel
	implements ItemListener
{

	public MySettings (MyCanvas mycanvas)
	{
		canvas = mycanvas;
		String as[] = {
			"Circles", "Beachline", "Voronoi diagram", "Delaunay triangulation"
		};

		boxes = new Checkbox[as.length];
		for(int i = 0; i < as.length; i++)
		{
			boxes[i] = new Checkbox(as[i]);
			boxes[i].addItemListener(this);
			add(boxes[i]);
		}

		boxes[1].setState(true);
		boxes[2].setState(true);
	}

	public void itemStateChanged (ItemEvent itemevent)
	{
		String s = itemevent.getItem().toString();
		boolean flag = itemevent.getStateChange() == 1;
		if(s == "Circles")
			canvas.drawCircles = flag;
		else if(s == "Beachline")
			canvas.drawBeach = flag;
		else if(s == "Voronoi diagram")
			canvas.drawVoronoiLines = flag;
		else if(s == "Delaunay triangulation")
			canvas.drawDelaunay = flag;
		canvas.repaint();
	}

	MyCanvas canvas;
	Checkbox[] boxes;
}
