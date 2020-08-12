package UncompletedMarathon;

import static org.junit.Assert.*;

import org.junit.Test;

import Spicy.Spicy.Solution;

import UncompletedMarathon.Marathon;


public class MarathonTest {

	@Test
	public void SolutionTest(){
		
		String[] participants01 = new String[]{"leo", "kiki", "eden"};
		String[] participants02 = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] participants03 = new String[]{"mislav", "stanko", "mislav", "ana"};
		
		
		String[] completions01 = new String[]{"eden", "kiki"};
		String[] completions02 = new String[]{"josipa", "filipa", "marina", "nikola"};
		String[] completions03 = new String[]{"stanko", "ana", "mislav"};
		
		
				
		assertEquals(2, Solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
	}

}
