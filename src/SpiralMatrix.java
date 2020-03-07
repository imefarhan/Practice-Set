import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix.length == 0 || matrix[0].length == 0)
            return res;

        int R = matrix.length;
        int C = matrix[0].length;

        int startRow = 0, startCol = 0, endRow = R - 1, endCol = C - 1;

        while (startRow <= endRow && startCol <= endCol) {
            //TOPMOST ROW: Left to Right
            for (int j = startCol; j <= endCol; j++) {
                res.add(matrix[startRow][j]);
            }
            //RIGHTMOST COLUMN: TOP to Bottom
            for (int i = startRow + 1; i <= endRow; i++) {
                res.add(matrix[i][endCol]);
            }
            if (startRow < endRow && startCol < endCol) {
                //BOTTOM-MOST ROW: Right to Left
                for (int j = endCol - 1; j > startCol; j--) {
                    res.add(matrix[endRow][j]);
                }
                //LEFT-MOST COLUMN: Bottom to TOP
                for (int i = endRow; i > startRow; i--) {
                    res.add(matrix[i][startCol]);
                }
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }

        return res;
    }

    public static void main(String[] args) {
        //[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//        int[][] input = {
//                {1, 2, 3, 4},
//                {14, 15, 16, 5},
//                {13, 20, 17, 6},
//                {12, 19, 18, 7},
//                {11, 10, 9, 8}};
        int[][] input = {
                {3},
                {2}};
//        int[][] input = {
//                {1, 2, 3, 4, 5},
//                {16, 17, 18, 19, 6},
//                {15, 24, 25, 20, 7},
//                {14, 23, 22, 21, 8},
//                {13, 12, 11, 10, 9}};
        System.out.println(spiralOrder(input));
    }
}
