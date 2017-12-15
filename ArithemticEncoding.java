import java.util.Arrays;
import java.util.Scanner;

public class Encode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter message to encode:");
		String message = sc.next();
		sc.close();
		
		double messageSize = message.length();
		char[] chars = message.toCharArray();
		chars = removeDuplicates(chars);
		Arrays.sort(chars);
		double[] props = new double[chars.length];
		for (int i = 0; i < chars.length; i++) {
			props[i] = countCharInMessage(message, chars[i]) / messageSize;
		}
		double[] edgeLeft = new double[props.length];
		double[] edgeRight = new double[props.length];

		edgeLeft[0] = 0.0;

		for (int i = 0; i < props.length; i++) {
			if (i != 0) {
				edgeLeft[i] = edgeRight[i - 1];
			}
			edgeRight[i] = edgeLeft[i] + props[i];

		}

		double[] messageEdgeLeft = new double[(int) messageSize];
		double[] messageEdgeRight = new double[(int) messageSize];

		for (int i = 0; i < messageSize; i++) {
			char cur = message.charAt(i);
			for (int j = 0; j < edgeLeft.length; j++) {
				if (cur == chars[j]) {
					messageEdgeLeft[i] = edgeLeft[j];
					messageEdgeRight[i] = edgeRight[j];
				}
			}
		}

		double R = 1.0;
		double L = 0.0;
		System.out.println(" => L: 0" + "   R: 1.0");
		for (int i = 0; i < messageEdgeLeft.length; i++) {
			double B = (R - L);
			R = L + B * messageEdgeRight[i];
			L = L + B * messageEdgeLeft[i];
			System.out.println(message.charAt(i) + "=> " + "L:" + L + "   R:" + R + "  Differenz:" + (R-L));
		}
	}

	/**
	 * Removes all duplicate entries in an array
	 * 
	 * @param arr
	 * @return array with no duplicates
	 */
	public static char[] removeDuplicates(char[] arr) {
		int end = arr.length;

		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (arr[i] == arr[j]) {
					int shiftLeft = j;
					for (int k = j + 1; k < end; k++, shiftLeft++) {
						arr[shiftLeft] = arr[k];
					}
					end--;
					j--;
				}
			}
		}
		char[] whitelist = new char[end];
		for (int i = 0; i < end; i++) {
			whitelist[i] = arr[i];
		}
		return whitelist;
	}

	/**
	 * Counts the occurrence of a given char with in a given string
	 * 
	 * @param message
	 * @param charToCount
	 * @return
	 */
	public static double countCharInMessage(String message, char charToCount) {
		double count = 0;
		for (int i = 0; i < message.length(); i++) {
			if (message.charAt(i) == charToCount) {
				count++;
			}
		}
		return count;
	}
}
