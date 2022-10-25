
public class Plot{
	//fields
	private int x;
	private int y;
	private int depth;
	private int width;
	
	//Constructors
	public Plot() 
	{
		x = 0;
		y = 0;
		depth = 1; 
		width = 1;
	}
	
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot otherPlot)
	{
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	//methods
	public boolean overlaps(Plot plot) {
		if((plot.x < x+width) && (x < plot.x+plot.width) && (plot.y < y+depth) && (y < plot.y + plot.depth))
	         return true;
	    else 
	         return false;
	    }
	
    public boolean encompasses(Plot plot) {
        if((x <= plot.x) && (x + width >= plot.x + plot.width)
        		&& (y <= plot.y) && (y + depth >= plot.y + plot.depth))
            return true;
        else
            return false;
    }
	
	public String toString()
	{
		String str = x + "," + y + "," + width + "," + depth;
		return str;
	}
	
	//getters and setters
	public void setX(int x)
	{
		this.x = x;
	}
	public int getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	public int getY()
	{
		return y;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public int getWidth()
	{
		return width;
	}
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	public int getDepth()
	{
		return depth;
	}
}


