package DynamicProgrammingPractice;

import java.util.Scanner;

/**
 *
 * @author Rajiur
 */
public class GridChallenge {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String Tstr = in.nextLine();
        int T = Integer.parseInt(Tstr);
        if(T>=1 && T<=100){ // number of test cases cannot be greater than 100
            for(int numTestCases=0; numTestCases<T; numTestCases++){
                String Nstr = in.nextLine();
                int N = Integer.parseInt(Nstr);
                if(N>=1 && N<=100){ // Number of words cannot be greater than 100
                    char[][] matrix = new char[N][N];
                    readData(in, matrix, N);

    //                sortData(matrix);
                    insertionSort(matrix);
    //                dumpMatrix(matrix);

                    String res = takeGridChallenge(matrix);
                    System.out.println(res);
                }
            }
        }
    }
    
    private static String takeGridChallenge(char[][] matrix) {
        String res = "YES";
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length-1; j++){
                String s1 = Character.toString(matrix[j][i]);
                String s2 = Character.toString(matrix[j+1][i]);
                if(s1.compareTo(s2) > 0){
                    res = "NO";
                    break;
                }
            }
        }
        return res;
    }
    
    private static void insertionSort(char[][] A){
        for(int x=0; x<A.length; x++){
            for(int i = 1; i < A.length; i++){
                char value = A[x][i];
                int j = i - 1;
                while(j >= 0 && Character.toString(A[x][j]).compareTo(Character.toString(value))>0 ){
                    A[x][j + 1] = A[x][j];
                    j = j - 1;
                }
                A[x][j + 1] = value;
            }
        }
    }
    
    private static void sortData(char[][] matrix) {
        for(int i=0; i<matrix.length-1; i++){
            for(int j=i; j<matrix[0].length-1; j++){
                if( Character.toString(matrix[i][j]).compareTo(Character.toString(matrix[i][j+1])) > 0 ){ //if true, exchange
                    char c1 = matrix[i][j];
                    matrix[i][j] = matrix[i][j+1];
                    matrix[i][j+1] = c1;
                }
            }
        }
    }

    private static void readData(Scanner in, char[][]matrix, int N) {
        for(int i=0; i<N; i++){
            String s1 = in.nextLine().trim().toLowerCase();
            //lets assume all the input strings are of size N
            if(s1 != null){
                for(int j=0; j<N; j++){
//                    System.out.println(s1.charAt(j));
                    matrix[i][j] = s1.charAt(j);
                }
            }
            
        }
    }

    private static void dumpMatrix(char[][] matrix) {
        System.out.println("");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }System.out.println("");
        }
    }

}
