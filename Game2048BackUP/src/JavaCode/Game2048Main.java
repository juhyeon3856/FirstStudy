package JavaCode;

import java.util.Scanner;

public class Game2048Main {
	
	int[][] map = new int[4][4];
	Scanner in;
	Game2048 func;
	int num;
	int score;
	
	
	public Game2048Main(){
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		func = new Game2048();
		num = -1;
		score = 0;
		}
	
	
	public int[] turn(int[] array, String dir) {
		score =  array[16];
		num =  array[17];
		
		int[] result = new int[18];
		for(int i = 0;i < 4;i++) {
			for(int j = 0;j < 4;j++) {
				map[i][j] = array[4*i+j];
			}
		}
		if (func.findZero(map)==0) {
			for(int i = 0;i < 16;i++) { result[i] = -1;	}
			result[16]=score;
			result[17]=num;
			return result;
		} else {
			map = func.move(map, dir);
			int randVu = func.randValue();
			int[] randIdx = func.randIndex(map);
			map[randIdx[0]][randIdx[1]] = randVu;
			num += 1;
			score += randVu;
			for(int i = 0;i < 4;i++) {
				for(int j = 0;j < 4;j++) {
					result[4*i+j] = map[i][j];
				}
			}
			result[16]=score;
			result[17]=num;
			return result;
		}

	}


}


