import java.util.Scanner;

public class MatrixGame {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        int num = 0;
        for (int i = 0; i < n; i++ ){
            for (int j = 0; j < m; j++){
                matrix[i][j] = num++;
            }
        }
        System.out.println(matrix);
        // int[] temp = matrix[0];
        // matrix[0] = matrix[1];
        // matrix[1]= temp;
        // System.out.println(matrix);
        int row1 = 1, row2 = 2;
        for(int j= 0; j < n; j++){
            int temp = matrix[row1 - 1][j];
            matrix[row1 - 1][j] = matrix[row2 - 1][j];
            matrix[row2 - 1][j] = temp;
        }

        // int col1 = 0;int col2 = 1;
        // for (int i = 0; i < n; i++) {
        //     int temp = matrix[i][col1];
        //     matrix[i][col1] = matrix[i][col2];
        //     matrix[i][col2] = temp; 
        // }
        sc.close();
    }
}
