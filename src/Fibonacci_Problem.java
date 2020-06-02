import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci_Problem {
    private static HashMap<Integer, Long> fibTable = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(args[0]);
        Scanner s = new Scanner(System.in);
        int n;

        fibonacciTable();

        do {
            System.out.print("Enter no. : ");
            n = s.nextInt();

            System.out.println(fibonacci(n));
            printHashMap(fibTable);
        }while (n != 0);

        printHashMap(fibTable);
    }

    private static long fib(int n){
        if(n == 0 || n == 1)
            return 1;

        return fib(n-1) + fib(n-2);
    }

    private static void fibonacciTable(){
        fibTable.put(0, 1L);
        fibTable.put(1, 1L);
        fibTable.put(2, 2L);
    }

    private static long fibonacci(int n){
        if(n == 0)
            return fibTable.get(0);
        if(n == 1)
            return fibTable.get(1);

        long smallAns1, smallAns2;

        if(fibTable.containsKey(n-1)) smallAns1 = fibTable.get(n-1);
        else {
            smallAns1= fibonacci(n-1);
            fibTable.put(n-1, smallAns1);
        }

        if(fibTable.containsKey(n-2)) smallAns2 = fibTable.get(n-2);
        else {
            smallAns2 = fibonacci(n-2);
            fibTable.put(n-2, smallAns2);
        }

        if(!fibTable.containsKey(n)) fibTable.put(n, smallAns1 + smallAns2);
        return smallAns1 + smallAns2;
    }

    private static <K, V>void printHashMap(HashMap<K, V> table){
        for(Map.Entry<K, V> entry : table.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}