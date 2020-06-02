import java.util.Scanner;

public class KnapsackProblem_01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int entries, maxWeight;

        System.out.print("No. of entries : ");
        entries = s.nextInt();
        System.out.print("Enter maxWeight : ");
        maxWeight = s.nextInt();

        int weight[] = new int[entries];
        int value[] = new int[entries];

        System.out.println("Enter values : ");
        arrInput(value);
        System.out.println("Enter weights : ");
        arrInput(weight);

        int DPTable[][] = DPTableKnapsack01(weight, value, maxWeight);
        print(DPTable);

        System.out.println(backTracking(DPTable, weight));
    }

    public static void print(int arr[][]){
        System.out.println("");
        for(int i=0 ; i<arr.length ; System.out.println(""), i++){
            for(int j=0 ; j<arr[i].length ; System.out.print(arr[i][j] + " "), j++);
        }
    }

    public static void arrInput(int arr[]){
        Scanner s = new Scanner(System.in);
        for(int i=0 ; i<arr.length ; arr[i] = s.nextInt(), i++);
    }

    public static int[][] DPTableKnapsack01 (int weight[], int value[], int maxWeight) {
        int table[][] = new int[weight.length][maxWeight + 1];
        int i, j, k;

        //first column is zero
        for(i=0 ; i<table.length ; table[i][0] = 0, i++);

        //for First row
        for(i=0 ; i<table[0].length ; i++){
            if(i >= weight[0])
                table[0][i] = 1;
            else
                table[0][i] = 0;
        }

        //For next Rows
        for(i=1 ; i<table.length ; i++){
            for(j=1 ; j<table[0].length ; j++){
                table[i][j] = j >= weight[i] ? Math.max(value[i] + table[i-1][j-weight[i]], table[i-1][j]) : table[i-1][j];
            }
        }

        return table;
    }

    public static int backTracking(int table[][], int weight[]){
        int i, j, usedWeight;
        for(i=table.length-1, j=table[0].length-1, usedWeight=0 ; i>=0 ; i--){
            if(i == 0){
                //usedWeight += weight[i];
                break;
            }
            if(table[i-1][j] != table[i][j]){
                usedWeight += weight[i];
                j -= weight[i];
            }
        }
        return usedWeight;
    }
}
