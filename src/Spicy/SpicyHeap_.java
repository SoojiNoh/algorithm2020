package Spicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://programmers.co.kr/learn/courses/30/lessons/42626

class SpicyHeap_ {

	public static class Solution {
	    public static int solution(int[] scoville, int K) {
	        int answer = 0;
	        
	        minHeap heap = new minHeap();
	        
	       for (int food : scoville){
	    	   	heap.insert(food);
	       }
	       
	       int _min = heap.delete();
	       
	       for ( ; heap.getSize() > 0 && _min < K ; answer++ ){
		       
	    	   _min = _min + 2 * heap.delete();
	    	   heap.insert(_min);
	    	
	    	   _min = heap.delete();
	    	   
	       }

	       
	       if (_min >= K) return answer;
	       else return -1;
	       
	    }
	    
	    public static class minHeap {
	        
	        public ArrayList<Integer> heap;
	        
	        public int getSize(){
	        	return heap.size();
	        }
	        
	        // 힙 생성자
	        public minHeap() {
	            heap = new ArrayList<>();
	            heap.add(0); // 인덱스 0 채우기 (1부터 시작하기 위함)
	        }
	        
	        // 삽입
	        public void insert(int val) {
	        	
	            heap.add(val); //우선 가장 마지막 노드에 val값 추가한 후,
	            int p = heap.size() - 1;
	            
	            // 힙 사이즈 - 1이 1보다 작아질 때까지 진행 -> root로 이동
	            while(p > 1 && heap.get(p / 2) > heap.get(p)) {
	                System.out.println("swap");
	                
	                // 부모보다 자식 노드가 더 작으면 swap (최소힙)
	                int tmp = heap.get(p/2);
	                heap.set(p/2, heap.get(p));
	                heap.set(p, tmp);
	                
	                p = p / 2; // p는 부모 값으로 변경 (부모 노드 인덱스로 이동)
	            }
	        }
	        
	        // 삭제
	        public int delete() {
	            
	            // 힙 사이즈 - 1이 1보다 작으면 0 리턴
	            if(heap.size()-1 < 1) {
	                return 0;
	            }
	            
	            // 삭제할 노드는 루트 노드임
	            int deleteItem = heap.get(1);
	            
	            // root에 가장 마지막 값 넣고 마지막 값 삭제
	            heap.set(1, heap.get(heap.size() - 1));
	            heap.remove(heap.size()-1);
	            
	            int pos = 1;
	            while((pos * 2) < heap.size()) {
	                
	                int min = heap.get(pos * 2);
	                int minPos = pos * 2;
	                
	                if (((pos*2 + 1) < heap.size()) && min > heap.get(pos*2 + 1)) {
	                    min = heap.get(pos*2 + 1);
	                    minPos = pos * 2 + 1;
	                }
	                
	                if(heap.get(pos) < min)
	                    break;
	                
	                // 부모 자식 노드 교환
	                int _tmp = heap.get(pos);
	                heap.set(pos, heap.get(minPos));
	                heap.set(minPos, _tmp);
	                pos = minPos;
	            }
	            
	            return deleteItem;
	        }
	    }
	    
	// 출처: https://kim6394.tistory.com/222 [Gyoogle (규글)]
	    
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
