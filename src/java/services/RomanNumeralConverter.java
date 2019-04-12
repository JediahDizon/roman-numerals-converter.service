package services;

import interfaces.IRomanNumeralConverter;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter implements IRomanNumeralConverter {
	private static final Map<String, Integer> romanNumeralMap = new LinkedHashMap<String, Integer>(13);
	static {
		/**
		 * This Map showcases the Roman Numerals by their unique cahracters including
		 * those that are ligatured (for lack of a better word), hence we use the Linked
		 * Hash Map library.
		 *
		 * NOTE: Order matters for this class property as it used by the `toRomanNumeral()`
		 * function by looping through from the max value to min
		 */
		romanNumeralMap.put("M", 1000);
		romanNumeralMap.put("CM", 900);
		romanNumeralMap.put("D", 500);
		romanNumeralMap.put("CD", 400);
		romanNumeralMap.put("C", 100);
		romanNumeralMap.put("XC", 90);
		romanNumeralMap.put("L", 50);
		romanNumeralMap.put("XL", 40);
		romanNumeralMap.put("X", 10);
		romanNumeralMap.put("IX", 9);
		romanNumeralMap.put("V", 5);
		romanNumeralMap.put("IV", 4);
		romanNumeralMap.put("I", 1);
	}

	/**
	 * This property is an inverse of the `romanNumeralMap` property. This exist
	 * to make accessing the map faster at the expense of memory allocation.
	 * Otherwise, to get the Roman Numeral value of a number, the program has to
	 * loop through the `romanNumeralMap` and find the key by value for every single
	 * conversion attempt which is time inefficient.
	 */
	private static final Map<Integer, String> decimalMap = new LinkedHashMap<Integer, String>(romanNumeralMap.size());
	static {
		for (String romanNumeralKey : romanNumeralMap.keySet()) {
			decimalMap.put(romanNumeralMap.get(romanNumeralKey), romanNumeralKey);
		}
	}

	/**
	 * This function gets a String object containing roman numeral
	 * characters and outputs the corresponding decimal value. This is implemented
	 * by firstly determining how many consecutive occurence each roman numeral
	 * character has on the parameterized string and performaning calculation with
	 * that information.
	 *
	 * @param romanNumeral The String of roman numerals to be converted
	 * @return The corresponding decimal value of the parameterized roman numeral string
	 */
	@Override
	public int fromRomanNumeral(String romanNumeral) {
		int toReturn = 0;

		for(String romanNumeralKey : romanNumeralMap.keySet()) {
			// Determine how many consecutive roman numerals are there starting from the maximmum value
			int consecutiveCount = 0;
			for(int index = 0; index < romanNumeral.length(); index += romanNumeralKey.length()) {
				// Firstly, prevent an `IndexOutOfBoundsException` that will happen if the `romanNumeralKey` is longer than the parameterized `romanNumeral` String
				if
				(
					romanNumeral.length() < romanNumeralKey.length() ||
					romanNumeral.length() < romanNumeralKey.length() + index
				) break;

				if(romanNumeralKey.equals(romanNumeral.substring(index, index + romanNumeralKey.length()))) consecutiveCount++;
				else break;
			}

			// If there is one or more consecutive count of the numeric value from the parameterized roman numeral string, calculate the `toReturn` variable accordingly
			if(consecutiveCount > 0) {
				// Add the corresponding decimal value to the `toReturn` by using the `romanNumeralKey` variable in the `romanNumeralMap`
				toReturn += romanNumeralMap.get(romanNumeralKey) * consecutiveCount;

				// Determine how many characters to pop from the parameterized `romanNumeral` string to make way for the other roman numeral keys
				// Java 11 String object has a `repeat()` function that repeats the string `n` times. I however only have Java 8 installed.
				int charsToRemove = new String(new char[consecutiveCount]).replace("\0", romanNumeralKey).length();

				// Truncate the roman numeral from the original string value to make way for the other roman numeral keys
				romanNumeral = romanNumeral.substring(charsToRemove);
			}

			if(romanNumeral.length() <= 0) break;
		}

		return toReturn;
	}

	/**
	 * This function will take in an integer that will then be
	 * converted into a String representing the value in Roman Numerals.
	 * This is implemented by determining how many times a roman numeral can be
	 * divided from the specified number.
	 *
	 * @param number The integer value to be converted
	 * @return The String object representing the roman numeral value of the parameterized integer
	 */
	@Override
	public String toRomanNumeral(int number) {
		// Considering we append the String object to return, it's best to use a `StringBuilder` class as it uses buffer to allocate String objects
		StringBuilder toReturn = new StringBuilder();

		for(String romanNumeralKey : romanNumeralMap.keySet()) {
			// This defines the value to divide the original number with
			int divisor = romanNumeralMap.get(romanNumeralKey);

			// This will define how many times the roman numeral character is written
			int quotient = number/divisor;

			if(quotient > 0) {
				// Repeat the current `romanNumeralKey` variable by the quotient
				// Java 11 String object has a `repeat()` function that repeats the string `n` times. I however only have Java 8 installed.
				String finalString = new String(new char[quotient]).replace("\0", romanNumeralKey);

				toReturn.append(finalString);
			}

			// Subtract the number to eliminate the qualifying roman numeral from the result string
			number -= divisor * quotient;
		}

		return toReturn.toString();
	}
}