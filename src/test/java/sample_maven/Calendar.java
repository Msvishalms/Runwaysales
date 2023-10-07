package sample_maven;

import org.testng.annotations.Test;

public class Calendar {

	@Test(groups = "smoke")
	public void createTodo()
	{
		System.out.println("--create todo--");
	}
	
	@Test(groups = "regression")
	public void modifyTodo()
	{
		System.out.println("--modify todo--");
	}
	@Test(groups = "regression")
	public void delete()
	{
		System.out.println("--delete--");
	}
	@Test(groups = "regression")
	public void delee()
	{
		System.out.println("--delete--");
	}
}
