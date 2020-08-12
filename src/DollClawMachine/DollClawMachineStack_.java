package DollClawMachine;
import java.util.Stack;

import DollClawMachine.DollClawMachine_.Solution;

//https://programmers.co.kr/learn/courses/30/lessons/64061

class DollClawMachineStack_ {

	static class Solution {
	    public static int solution(int[][] board, int[] moves) {
	        int answer = 0;
	        
	        Stack<Integer> stack = new Stack<>(); //basket
	        
	        for (int move : moves) {
	        	
	            for (int j = 0; j < board.length; j++) {
	            	
	                if (board[j][move - 1] != 0) {
	                	
	                    if (stack.isEmpty()) {
	                        stack.push(board[j][move - 1]);
	                        board[j][move - 1] = 0;
	                        break;
	                    }
	                    
	                    if (board[j][move - 1] == stack.peek()) { // peek: 최근에 추가된(top) 데이터 조회
	                        stack.pop();
	                        answer += 2;
	                    } else
	                        stack.push(board[j][move - 1]);
	                    
	                    board[j][move - 1] = 0;
	                    break;
	                }
	                
	            }
	            
	        }
	        
	        System.out.println(answer);
	        return answer;
	    }
	}
	
	public static void main(String[] args) {


		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};

		int[] moves = {1,5,3,5,1,2,1,4};
		
		Solution.solution(board, moves);

	}
}
