
public class GameOfLife {
	
	final static int D1 = 12;
	final static int D2 = 12;
	
	public static boolean[][] initWorld() {
		boolean[][] world = new boolean[D1][D2];
		// this for-loop is to go into the 1-D in col
		for(int y=0; y<D1;y++)
			// this for-llop is to go into the 2-D in row
			for(int x=0; x<D2;x++)
				// and using Math.random will fill randomly the rows and cols .
				world[x][y] = Math.random() >0.4;
		return world;
				
	}
	
	public static void showWorld(boolean[][] world) {
		// for loop to show the Matrix stating with row and then cols
		for(int y=1; y<D2-1;y++) {
			for(int x = 1; x<D1-1; x++) {
				if(world[x][y])
					System.out.print("X ");
				else
					System.out.print("  ");
			}
				System.out.println();
		}
			System.out.println();
	}
	
	
	public static int numNeighbor(boolean[][] world, int x, int y) {
	    int ret = 0; // tracking of lives cells
	    for (int i = x - 1; i <= x + 1; ++i) {
	        for (int j = y - 1; j <= y + 1; ++j) {
	        	if(!(i < 0 || i >= D1 || j < 0 || j >=D2 )) {
	        		if (world[i][j]) {
	        			ret += 1;
	            }}

	        }
	    }
	    if (world[x][y]) {
	        ret -= 1; // to avoid counting the cell at x, y itself as one of its own neighbors, as it was counted in the loop.
	    }
	    return ret;
	}
	
	//Game Rules:
	/*
	 * 
		1."Every living cell with fewer than two living neighbors dies of loneliness."
		2."Every living cell with more than three living neighbors dies of overpopulation."
		3."Every living cell with two or three neighbors feels comfortable and continues to live."
		4."Every dead cell with exactly three living neighbors is revived."
	 * 
	 */
	public static boolean[][] useRules(boolean[][] world){
		boolean[][] new_world = new boolean[D1][D2];
		
		int neighbor;
		
		for(int y=0;y<D2 -1; y++)
			for(int x=0;x<D1 -1;x++) {
				neighbor = numNeighbor(world,x,y);
				new_world[x][y] = (world[x][y] && (neighbor == 2) || (neighbor ==3));
			}
		return new_world;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] world = initWorld();
		
		System.out.println("Start: ");
		showWorld(world);
		
		
		for(int i=0; i <=10;i++) {
			world = useRules(world);
			
			System.out.println("Gen " + i + " :");
			showWorld(world);
		}

	}

}
