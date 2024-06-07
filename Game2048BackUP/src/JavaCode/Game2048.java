package JavaCode;

public class Game2048 {

	public Game2048() {	}


	public int randValue() {
		int exp = 3; 
		int rand = (int)(Math.random()*exp)+1;
		return (int) Math.pow(2, rand);
	}


		public int[] randIndex(int[][] map) { 
			int[] result = {0, 0};
			int rand1 = (int)(Math.random()*map.length);
			int rand2 = (int)(Math.random()*map.length);
			for (int i = rand1; i < rand1 + map.length;i++) {
				for(int j = rand2; j < rand2 + map.length;j++) {
					int iSub = (i+1)%map.length;
					int jSub = (j+1)%map.length;
					if (map[iSub][jSub] == 0) {
						result[0] = iSub;
						result[1] = jSub;
						return result;
					} 				
				}
			}
			return result;
		}
		
	
	public int[][] move(int[][] map, String direction) {
		switch (direction) {
		case "w":
			for (int j = 0; j < map.length; j++) {
				int saveIndex1 = 0;
				for (int i = 0; i < map.length; i++) {
					if (map[i][j]!=0) {
						map[saveIndex1++][j] =  map[i][j];
					}
				}
				for (int i = saveIndex1; i < map.length; i++) {
					map[i][j] = 0; 
				}
				for (int i = 0; i < saveIndex1-1; i++) {
					if (map[i][j] == map[i+1][j]) {
						map[i][j] += map[i+1][j];
						map[i+1][j] = 0;
					} 
				}
				int saveIndex2 = 0;
				for (int i = 0; i < map.length; i++) {
					if (map[i][j]!=0) {
						map[saveIndex2++][j] =  map[i][j];
					}
				}
				for (int i = saveIndex2; i < map.length; i++) {
					map[i][j] = 0; 
				}
			}
			break;
		case "s":
			for (int j = 0; j < map.length; j++) {
				int saveIndex1 = map.length-1;
				for (int i = map.length-1; i >= 0; i--) {
					if (map[i][j]!=0) {
						map[saveIndex1--][j] =  map[i][j];
					}
				}
				for (int i = saveIndex1; i >= 0; i--) {
					map[i][j] = 0; 
				}
				for (int i = map.length-1; i > saveIndex1+1; i--) {
					if (map[i][j] == map[i-1][j]) {
						map[i][j] += map[i-1][j];
						map[i-1][j] = 0;
					} 
				}
				int saveIndex2 = map.length-1;
				for (int i = map.length-1; i >= 0; i--) {
					if (map[i][j]!=0) {
						map[saveIndex2--][j] =  map[i][j];
					}
				}
				for (int i = saveIndex2; i >= 0; i--) {
					map[i][j] = 0; 
				}
			}
			break;
		case "a":
			for (int i = 0; i < map.length; i++) {
				int saveIndex1 = 0;
				//0�� �ƴ� ���� �������� ���Ƴִ� for��
				for (int j = 0; j < map.length; j++) {
					if (map[i][j]!=0) {
						map[i][saveIndex1++] = map[i][j];
					}
				}
				//0�� �ƴ� ���� �������� ���Ƴְ� �� ������ 0���� ä��� for��
				for (int j = saveIndex1; j < map.length; j++) {
					map[i][j] = 0; 
				}
				// �������� ���� �� �� �߿��� ���� ���� ������ ��ġ�� for��
				for (int j = 0; j < saveIndex1-1; j++) {
					if (map[i][j] == map[i][j+1]) {
						map[i][j] += map[i][j+1];
						map[i][j+1] = 0;
					} 
				}
				int saveIndex2 = 0;
				//0�� �ƴ� ���� �������� ���Ƴִ� for��
				for (int j = 0; j < map.length; j++) {
					if (map[i][j]!=0) {
						map[i][saveIndex2++] = map[i][j];
					}
				}
				//0�� �ƴ� ���� �������� ���Ƴְ� �� ������ 0���� ä��� for��
				for (int j = saveIndex2; j < map.length; j++) {
					map[i][j] = 0; 
				}
				
			}
			break;
		case "d":
			for (int i = 0; i < map.length; i++) {
				int saveIndex1 = map.length-1;
				//0�� �ƴ� ���� �������� ���Ƴִ� for��
				for (int j = map.length-1; j >= 0; j--) {
					if (map[i][j]!=0) {
						map[i][saveIndex1--] =  map[i][j];
					}
				}
				//0�� �ƴ� ���� �������� ���Ƴְ� �� ������ 0���� ä��� for��
				for (int j = saveIndex1; j >= 0; j--) {
					map[i][j] = 0; 
				}
				// �������� ���� �� �� �߿��� ���� ���� ������ ��ġ�� for��
				for (int j = map.length-1; j > saveIndex1+1; j--) {
					if (map[i][j] == map[i][j-1]) {
						map[i][j] += map[i][j-1];
						map[i][j-1] = 0;
					} 
				}
				int saveIndex2 = map.length-1;
				//0�� �ƴ� ���� �������� ���Ƴִ� for��
				for (int j = map.length-1; j >= 0; j--) {
					if (map[i][j]!=0) {
						map[i][saveIndex2--] =  map[i][j];
					}
				}
				//0�� �ƴ� ���� �������� ���Ƴְ� �� ������ 0���� ä��� for��
				for (int j = saveIndex2; j >= 0; j--) {
					map[i][j] = 0; 
				}
				
			}
			break;
		default:
		}
		return map;
	}
	
	public int findZero(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j]==0){
					cnt += 1;
				}
			}
		}
		return cnt;
	}
	
	public boolean ckeckEnd(int[][] map) {
		boolean check = true;
		String[] input = {"w", "s", "a", "d"};
		for (String dir: input) {
			if(findZero(move(map, dir)) != 0){
				check = false;
			}
		}
		
		return check;
	}
	


}