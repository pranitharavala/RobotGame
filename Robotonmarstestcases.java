package kayak;

import org.junit.*;

import org.junit.jupiter.api.Test;

class Robotonmarstestcases {

	@Test
	public void TestCase1() {
		Assert.assertEquals("[0:2]", robotonMars.cartesiangrid("FF"));
	}

	@Test
	public void TestCase2() {
		Assert.assertEquals("[1:2]", robotonMars.cartesiangrid("FFRF"));
	}

	@Test
	public void TestCase3() {
		Assert.assertEquals("[-2:2]", robotonMars.cartesiangrid("FFRRRFF"));
	}

	@Test
	public void TestCase4() {
		Assert.assertEquals("[-2:2]", robotonMars.cartesiangrid("FFLFF"));
	}

}
