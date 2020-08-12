package GroupVocaCheck;

import java.util.Arrays;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1316


class GroupVocaCheck {
	
	public static class Solution{
		
			static boolean[] ascii = new boolean[59];

		public static boolean isGroupVoca(String voca){
			
			Arrays.fill(ascii, false);
			
			char prev = 0;
			for (char ch : voca.toCharArray()){
				if(prev != ch){
					if (ascii[ch-65]) return false;
					else ascii[ch-65] = true;
				}
				
				prev = ch;
			}

//			for(int i = 0 ; i < ascii.length ; i++){
//				if (ascii[i] == true) System.out.println((char)(i+65));
//			}
//			
			
			return true;
		}
	}
	

	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		
		int num = Integer.parseInt(scan.nextLine());
		
		// cf. nextInt :: does not read the newline character
		// 참고: https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/
		

		int result = 0;
		
		for(int i = 0 ; i < num ; i++){
			if (Solution.isGroupVoca(scan.nextLine())) result ++;
		}
		
		System.out.println(result);
		
		scan.close();
	}
}

