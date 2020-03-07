public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || word == null || word.length() == 0)
            return false;

        //By default all set to false
        boolean[][] isVisited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, word, i, j, 0, isVisited))
                    return true;
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word, int i, int j, int index, boolean[][] isVisited) {
        int row = board.length;
        int col = board[0].length;

        // return case
        if (word.length() == index) return true;

        // fail case
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != word.charAt(index) || isVisited[i][j])
            return false;

        // do dfs
        isVisited[i][j] = true;
        boolean res = exist(board, word, i + 1, j, index + 1, isVisited)
                || exist(board, word, i - 1, j, index + 1, isVisited)
                || exist(board, word, i, j + 1, index + 1, isVisited)
                || exist(board, word, i, j - 1, index + 1, isVisited);
        isVisited[i][j] = false;

        return res;
    }

    public static void print(char[][] matrix) {
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
        char[][] input = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        print(input);
        System.out.println(exist(input, "ABCCED"));
    }
}
