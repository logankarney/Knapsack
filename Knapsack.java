public class Knapsack {
	public static int[] weight = {15,25,45,30,23,37}, value = {100,350,225,67,275,168};
	
	
	public static void main(String[] args) {
		
		int[][] table = new int[6][51];
		
		int max_weight = 50;
		
		//sets all table elements to 0
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[i].length; j++) {
				table[i][j] = 0;
			}
		}
		
		//uses a greedy algrorithm to find the max value for each spot in table
		//starts at 1 as table[1][0] will always be 0
		for(int i = 1; i < table.length; i++) {
			
			//starts at 1 as table[0][j] will always be 0
			for(int j = 1; j < table[i].length; j++) {
				
					//if the weight of the previous item is less than the current weight
					if(weight[i-1] <= j){
						table[i][j] = max_value(value[i-1] + table[i-1][j-weight[i-1]], table[i-1][j]);
					}
					
					else
						table[i][j] = table[i-1][j];
			}
		}
		
		//Prints out table
		System.out.print(" | ");
		for(int i = 0; i < table[0].length; i++) {
			
			System.out.printf("%-8d%c", i, '|');
		}
		

		System.out.println();
		
		for(int i = 0; i < table.length; i++) {
			System.out.printf("%d%c ", i, '|');
			for(int j = 0; j < table[i].length; j++) {
				//System.out.print(table[i][j] + "|");
				System.out.printf("%8d%c", table[i][j], '|');
			}
			System.out.println();
		}
		
		System.out.println("\nMax value is " + table[table.length-1][table[table.length-1].length-1]);
	}
	
	//Returns the greater of two integers
	static int max_value(int a, int b){
		if(a >= b)
			return a;
		else
			return b;	
	}
}
