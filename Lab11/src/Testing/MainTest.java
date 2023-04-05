package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.MethodName.class) //to execute test methods alphabetically
class MainTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("------ 1 -------");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("------ 2 -------");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("------ 3 -------");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("------ 4 -------");
	}

	@Test
	//@Order(2) // to order method execution
	void test() {
		System.out.println("------ test1 -------");
		//fail("Not yet implemented");
		Main cal = new Main();
		assertEquals(10,cal.add(5, 5)); //(expected value, calling the function)
	}

	@Test
	void test2() {
		System.out.println("------ test2 -------");
		Main cal = new Main();
		assertTrue(cal.add(5, 5) > 10);
	}

}
