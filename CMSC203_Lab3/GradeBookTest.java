import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	//declaring private gradebook objects
	private GradeBook g1;
	private GradeBook g2;
	
	@BeforeEach
	void setUp() throws Exception {
		//initializing objects
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		//adding scores to gradebook1
		g1.addScore(50.0);
		g1.addScore(100.0);
		
		//adding scores to gradebook2
		g2.addScore(75.0);
		g2.addScore(25.0);

	}

	@AfterEach
	void tearDown() throws Exception {
		//setting both objects to null
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		//checking whether addScore worked correctly
		assertTrue(g1.toString().equals("50.0 100.0 0.0 0.0 0.0 "));
		assertTrue(g2.toString().equals("75.0 25.0 0.0 0.0 0.0 "));
		
		//checking whether scoresSize = expected number of scores
		assertEquals(2, g1.getScoresSize());
		assertEquals(2, g2.getScoresSize());
	}

	@Test
	void testSum() {
		//checking whether sum = expected sum
		assertEquals(150.0, g1.sum(), .0001);
		assertEquals(100.0, g2.sum(), .0001);
	}

	@Test
	void testMinimum() {
		//checking whether minimum = expected minimum
		assertEquals(50.0, g1.minimum(), .001);
		assertEquals(25.0, g2.minimum(), .001);
	}

	@Test
	void testFinalScore() {
		//checking whether final score = expected final score
		assertEquals(100.0, g1.finalScore(), .0001);
		assertEquals(75.0, g2.finalScore(), .0001);
	}

	@Test
	void testGetScoresSize() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
