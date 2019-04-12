/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RomanNumeralConverterTest {
	RomanNumeralConverter converter = null;

	static HashMap<String, Integer> testControlRomanNumerals = new HashMap(5);
	static {
		testControlRomanNumerals.put("MMCM", 2900);
		testControlRomanNumerals.put("XLXXIX", 69);
		testControlRomanNumerals.put("DLXLIXV", 604);
		testControlRomanNumerals.put("CDLXLV", 495);
		testControlRomanNumerals.put("CMLXLIII", 993);
	};

	static HashMap<Integer, String> testControlDecimals = new HashMap(5);
	static {
		testControlDecimals.put(6252, "MMMMMMCCLII");
		testControlDecimals.put(9256, "MMMMMMMMMCCLVI");
		testControlDecimals.put(26, "XXVI");
		testControlDecimals.put(345, "CCCXLV");
		testControlDecimals.put(1, "I");
	};

	// Used for formatting time trackers
	SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");

	public RomanNumeralConverterTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		converter = new RomanNumeralConverter();
		System.out.println(dateFormat.format(new Date()));
	}

	@After
	public void tearDown() {
		converter = null;
		System.out.println(dateFormat.format(new Date()) + "\n");
	}

	@Test
	public void testFromRomanNumeral() {
		for(String romanNumeral : testControlRomanNumerals.keySet()) {
			System.out.println("Roman Numeral: " + romanNumeral + " - Decimal: " + testControlRomanNumerals.get(romanNumeral));

			// We parse it as Integer to prevent a warning stating that we invoce `assertEquals` ambiguously
			int actualValue = converter.fromRomanNumeral(romanNumeral);
			int expectedValue = testControlRomanNumerals.get(romanNumeral);

			assertNotNull(actualValue);
			assertEquals(actualValue, expectedValue);
		}
	}

	@Test
	public void testToRomanNumeral() {
		for(int decimalNumber : testControlDecimals.keySet()) {
			System.out.println("Decimal: " + decimalNumber + " - Roman Numeral: " + testControlDecimals.get(decimalNumber));

			String actualValue = converter.toRomanNumeral(decimalNumber);
			String expectedValue = testControlDecimals.get(decimalNumber);

			assertNotNull(actualValue);
			assertEquals(actualValue, expectedValue);
		}
	}

}
