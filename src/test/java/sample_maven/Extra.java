package sample_maven;

import org.testng.annotations.Test;

public class Extra {

	@Test(groups="smoke")
	public void extraTodo()
	{
		System.out.println("--extra     todo--");
	}
}
