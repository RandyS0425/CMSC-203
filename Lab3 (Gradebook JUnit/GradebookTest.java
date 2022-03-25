import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ArrayBlockingQueue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	private GradeBook g1;
	private GradeBook g2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		
		g1.addScore(10.0); 
		g1.addScore(15.0);
		
		g2.addScore(20.0);
		g2.addScore(30.0);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		//remove it from memory
		g1 =  null;
		g2 =  null;
	}

	@Test
	void testSum() {
		assertEquals(25 , g1.sum());
		assertTrue(g1.sum() == 25);
		assertEquals(50 , g2.sum());
		assertTrue(g2.sum() == 50);
	}
	
	@Test
	void testAddScore() {
		assertEquals("10.0 15.0 " , g1.toString());
		assertTrue(g1.toString().equals("10.0 15.0 "));
		assertEquals("20.0 30.0 " , g2.toString());
		assertTrue(g2.toString().equals("20.0 30.0 "));
	}
	@Test
	void testMinimum() {
		assertEquals(10 ,g1.minimum());
		assertTrue(g1.minimum() == 10); 
		assertEquals(20 , g2.minimum());
		assertTrue(g2.minimum() == 20);
		
	}
}
 // set up,  teardown
// 1. setuop will be called before each test
// 2. teardown is going to be called after
// 3. all test are independent from each other
// 4. tests are not going to run in order
