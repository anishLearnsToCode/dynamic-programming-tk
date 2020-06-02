import java.util.ArrayList;
import java.util.Scanner;

public class SubsetSumProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int totalSum, size;

        System.out.print("Enter total sum : ");
        totalSum = s.nextInt();
        System.out.print("Enter size of set : ");
        size = s.nextInt();

        int arr[] = new int[size];
        for(int i=0 ; i<size ; i++){
            arr[i] = s.nextInt();
        }

        boolean table[][] = DPTable(arr, totalSum);
        //print(table);

        ArrayList<Integer> ans = backtracking(table, arr);
        for(int i=0 ; i<ans.size() ; i++){
            System.out.print(ans.get(i) + " ");
        }
    }

    public static boolean[][] DPTable(int set[], int sum){
        boolean table[][] = new boolean[set.length][sum+1];
        int i, j;

        //first column
        for(i=0 ; i<table.length ; table[i][0] = true, i++);

        //first row
        for(i=1 ; i<table[0].length ; i++){
            table[0][i] = set[0] == i;
        }

        //Rest of the table
        for(i=1 ; i<table.length ; i++){
            for(j=1 ; j<table[0].length ; j++){
               table[i][j] = table[i-1][j] || (j - set[i] >= 0 ? table[i-1][j-set[i]] : false) || j == set[i] ;
            }
        }

        return table;
    }

    public static ArrayList<Integer> backtracking(boolean table[][], int set[]){
        ArrayList<Integer> ans = new ArrayList<>();
        int row = table.length-1, column = table[0].length-1;

        for( ; column != 0 ; ){

            if(column - set[row] < 0){
                row--;
                continue;
            }

            if(table[row-1][column-set[row]]){
                ans.add(set[row]);
                row--;
                column = column - set[row+1];
            }else row--;
        }
        return ans;
    }

    public static void print(boolean arr[][]){
        for(int i=0 ; i<arr.length ; System.out.println(""), i++)
            for(int j=0 ; j<arr[i].length ; System.out.print(arr[i][j] + " "), j++);
    }
}
