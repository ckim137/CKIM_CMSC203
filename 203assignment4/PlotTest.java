import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTest {
	private Plot plot1, plot2;
	@BeforeEach
	void setUp() throws Exception {
		plot1 = new Plot(1, 1, 5, 5);
		plot2 = new Plot(2, 2, 1, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		plot1 = plot2 = null;
	}

	@Test
	public void testOverlaps() {
		assertTrue(plot1.overlaps(plot2)); 
	}
	
	@Test
	public void testEncompasses() {
		assertTrue(plot1.encompasses(plot2)); 
	}
	
	@Test
	public void testToString() {
		assertEquals("2,2,1,1",plot2.toString());	
	}
	
	@Test
	public void testGetSetX() {
		int x = 1;
		plot1.setX(x);
		assertEquals(x, plot1.getX());
		
	}
	@Test
	public void testGetSetY() {
		int y = 1;
		plot1.setY(y);
		assertEquals(y, plot1.getY());
	}
	@Test
	public void testGetSetWidth() {
		int w = 1;
		plot1.setWidth(w);
		assertEquals(w, plot1.getWidth());
	}
	@Test
	public void testGetSetDepth() {
		int d = 1;
		plot1.setDepth(d);
		assertEquals(d, plot1.getDepth());
	}
}
