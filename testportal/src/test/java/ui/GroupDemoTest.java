package ui;

import org.testng.annotations.Test;

@Test(groups="user registraition")
public class GroupDemoTest {
	
	@Test(priority=1,groups="regression")
	public void aTest1()
	{
		System.out.println("test1");
	}
	@Test(groups={"regression","bvt"})
	public void bTest2()
	{
		System.out.println("test2");
	}
    @Test(groups="regression")
	public void cTest3()
	{
		System.out.println("test3");
	}
	
	@Test(groups="bvt")
	public void dTest4()
	{
		System.out.println("test4");
	}



}
