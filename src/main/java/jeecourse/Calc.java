package jeecourse;

import java.text.DecimalFormat;
import java.util.Arrays;


public class Calc {

	private DecimalFormat NUMBER_FORMAT = new DecimalFormat("0");
	
	public String add(String left, String right) {
		
		int sizeResult = getBiggerStringSize(left, right) + 1;
		
		char[] leftArray = createShiftedRightArray(left, sizeResult);
		char[] rightArray = createShiftedRightArray(right, sizeResult);				
		
		int result[] = new int[sizeResult];
		int digitResult = 0;
		for (int indice = sizeResult -1; indice >= 0; indice--) {
			digitResult += toInt(leftArray[indice]) + toInt(rightArray[indice]);
			if (digitResult > 9) {
				result[indice] = digitResult - 10;
				digitResult = 1;
			}else{
				result[indice] = digitResult;
				digitResult = 0;
			}			
		}
		
		return toString(result);	
	}
	
	public String subtract(String left, String right) {			
		
		int sizeResult = getBiggerStringSize(left, right);
		String sign = "";
		if (compare(left, right) == -1) {
			String tmp = left;
			left = right;
			right = tmp;
			sign = "-";
		}

		char[] leftArray = createShiftedRightArray(left, sizeResult);
		char[] rightArray = createShiftedRightArray(right, sizeResult);		

		int result[] = new int[sizeResult];

		int digitResult = 0;
		for (int indice = sizeResult - 1; indice >= 0; indice--) {
			digitResult += toInt(leftArray[indice]) - toInt(rightArray[indice]);
			if (digitResult < 0 && indice > 0 && toInt(leftArray[indice - 1]) > 0) {
				result[indice] = digitResult + 10;
				digitResult = -1;
			}else{
				result[indice] = digitResult;
				digitResult = 0;
			}			
		}

		return sign + toString(result);
	}

	public int compare(String left, String right) {			
		
		int sizeBigger = getBiggerStringSize(left, right);
		char[] leftArray = createShiftedRightArray(left, sizeBigger);
		char[] rightArray = createShiftedRightArray(right, sizeBigger);
		
		for (int indice = 0; indice < sizeBigger; indice++) {
			if (toInt(leftArray[indice]) > toInt(rightArray[indice])) return 1;
			else if (toInt(leftArray[indice]) < toInt(rightArray[indice])) return -1;					
		}
		
		return 0;
	}	
	
	private int toInt(char character) {
		return Character.digit(character, 10);
	}

	private char[] createShiftedRightArray(String string, int size) {
		
		if (string.length() == size) return string.toCharArray();
		NUMBER_FORMAT.setMinimumIntegerDigits(size - string.length());		
		char array[] = Arrays.copyOf((NUMBER_FORMAT.format(0) + string).toCharArray(), size);
		
		return array;
	}

	private int getBiggerStringSize(String left, String right) {
		return left.length() > right.length() ? left.length() : right.length();
	}
	
	private String toString(int[] intArray) {
		boolean zeroAEsquerda = true;
		StringBuilder string = new StringBuilder();
		
		for (int digito : intArray) {
			if (!zeroAEsquerda || digito != 0) {
				string.append(digito);
				zeroAEsquerda = false;
			}
		}
		if (string.length() == 0) return "0";
		return string.toString();
	}
 
}
