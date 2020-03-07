public class RotateImage {

    public static void rotate(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        if (C > 0 && R == C) {
            //Start
            int j = 0;
            for(int i = 0; i < Math.ceil(R >> 1); i++) {
                for(; j < R - 1 - i; j++) {
                    int leftTopCorner = matrix[i][j];
                    int bottomRightCorner = matrix[R - 1 - i][R - 1 -j];

                    matrix[i][j] = matrix[R - 1 - j][i];
                    matrix[R - 1 - i][R - 1 -j] = matrix[j][R - 1 - i];
                    matrix[R - 1 - j][i] = bottomRightCorner;
                    matrix[j][R - 1 - i] = leftTopCorner;
                }
                j = i + 1;
            }
        }
    }

    public static void print(int[][] matrix) {
        System.out.println();
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] input = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}};
        print(input);
        rotate(input);
        print(input);
    }
}
