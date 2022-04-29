package test.ng.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsTestNG {

	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertTrue(false);

	}

	@Test
	public void test1() {
		Assert.assertTrue(false);

	}

	@Test
	public void test2() {
		Assert.assertEquals("Test", "Test1");

	}

	@Test
	public void test3() {
		Assert.assertEquals("Test", "Test2");

	}

	@Test
	public void test4() {
		Assert.assertTrue(false, "not matching the expected conditon");

	}
	
	@Test
	public void test5() {
		Assert.assertFalse(false, "This is expected");

	}
	
	@Test
	public void test6() {
		Assert.assertNotEquals("Test", "test1");

	}

}
