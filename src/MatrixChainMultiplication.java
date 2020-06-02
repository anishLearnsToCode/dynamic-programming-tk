import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size;

        System.out.print("Enter size : ");
        size = s.nextInt();

        int m[] = new int[size];
        int n[] = new int[size];

        for(int i=0 ; i<size ; i++){
            System.out.print("Matrix " + i +" : ");
            m[i] = s.nextInt();
            n[i] = s.nextInt();
        }

        int table[][] = DPTable(m, n);
        print(table);
    }

    public static int[][] DPTable(int m[], int n[]){
        int table[][] = new int[m.length][n.length];
        int i, j, k;

        //diagonal elements
        for(i=0 ; i<table.length ; table[i][i] = 0, i++);

        //Other elements
        for(i=0 ; i<table.length -1 ; i++){
            for(j=0 ; j<table.length-i-1 ; j++){
                table[j][i+1+j] = Math.min(table[j][i+j] + m[j]*m[i+j+1]*n[i+j+1], table[j+1][i+j+1] + m[j]*n[j]*n[i+j+1]);
            }
        }

        return table;
    }

    public static void print(int arr[][]){
        for(int i=0 ; i<arr.length ; System.out.println(""), i++)
            for(int j=0 ; j<arr[i].length ; System.out.print(arr[i][j] + " "), j++);
    }
}
