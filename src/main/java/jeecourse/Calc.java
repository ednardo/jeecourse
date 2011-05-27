package jeecourse;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;


public class Calc {

	private DecimalFormat NUMBER_FORMAT = new DecimalFormat("0");
	
	public String add(String left, String right) {
		
		int sizeResult = getBiggerStringSize(left, right) + 1;
		
		char[] leftArray = createShiftedRightArray(left, sizeResult);
		char[] rightArray = createShiftedRightArray(right, sizeResult);				
		
		int result[] = new int[sizeResult];
		int somaDigitos = 0;
		for (int indice = sizeResult -1; indice >= 0; indice--) {
			somaDigitos += toInt(leftArray[indice]) + toInt(rightArray[indice]);
			if (somaDigitos > 9) {
				result[indice] = somaDigitos - 10;
				somaDigitos = 1;
			}else{
				result[indice] = somaDigitos;
				somaDigitos = 0;
			}			
		}
		
		return toString(result);	
	}
	
	public String subtract(String left, String right) {			
		
		return "";
	}

	private int toInt(char character) {
		return Character.digit(character, 10);
	}

	private char[] createShiftedRightArray(String string, int size) {
		
		NUMBER_FORMAT.setMinimumIntegerDigits(size - string.length());		
		char array[] = Arrays.copyOf((NUMBER_FORMAT.format(0) + string).toCharArray(), size);
		
		return array;
	}

	private int getBiggerStringSize(String left, String right) {
		return left.length() > right.length() ? left.length() : right.length();
	}
	
	public static void main(String[] args) {
		System.out.println(new BigDecimal("12345678901230980980980980980912").add(new BigDecimal("98345678901230980980980980980932")));
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
		return string.toString();
	}
 
}
