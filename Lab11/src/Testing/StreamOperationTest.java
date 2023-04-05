package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StreamOperationTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//fail("Not yet implemented");
		List<String> input = Arrays.asList("one", "two");
		List<String> expected = Arrays.asList("ONE", "TWO");
		
		assertEquals(expected, StreamOperation.function.apply(input));
		
	}
	
	@Test
	void test2() {
		Employee e1 = new Employee("Tim", 5000);
		Employee e2 = new Employee("Lim", 5000);
		
		assert(CompareEmp.CompareTwoEmployee(e1, e2) > 0);
	}
	
//	@Test
//	void test3() {
//		Employee e1 = new Employee("Tim", 5000);
//		Employee e2 = new Employee("Lim", 5000);
//		
//		assert(CompareEmp.CompareTwoEmployee(e1, e2) == 0);
//	}

}
