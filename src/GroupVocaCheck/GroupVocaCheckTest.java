package GroupVocaCheck;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;



public class GroupVocaCheckTest {

	@Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Test
	public void MainTest(){
		GroupVocaCheck.main(new String[] {Integer.toString(3), "happy", "new", "year"});
		assertEquals(3, systemOutRule.getLog());
		
		GroupVocaCheck.main(new String[] {Integer.toString(1), "aba", "abab", "abcabc","a"});
		assertEquals(1, systemOutRule.getLog());
		
	}

}
