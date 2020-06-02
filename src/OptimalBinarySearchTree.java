import java.util.Scanner;
public class OptimalBinarySearchTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size;

        System.out.print("Enter size : ");
        size = s.nextInt();

        int data[] = new int[size];
        int frequency[] = new int[size];

        for(int i=0 ; i<size ; i++){
            System.out.print("Enter data and frequency (" + i + ") : ");
            data[i] = s.nextInt();
            frequency[i] = s.nextInt();
        }

        int table[][] = DPTable(data, frequency);
        MatrixChainMultiplication.print(table);
    }

    public static int[][] DPTable(int data[], int frequency[]){
        int table[][] = new int[data.length][frequency.length];
        int nodeData[][] = new int[data.length][data.length];
        int i, j, row, column, sum;

        //Diagonal of table
        for(i=0 ; i<table.length ; table[i][i] = frequency[i], i++);
        //for diagonal of nodeData
        for(i=0 ; i<nodeData.length ; nodeData[i][i] = i, i++);

        //For remaining table
        for(i=0 ; i<table.length-1 ; i++){
            for(j=0 ; j<table.length -i -1 ; j++){
                sum = nodeSum(j, i+j+1, frequency);
            }
        }
    }

    public static int nodeSum(int startIndex, int endIndex, int frequency[]){

    }
}
