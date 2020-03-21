package pt.iscte.lei.es2.Trabalho1_6._Grupo_13;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

class AppTest {
	
	String input = "þ.<NL[N]	6NW\\JPN";
	private final ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private final InputStream originalIn = System.in;
	private final PrintStream originalOut = System.out;

	
	
	@BeforeEach()
	public void setUpStreams() {
		System.setIn(inContent);
	    System.setOut(new PrintStream(outContent));
	}

	@AfterEach()
	public void restoreStreams() {
		System.setIn(originalIn);
	    System.setOut(originalOut);
	}

	@Test
	void test() {
		String args[] = new String[1];
		args[0] = "þ.<NL[N]	6NW\\JPN";
		App.main(args);
		assertEquals("Secret Mensage\r\n", outContent.toString());
	}

}
