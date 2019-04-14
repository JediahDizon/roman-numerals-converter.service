/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

	// Test Controls
	private HashMap<String, Integer> testControlRomanNumerals;
	private HashMap<Integer, String> testControlDecimals;
	private ArrayList<String> testBadRomanNumerals;
	private ArrayList<Integer> testBadDecimals;

	// Used for formatting time trackers
	SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");

	public RomanNumeralConverterTest() {
		testControlRomanNumerals = new HashMap(10);
		testControlRomanNumerals.put("MMCM", 2900);
		testControlRomanNumerals.put("LXIX", 69);
		testControlRomanNumerals.put("DCIV", 604);
		testControlRomanNumerals.put("CDXCV", 495);
		testControlRomanNumerals.put("CMXCIII", 993);

		testControlRomanNumerals.put("MMMMMMCCLII", 6252);
		testControlRomanNumerals.put("MMMMMMMMMCCLVI", 9256);
		testControlRomanNumerals.put("XXVI", 26);
		testControlRomanNumerals.put("CCCXLV", 345);
		testControlRomanNumerals.put("I", 1);

		testControlDecimals = new HashMap(10);
		testControlDecimals.put(2900, "MMCM");
		testControlDecimals.put(69, "LXIX");
		testControlDecimals.put(604, "DCIV");
		testControlDecimals.put(495, "CDXCV");
		testControlDecimals.put(993, "CMXCIII");

		testControlDecimals.put(6252, "MMMMMMCCLII");
		testControlDecimals.put(9256, "MMMMMMMMMCCLVI");
		testControlDecimals.put(26, "XXVI");
		testControlDecimals.put(345, "CCCXLV");
		testControlDecimals.put(1, "I");

		testBadRomanNumerals = new ArrayList<String>(3);
		testBadRomanNumerals.add("1I");
		testBadRomanNumerals.add("MCM242");
		testBadRomanNumerals.add(null);

		testBadDecimals = new ArrayList<Integer>(2);
		testBadDecimals.add((int) -1.3333);
		testBadDecimals.add(Integer.MAX_VALUE + 1);
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
			assertEquals(expectedValue, actualValue);
		}
	}

	@Test
	public void testToRomanNumeral() {
		for(int decimalNumber : testControlDecimals.keySet()) {
			System.out.println("Decimal: " + decimalNumber + " - Roman Numeral: " + testControlDecimals.get(decimalNumber));

			String actualValue = converter.toRomanNumeral(decimalNumber);
			String expectedValue = testControlDecimals.get(decimalNumber);

			assertNotNull(actualValue);
			assertEquals(expectedValue, actualValue);
		}
	}

	@Test
	public void testBadRomanNumerals() {
		for(String badInput : testBadRomanNumerals) {
			System.out.println("Bad Roman Numeral: " + badInput);

			boolean toReturn = false;

			try {
				converter.fromRomanNumeral(badInput);
			} catch(IllegalArgumentException error) {
				toReturn = true;
			}

			assertTrue(toReturn);
		}
	}

	@Test
	public void testBadDecimals() {
		for(int badInput : testBadDecimals) {
			System.out.println("Bad Decimal: " + badInput);

			boolean toReturn = false;

			try {
				converter.toRomanNumeral(badInput);
			} catch(IllegalArgumentException error) {
				toReturn = true;
			}

			assertTrue(toReturn);
		}
	}
}
