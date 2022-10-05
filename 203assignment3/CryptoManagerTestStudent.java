import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CryptoManagerTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertFalse(CryptoManager.isStringInBounds("¡¡¡"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("DEF", CryptoManager.caesarEncryption("ABC", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("(%,,/)3!.9/.%4(%2%", CryptoManager.caesarDecryption("HELLOISANYONETHERE", 96));
	}
	
	@Test
	public void testEncryptBellaso() {
		assertEquals("Y$RN'.2E.QZT", CryptoManager.bellasoEncryption("KUJIT #1 BRO", "NOHESNOT"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("OOGABOOGAOOGABOOGA", CryptoManager.bellasoDecryption("X\\NPK]VPO\"PUFK\\VVJ", "IMGOINGINSANE"));
	}


}
