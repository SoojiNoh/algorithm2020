package Spicy;

import static org.junit.Assert.*;

import org.junit.Test;

import Spicy.Spicy.Solution;

public class SpicyHeapTest {



	@Test
	public void SolutionTest(){
		assertEquals(2, Solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
	}
}
