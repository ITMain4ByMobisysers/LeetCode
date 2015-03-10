package leetcode;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
//		int M = dungeon.length;
//		int N = dungeon[0].length;
//		int[][] arr = new int[M][N];
//		int[][] life = new int[M][N];
//		int[][] clone = new int[M][N];
//		
//		for(int i = M-1; i >= 0; i--)
//			for(int j = N-1; j >= 0; j--)
//				clone[M-1-i][N-1-j] = dungeon[i][j];
//		
//		for(int i = 0;i<N;i++){
//			if(i==0){
//				if(clone[0][i]<0){
//					arr[0][i] = 1-clone[0][i];
//					life[0][i] = 1;
//				}
//				else{
//					arr[0][i] = 1;
//					life[0][i] = clone[0][i]+1;
//				}
//			}else{
//				if(clone[0][i]+life[0][i-1]<=0){
//					arr[0][i] = 1-(clone[0][i]+clone[0][i-1]);
//					life[0][1] = 1;
//				}
//				else{
//					arr[0][i] = arr[0][i-1];
//					life[0][i] = life[0][i-1]+clone[0][i];
//				}
//				clone[0][i] += clone[0][i-1];
//			}
//		}
//		for( int i=1;i<M;i++)
//			for(int j=0;j<N;j++){
//				if(j==0){
//					if(life[i-1][j]+clone[i][j]<=0){
//						arr[i][j] = 1-(clone[i][j]+clone[i-1][j]);
//						life[i][j] = 1;
//					}
//					else{
//						arr[i][j] = arr[i-1][j];
//						life[i][j] = life[i-1][j]+clone[i][j];
//					}
//					clone[i][j] += clone[i-1][j];
//				}
//				else{
//					int m = life[i-1][j]+clone[i][j];
//					int n = life[i][j-1]+clone[i][j];
//					int p = clone[i-1][j]+clone[i][j];
//					int q = clone[i][j-1]+clone[i][j];
//					int s = 0, t = 0;
//					if(m<=0){
//						s = 1-p;
//						m = 1; 
//					}
//					else
//						s = arr[i-1][j];
//					if(n<=0){
//						t = 1-q;
//						n = 1;
//					}
//					else
//						t = arr[i][j-1];
//					if(s<=t){
//						clone[i][j] = p;
//						arr[i][j] = s;
//						life[i][j] = m;
//					}else{
//						clone[i][j] = q;
//						arr[i][j] = t;
//						life[i][j] = n;
//					}
//				}
//			}
//		for(int i=0;i<M;i++){
//			for(int j=0;j<N;j++)
//				System.out.print(clone[i][j]+",");
//			System.out.println("");
//		}
//		for(int i=0;i<M;i++){
//			for(int j=0;j<N;j++)
//				System.out.print(arr[i][j]+",");
//			System.out.println("");
//		}
//		for(int i=0;i<M;i++){
//			for(int j=0;j<N;j++)
//				System.out.print(life[i][j]+",");
//			System.out.println("");
//		}
//		return arr[M-1][N-1];
		
		int M = dungeon.length;
		int N = dungeon[0].length;
		if(dungeon[M-1][N-1] < 0){
			dungeon[M-1][N-1] = 1-dungeon[M-1][N-1];
		}else
			dungeon[M-1][N-1] = 1;
		if(N>=2){
			for(int i = N-2; i>= 0; i--){
				int m  = dungeon[M-1][i+1] - dungeon[M-1][i];
				if(m>0)
					dungeon[M-1][i] = m;
				else
					dungeon[M-1][i] = 1;
			}
		}
		if(M>=2){
			for(int i = M-2; i >= 0; i--){
				int m = dungeon[i+1][N-1] - dungeon[i][N-1];
				if(m>0)
					dungeon[i][N-1] = m;
				else
					dungeon[i][N-1] = 1;
			}
		}
		if(M>=2&&N>=2){
			for(int i = M-2; i >= 0; i--)
				for(int j = N-2; j >= 0; j--){
					int m = dungeon[i+1][j] - dungeon[i][j];
					if(m<=0)
						m=1;
					int n = dungeon[i][j+1] - dungeon[i][j];
					if(n<=0)
						n=1;
					if(m<=n)
						dungeon[i][j] = m;
					else dungeon[i][j] = n;
				}
		}
		return dungeon[0][0];
	}
	
	public static void main(String[] args){
		DungeonGame game = new DungeonGame();
		int[][] clone ={{1,-3,3},{0,-2,0},{-3,-3,-3}};
		System.out.println(game.calculateMinimumHP(clone));
	}
}
