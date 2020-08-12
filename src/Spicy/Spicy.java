package Spicy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import static java.util.stream.Collectors.toList;

//https://programmers.co.kr/learn/courses/30/lessons/42626

class Spicy {

	public static class Solution {
	    public static int solution(int[] scoville, int K) {
	        int answer = 0;
	        
	      //boxed() : primitive 타입을 wrapper 타입으로 박싱하여 반환한다. cf.mapToInt()
	        List<Integer> list = Arrays.stream(scoville).boxed().collect(toList());
	        		
	        
	        List<Integer> i_below =  list.stream().filter(s-> s<K )
	        										.map(e->list.indexOf(e))
	        										.collect(toList());
	        
	        List<Integer> belows = i_below.stream().map(i->list.get(i)).sorted(Comparator.reverseOrder()).collect(toList());
	        i_below.forEach(i->list.remove(i));
	        

	        @SuppressWarnings("unused")
	        int _i01, _v01, _i02, _v02, _v03;
	        
	        for ( ; !belows.isEmpty() ; answer++){
		        _v01 = belows.get(0);
		        belows.remove(0);
		        
		        if (belows.size()==0) {
		        	_i02 = list.indexOf(Collections.min(list));
			        _v02 = list.get(_i02);
			        list.remove(_i02);
			        
		        }
		        else {
			        _v02 = belows.get(0);
			        belows.remove(0);
		        }
		        
		        //_v03 :: new scoville value
		        _v03 = _v01 + ( 2 * _v02 );
		        
		        if (_v03<K){
		        	belows.add(_v03);
		        	belows.stream().sorted(Comparator.reverseOrder());
		        }
		        else list.add(_v03);
		        
	        }
	        
	        if (list.isEmpty())
	        	return -1; // couldn't make all scoville values > K
	        else
	        	return answer;
	    }
	}
	
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
