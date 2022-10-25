import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyTest {
	Property propertyOne;

	@BeforeEach
	void setUp() throws Exception {
		propertyOne = new Property("First Property", "Gaithersburg", 1758.25, "Montgomery College");
	}

	@AfterEach
	void tearDown() throws Exception {
		propertyOne = null;
	}

	@Test
	void testGetPropertyName() {
		assertEquals("First Property", propertyOne.getPropertyName());
	}
	@Test
	void testGetCity() {
		assertEquals("Gaithersburg", propertyOne.getCity());
	}
	@Test
	void testGetOwner() {
		assertEquals("Montgomery College", propertyOne.getOwner());
	}


	@Test
	void testGetRentAmount() {
		assertEquals(1758.25, propertyOne.getRentAmount());
	}

	@Test
	void testGetPlot() {
		assertEquals(0, propertyOne.getPlot().getX());
		assertEquals(0, propertyOne.getPlot().getY());
		assertEquals(1, propertyOne.getPlot().getWidth());
		assertEquals(1, propertyOne.getPlot().getDepth());
	}

	@Test
	void testToString() {
		assertEquals("First Property,Gaithersburg,Montgomery College,1758.25",propertyOne.toString());	
	}

}