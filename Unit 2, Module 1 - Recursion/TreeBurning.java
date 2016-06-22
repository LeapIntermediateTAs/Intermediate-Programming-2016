import static java.lang.System.out;
import java.util.Random;
import java.util.Scanner;

public class TreeBurning {
	public static Random generator = new Random();
	public static int width = generator.nextInt(20) + 1;
	public static int height = generator.nextInt(10) + 1;
	
	public static String[][] forest = new String[width][height];
	private static Scanner scanY;
	private static Scanner scanX;
	
	public static void printForest() {
		for(int k=0; k<width; k++) {
			out.println();
			
			for(int l=0; l<height; l++) {
				out.print(forest[k][l] + " ");
			}
		}
	}
	
	public static int indexForest(String type) {
		int trees = 0;
		
		for(int m=0; m<width; m++) {
			for(int n=0; n<height; n++) {
				if(forest[m][n] == type) {
					trees++;
				}
			}
		}
		
		return trees;
	}
	
	public static void burnTrees(int x, int y) {
		
		forest[x][y] = "*";
		out.println();
		printForest();
		
		if(x != (width-1)) {
			if(forest[x+1][y] == "I") {
				burnTrees(x+1,y);
			}
		}
		if(y != (height-1)) {
			if(forest[x][y+1] == "I") {
				burnTrees(x,y+1);
			}
		}
		if(x != 0) {
			if(forest[x-1][y] == "I") {
				burnTrees(x-1,y);
			}
		}
		if(y != 0) {
			if(forest[x][y-1] == "I") {
				burnTrees(x,y-1);
			}
		}
		if(x != (width-1)) {
			if(y != 0) {
				if(forest[x+1][y-1] == "I") {
					burnTrees(x+1,y-1);
				}
			}
		}
		if(x != (width-1)) {
			if(y != (height-1)) {
				if(forest[x+1][y+1] == "I") {
					burnTrees(x+1,y+1);
				}
			}
		}
		if(x != 0) {
			if(y != (height-1)) {
				if(forest[x-1][y+1] == "I") {
					burnTrees(x-1,y+1);
				}
			}
		}
		if(x != 0) {
			if(y != 0) {
				if(forest[x-1][y-1] == "I") {
					burnTrees(x,y-1);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				if(generator.nextBoolean()) {
					forest[i][j] = "I";
				} else {
					forest[i][j] = " ";
				}
			}
		}
		
		printForest();
		out.println();
		out.println();
		
		int trees = indexForest("I");
		out.println("The forest contains " + trees + " trees.");
		
		out.println();
		out.println("What tree do you want to burn?");
		
		out.print("x = ");
		scanX = new Scanner(System.in);
		int x = scanX.nextInt();
		
		out.print("y = ");
		scanY = new Scanner(System.in);
		int y = scanY.nextInt();
		
		if(forest[x][y] == "I") {
			burnTrees(x,y);
		} else {
			out.println("Not a tree.");
			System.exit(0);
		}
		
		int burnt = indexForest("*");
		
		double doubleTrees = trees;
		double doubleBurnt = burnt;
		double percent = (doubleBurnt/doubleTrees) * 100;
		
		out.println();
		out.println();
		out.println("Done. " + burnt + " trees, were burned, destroying " + percent + "% of the forest.");
	}
}