package jeecourse;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcCompareTest {
	
	@Test
	public void shortValuesSameDigitNumber() {
		assertEquals("Resultado da comparação", 1, new Calc().compare("2", "1"));
		assertEquals("Resultado da comparação", -1, new Calc().compare("1", "2"));
		assertEquals("Resultado da comparação", 0, new Calc().compare("1", "1"));
	}
	
	@Test
	public void thousandValuesSameDigitNumber() {
		assertEquals("Resultado da comparação 10000 / 10000", 0, new Calc().compare("10000", "10000"));
		assertEquals("Resultado da comparação 10001 / 10000", 1, new Calc().compare("10001", "10000"));
		assertEquals("Resultado da comparação 99999 / 99999", 0, new Calc().compare("99999", "99999"));
		assertEquals("Resultado da comparação 946466 / 545465", 1, new Calc().compare("946466", "545465"));
		assertEquals("Resultado da comparação 545465 / 946466", -1, new Calc().compare("545465", "946466"));
	}
	
	@Test
	public void shortValuesDiffDigitNumber() {
		assertEquals("Resultado da comparação", 1, new Calc().compare("222", "1"));
		assertEquals("Resultado da comparação", 1, new Calc().compare("11111", "2"));
		assertEquals("Resultado da comparação", -1, new Calc().compare("2", "1111111"));
		assertEquals("Resultado da comparação", 0, new Calc().compare("000001", "01"));
	}
	
	@Test
	public void giantValuesSameDigitNumber() {
		assertEquals("Resultado da comparação", 0, new Calc().compare("12345678901230980980980980980912", "12345678901230980980980980980912"));
		assertEquals("Resultado da comparação", -1, new Calc().compare("12344678901230980980980980980912", "12345678901230980980980980980912"));
		assertEquals("Resultado da comparação", 1, new Calc().compare("12346678901230980980980980980912", "12345678901230980980980980980912"));
	}
	
	@Test
	public void giantValuesDiftDigitNumber() {
		assertEquals("Resultado da comparação", 1, new Calc().compare("1234567890123098098098098098091200000", "98345678901230980980980980980932"));
		assertEquals("Resultado da comparação", -1, new Calc().compare("98345678901230980980980980980932", "1234567890123098098098098098091200000"));
	}
	
}
