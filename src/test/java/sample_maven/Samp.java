package sample_maven;

import org.testng.annotations.Test;

public class Samp {
	@Test(groups="smoke")
	public void extra()
	{
		System.out.println("--extra     --");
	}
}
