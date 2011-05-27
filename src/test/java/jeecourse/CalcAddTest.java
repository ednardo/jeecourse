package jeecourse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Ignore;
import org.junit.Test;

public class CalcAddTest {

	@Test
	public void shortValuesSameDigitNumber() {
		assertEquals("Valor da Soma", "2", new Calc().add("1", "1"));
		assertEquals("Valor da Soma", "3", new Calc().add("2", "1"));
		assertEquals("Valor da Soma", "3", new Calc().add("1", "2"));
		assertEquals("Valor da Soma", "5", new Calc().add("3", "2"));
	}
	
	@Test
	public void thousandValuesSameDigitNumber() {
		assertEquals("Valor da Soma", "20000", new Calc().add("10000", "10000"));
		assertEquals("Valor da Soma", "20001", new Calc().add("10000", "10001"));
		assertEquals("Valor da Soma", "199998", new Calc().add("99999", "99999"));
	}
	
	@Test
	public void shortValuesDiftDigitNumber() {
		assertEquals("Valor da Soma", "1501", new Calc().add("1500", "1"));
		assertEquals("Valor da Soma", "1502", new Calc().add("2", "1500"));
		assertEquals("Valor da Soma", "41", new Calc().add("39", "2"));
		assertEquals("Valor da Soma", "41", new Calc().add("9", "32"));
	}
	
	@Test
	public void thousandValuesDiftDigitNumber() {
		assertEquals("Valor da Soma", "10018", new Calc().add("10009", "9"));
	}
	
	@Test
	public void longValuesSameDigitNumber() {
		assertEquals("Valor da Soma", "2469135780246", new Calc().add("1234567890123", "1234567890123"));
	}
	
	@Test
	public void longValuesDiftDigitNumber() {
		assertEquals("Valor da Soma", "6546645345344411410", new Calc().add("6546546546546423423", "98798797987987"));
	}

	@Test
	public void giantValuesSameDigitNumber() {
		assertEquals("Valor da Soma", "24691357802461961961961961961824", new Calc().add("12345678901230980980980980980912", "12345678901230980980980980980912"));
	}
	
	@Test
	public void giantValuesDiftDigitNumber() {
		assertEquals("Valor da Soma", "110691357802461961961961961961844", new Calc().add("12345678901230980980980980980912", "98345678901230980980980980980932"));
	}

	@Ignore
	public void invalidNumbers() {
		new Calc().add("a", "b");
		fail("Não deveria somar caracteres");
	}
}
