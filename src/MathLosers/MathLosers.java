package MathLosers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://programmers.co.kr/learn/courses/30/lessons/42840

class MathLosers{
	public static class Solution {

		public static int[] solution(int[] answers) {

	        int[] a01 = {1,2,3,4,5};
	        int[] a02 = {2,1,2,3,2,4,2,5};    
	        int[] a03 = {3,3,1,1,2,2,4,4,5,5};
	        
	        int[] scores = {0,0,0};
	        
	        for(int i = 0 ; i < answers.length ; i++){
	            if(answers[i] == a01[i%5]) scores[0]++;
	            if(answers[i] == a02[i%8]) scores[1]++;
	            if(answers[i] == a03[i%10]) scores[2]++;
	        }
	        
	       System.out.println("a01: "+scores[0]);
	       System.out.println("a02: "+scores[1]);
	       System.out.println("a03: "+scores[2]);
	       
	        

	        
	        int max = scores[0];
	        int[] answer = {1};

	        for (int i = 1; i < scores.length; i++) {
	            if (scores[i] > max) {
	                max = scores[i];
	                answer = new int[]{i+1};
	            }
	            else if (scores[i] == max){
	                answer = Arrays.copyOf(answer, answer.length+1);
	                answer[i] = i+1 ;
	            }
	        }
	        return answer;
	    }
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		List<Integer> list = new ArrayList<Integer>();

		for( String _s : scan.nextLine().split(" ")){
			Integer _I = Integer.parseInt(_s);
			list.add(_I.intValue());
		}
		
		int[] arr = list.stream().mapToInt(i -> i).toArray();

		System.out.println(Arrays.toString(Solution.solution(arr)));
		scan.close();
	}
    
}
