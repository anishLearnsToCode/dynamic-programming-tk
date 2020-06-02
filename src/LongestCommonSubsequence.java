import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1, str2;


        str1 = s.next();
        str2 = s.next();
        System.out.println(str1 + " " + str2);

        int table[][] = DPTable(str1, str2);
        print(table);

        String ans = backtracking(table, str2);
        System.out.println(ans);
    }

    public static int[][] DPTable(String str1, String str2) {
        int[][] table = new int[str2.length() + 1][str1.length() + 1];
        int i, j;

        //for first row
        for(i=0 ; i<table[0].length ; table[0][i] = 0, i++);
        //for first column
        for(i=0 ; i<table.length ; table[i][0] = 0, i++);

        //for table
        for(i=1 ; i<table.length ; i++){
            for(j=1 ; j<table[0].length ; j++){
                table[i][j] = (str1.charAt(j-1) == str2.charAt(i-1) ?
                        table[i-1][j-1] + 1 : Math.max(table[i-1][j], table[i][j-1]) );
            }
        }

        return table;
    }

    public static String backtracking(int table[][], String str){
        String ans = "";
        int row, column;

        for(row = table.length -1, column = table[0].length-1 ; table[row][column] != 0 ; ){
            if(table[row-1][column] == table[row][column])
                row = row-1;
            else if(table[row][column-1] == table[row][column])
                column--;
            else {
                row--; column--;
                ans = str.charAt(row) + ans;
            }
        }
        return ans;
    }

    public static void print(int arr[][]){
        for(int i=0 ; i<arr.length ; System.out.println(""), i++){
            for(int j=0 ; j<arr[0].length ; System.out.print(arr[i][j] + " "), j++);
        }
    }
}
