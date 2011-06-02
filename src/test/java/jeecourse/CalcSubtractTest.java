package jeecourse;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcSubtractTest {
	
	@Test
	public void shortValuesSameDigitNumber() {
		assertEquals("Valor da Subtração", "9", new Calc().subtract("10", "1"));
		assertEquals("Valor da Subtração", "1", new Calc().subtract("2", "1"));
		assertEquals("Valor da Subtração", "8", new Calc().subtract("9", "1"));
		assertEquals("Valor da Subtração", "0", new Calc().subtract("1", "1"));		
	}

	@Test
	public void thousandValuesSameDigitNumber() {
		assertEquals("Valor da Subtração 10000 - 10000", "0", new Calc().subtract("10000", "10000"));
		assertEquals("Valor da Subtração 10001 - 10000", "1", new Calc().subtract("10001", "10000"));
		assertEquals("Valor da Subtração 99999 - 99999", "0", new Calc().subtract("99999", "99999"));
		assertEquals("Valor da Subtração 946466 - 545465", "401001", new Calc().subtract("946466", "545465"));
	}

	@Test
	public void shortValuesSameDigitNumberNegatives() {
		assertEquals("Valor da Subtração", "-1", new Calc().subtract("1", "2"));
		assertEquals("Valor da Subtração", "-8", new Calc().subtract("1", "9"));
		assertEquals("Valor da Subtração", "-11", new Calc().subtract("1", "12"));
	}

	@Test
	public void thousandValuesSameDigitNumberNegatives() {
		assertEquals("Valor da Subtração 10000 - 10001", "-1", new Calc().subtract("10000", "10001"));
		assertEquals("Valor da Subtração 545465 - 946466", "-401001", new Calc().subtract("545465", "946466"));
	}
	
	@Test
	public void longValuesSameDigitNumber() {
		assertEquals("Valor da Subtração", "0", new Calc().subtract("1234567890123", "1234567890123"));
	}
	
	@Test
	public void longValuesDiftDigitNumber() {
		assertEquals("Valor da Subtração", "6546447747748435436", new Calc().subtract("6546546546546423423", "98798797987987"));
	}

	@Test
	public void giantValuesSameDigitNumber() {
		assertEquals("Valor da Subtração", "0", new Calc().subtract("12345678901230980980980980980912", "12345678901230980980980980980912"));
	}
	
//	@Test
//	public void giantValuesDiftDigitNumber() {
//		assertEquals("Valor da Subtração", "-86000000000000000000000000000020", new Calc().subtract("12345678901230980980980980980912", "98345678901230980980980980980932"));
//		assertEquals("Valor da Subtração", "-9833333322232811084519771910532413445223445514754000000000000000020", new Calc().subtract("1234567890192385723987923742984982374987239230980980980980980912", "9834567890123003470243759834275398427598432753984980980980980980932"));
//	}
}
