package DollClawMachine;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/64061

class DollClawMachine_ {

	static class Solution {
		public static int solution(int[][] board, int[] moves) {
			int answer = 0;
			
			int[] basket= new int[board.length*board.length];
			int basket_top = -1;
			
			int[] tops = new int[board.length];
			Arrays.fill(tops, board.length); // 모든 격자 열의 top은 empty(:5=board.length), full(=0)
			
			for(int col = 0 ; col<board.length ; col++){
				for(int row = 0 ; row<board.length ; row++){
					if (board[row][col] != 0){
						tops[col] = row;
						break;
					}
					
				}
			}
			
//			print(board, basket, tops);
			
			for(int move : moves){
				int _col = move-1;
				
				System.out.println("move: "+move);
				
		
				if(tops[_col]<board.length){ //만약 해당 격자 열이 empty가 아닐 때
					int _elm = board[tops[_col]][_col];
					board[tops[_col]++][_col] = 0;
					
					
					if (basket_top!=-1 && basket[basket_top] == _elm){ //바구니 인형 터뜨리기 (basket popping)

							basket[basket_top--]=0;
							answer+=2;

						System.out.println("pop!! answer: "+answer);
					} else if (basket_top<basket.length){ //그냥 쌓기 (basket stack)
						basket[++basket_top] = _elm;
					}
				}
				
//				print(board, basket, tops);
			}
			
			
			System.out.println("answer: "+answer);
		
			
			return answer;
		}
		
//		public static void print(int[][] board, int[] basket, int[] tops){
//			
//			System.out.println();
//			
//			for (int[] col : board){
//				for (int _elm : col)
//					System.out.print(_elm+" ");
//				System.out.println();
//			}
//			
//			System.out.println();
//			
//			for (int _elm : basket)
//				System.out.println(_elm);
//			
//			System.out.println();
//			
//		}
	}

	public static void main(String[] args) {


		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};

		int[] moves = {1,5,3,5,1,2,1,4};
		
		Solution.solution(board, moves);

	}

}
