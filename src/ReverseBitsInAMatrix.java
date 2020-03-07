/*
        Approach: The idea is we'll use the first row and column for marking rows and columns to be zerofied.
                  We'll iterate through each cell, and if the cell is 0, we will make the first cell of the same row and the first
                  cell of the same row 0. This is how we will be marking. Leter, we will only check the first row and column, and if we find any
                  marked ( 0 ) cell, we'll make all the cells in the same row or column 0.
                  But there is one small problem with this approach. If a cell in first row is 0, we'll make the whole first row 0. This will
                  override our markings in the first row. So then if we check the first row for columns to zero-fy, we'll get 0 in all the cells.
                  So we will use two seperate boolean variables (shouldZeroFirstRow and shouldZeroFirstColumn) to mark first row or column to be
                  zerofied. Then when we are zerofying cells based on marks, we won't touch the first row and column. After we zerofy other rows
                  or columns, we'll check those boolean variables and zerofy first row or column.

        Complexity analysis: Time: O(m*n); Space: O(1)

*/

public class ReverseBitsInAMatrix {

    public static void setZeroesPerfectSolution(int[][] matrix) {
        Boolean ifFirstColIsRequiredToBeSet = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {
            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                ifFirstColIsRequiredToBeSet = true;
            }
            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (ifFirstColIsRequiredToBeSet) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }

        for (int[] ints : matrix) {
            for (int j = 0; j < C; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {

        Boolean isSet = matrix[0][0]==0 ? true:false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m;i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]==0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //Check if First Row is required to be Set
        if (isSet) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        for(int i=0; i<m;i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        //int[][] input = {{1,1,1},{1,0,1},{1,1,1}};
//        int[][] input = {{0,1,2,0},
//                         {3,4,5,2},
//                         {1,3,1,5}};
        int[][] input = {{1,1,1},
                         {0,1,2}};
        setZeroes(input);
    }
}
