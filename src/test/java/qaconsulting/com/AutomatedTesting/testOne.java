package qaconsulting.com.AutomatedTesting;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testOne {
	
	@BeforeClass
	public static void init() {
		System.out.println("(BeforeClass) Initialisation. Runs once before anything else");
	}

	@Before
	public void setUp() {
		System.out.println("(Before) Setup. Runs once before each test.");
	}
	
	@Test
	public void test() {
		System.out.println("(Test) Hello world!");
	}
	
	@After
	public void tearDown() {
		System.out.println("(After) tearDown. Runs once after each test");
	}
	
	@AfterClass
	public static void destroy() {
		System.out.println("(AfterClass) destroy. Runs last.");
	}
}
