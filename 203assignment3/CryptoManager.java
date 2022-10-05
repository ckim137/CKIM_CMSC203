/*
 * Class: CMSC203 22889
 * Instructor: Kujit
 * Description: This program uses several classes to encrypt and decrypt a string using the 
 * Caesar and Bellaso Cipher. It also uses a helper class to check whether a string is out of the specified bounds
 * Due: 10/10/2022
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Charles Kim_
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple �substitution cipher� where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		
		//loop for each character in plainText
		for(int i = 0; i < plainText.length(); i++)
		{
			//check if a character is outside range. If so, return false
			if(plainText.charAt(i) > UPPER_RANGE || plainText.charAt(i) < LOWER_RANGE)
				return false;
		}
		
		//else, return true
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		//check whether string is in bounds, if so, continue
		if(isStringInBounds(plainText)) 
		{
			//result and key variables
			String result = "";
			int keyCopy = key;
			
			//check whether key is outside bounds, if so, reduce key until it is in bounds
			while(keyCopy > 95)
				key-=64;
			
			//for each character in plainText, offset the character by the number in key, 
			//cast it into char, then add it to result
			for(int i = 0; i < plainText.length(); i++)
				result += (char) (plainText.charAt(i) + key);
			
			//return result
			return result;
		}
		
		//if string is out of bounds, return error message
		else 
		{
			return ("The selected string is not in bounds, Try again.");
		}

	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		//check whether string is in bounds, if so, continue
		if(isStringInBounds(plainText)) 
		{
			//variables for resulting string, key, countKey that counts number of chars in key, and the encrypted char
			String result = "";
			String key = "";
			int countKey = 0; 
			char encryptedChar = 0;
				
			//repeat for each character in plainText
			for(int i = 0; i < plainText.length(); i++)
			{
				//check whether countKey > bellasoStr's length, if so, set countKey to 0
				if(countKey >= bellasoStr.length())
					countKey = 0;
				
				//add bellasoStr's char at pos countKey to key, increment countKey by 1
				key += bellasoStr.charAt(countKey);
				countKey++;
			}
				
			//repeat for each character in plainText
			for(int i = 0; i < plainText.length(); i++)
			{
				//set encryptedChar to sum of current char in plainText and current char in key, casted to char
				encryptedChar = (char) (plainText.charAt(i) + key.charAt(i));
				
				//subtract range from encryptedChar if it is out of range
				while(encryptedChar > UPPER_RANGE)
					encryptedChar -= RANGE;
				
				//add encryptedChar to result
				result += encryptedChar;
			}
			
			//return result
			return result;
		}
		
		//if string is out of bounds, return error message
		else 
			return ("The selected string is not in bounds, Try again.");

	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		//check whether string is in bounds, if so, continue
		if(isStringInBounds(encryptedText)) 
		{
			//variables for result and key
			String result = "";
			int keyCopy = key;
			
			//check whether key is outside bounds, if so, reduce key until it's in bounds
			while(keyCopy > 95)
				key-=64;
				
			//for each character in encryptedText, subtract key from current character in encryptedText, then cast to char
			for(int i = 0; i < encryptedText.length(); i++)
				result += (char) (encryptedText.charAt(i) - key);

			//return result
			return result;
		}
		
		//if string is out of bounds, return error message
		else 
			return ("The selected string is not in bounds, Try again.");

		}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		//check whether string is in bounds, if so, continue
		if(isStringInBounds(encryptedText)) 
		{
			//variables for resulting string, key, countKey that counts number of chars in key, and the encrypted char
			String result = "";
			String key = "";
			int countKey = 0; 
			int encryptedInt = 0;
			
			//repeat for each character in plainText
			for(int i = 0; i < encryptedText.length(); i++)
			{
				//check whether countKey > bellasoStr's length, if so, set countKey to 0
				if(countKey >= bellasoStr.length())
					countKey = 0;
				
				//add bellasoStr's char at pos countKey to key, increment countKey by 1
				key += bellasoStr.charAt(countKey);
				countKey++;
			}
			
			//repeat for each character in plainText
			for(int i = 0; i < encryptedText.length(); i++)
			{
				//set encryptedChar to current char in key subtracted from current char in encryptedText, casted to char
				encryptedInt = (encryptedText.charAt(i) - key.charAt(i));
				
				//add range to encryptedChar if it is out of range
				while(encryptedInt < LOWER_RANGE)
					encryptedInt += RANGE;
				
				//add encryptedChar to result
				result += (char) encryptedInt;
			}
			
			//return result
			return result;
		}
		//if string is out of bounds, return error message
		else 
			return ("The selected string is not in bounds, Try again.");
	}
}


