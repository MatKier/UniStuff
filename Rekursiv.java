public class Rekursiv {

	public static void main(String[] args) {


	}

	public static boolean istPrim(int number) {
		if (number == 1 || number == 0) {
			return false;
		}
		return istPrimzahl(number, 2);
	}

	private static boolean istPrimzahl(int number, int teiler) {
		if (number == 2 || teiler == number - 1) {
			return true;
		} else if (number % teiler == 0) {
			return false;
		} else {
			return istPrimzahl(number, teiler + 1);
		}
	}

	public static String rebase(int number, int s) {
		if (number == 0) {
			return "0";
		}
		String rebasedNumber = "";

		if (s == 2) {
			rebasedNumber = convertToBinary(number, "");
		} else if (s == 16) {
			rebasedNumber = convertToHexadec(number, "");
		}
		// Zeile die ich jetzt gerne schreiben würde:
		// return new StringBuffer(rebasedNumber).reverse().toString();
		return reverseString(rebasedNumber);
	}

	private static String convertToBinary(int number, String binary) {
		if (number != 0) {
			return convertToBinary(number / 2, binary += (number % 2) + "");
		} else {
			return binary;
		}
	}

	private static String convertToHexadec(int number, String hexaDec) {
		if (number != 0) {
			return convertToHexadec(number / 16,
					hexaDec += convertToHexDigit(number % 16) + "");
		}
		return hexaDec;
	}

	private static String convertToHexDigit(int digit) {
		String hexDigit = "";
		switch (digit) {
		case 10:
			hexDigit = "A";
			break;
		case 11:
			hexDigit = "B";
			break;
		case 12:
			hexDigit = "C";
			break;
		case 13:
			hexDigit = "D";
			break;
		case 14:
			hexDigit = "E";
			break;
		case 15:
			hexDigit = "F";
			break;
		default:
			hexDigit = digit + "";
			break;
		}
		return hexDigit;
	}

	private static String reverseString(String string) {
		char c = string.charAt(string.length() - 1);
		if (string.length() == 1) {
			return Character.toString(c);
		}
		return c + reverseString(string.substring(0, string.length() - 1));
	}

	private static boolean isPrimIt(int number) {
		for (int i = number; i < 2; i--) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
