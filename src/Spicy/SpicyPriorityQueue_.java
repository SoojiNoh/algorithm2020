package Spicy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://programmers.co.kr/learn/courses/30/lessons/42626

class SpicyPriorityQueue_ {

	public static class Solution {
	    public static int solution(int[] scoville, int K) {
	        PriorityQueue<Integer> q = new PriorityQueue<>();

	        for(int i = 0; i < scoville.length; i++)
	            q.add(scoville[i]);

	        int count = 0;
	        while(q.size() > 1 && q.peek() < K){
	            int weakHot = q.poll(); 
	            int secondWeakHot = q.poll(); 

	            int mixHot = weakHot + (secondWeakHot * 2);
	            q.add(mixHot);
	            count++;
	        }

	        if(q.size() <= 1 && q.peek() < K)
	            count = -1;

	        return count;
	    }

	}
	
	// offer(data); queue에 데이터를 집어 넣습니다.
	// poll() : queue에 있는 맨 앞에 있는 데이터를 뽑습니다.
	// peek() : queue의 맨 앞의 데이터를 확인합니다.
	// 출처 : https://gamjatwigim.tistory.com/72
	
	
	
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		List<Integer> _list = new ArrayList<Integer>();
		
		for ( String _s : scan.nextLine().split(" ")){
			Integer _I = Integer.parseInt(_s);
			_list.add(_I.intValue());
		}
		
		int[] _arr = _list.stream().mapToInt(i->i).toArray();
		
		int K = scan.nextInt();
		
		System.out.println(Solution.solution(_arr, K));
		
		scan.close();
		
	}
}
