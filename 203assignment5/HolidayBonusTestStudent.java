import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestStudent {
	private double[][] dataSet1 =  {{9, 8, 7}, {6, 5, 4}, {3}};


	@Test
	public void testCalculateHolidayBonusStudent() {
		try {
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
			assertEquals(15000, result[0], .001);
			assertEquals(2000.0, result[1], .001);
			assertEquals(3000.0, result[2], .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	@Test
	public void testCalculateTotalHolidayBonusStudent() {
		try {
			assertEquals(20000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
}
