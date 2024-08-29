public class RulesOfLife {

    public static int countLiveNeighbors(boolean[][] grid, int x, int y) {
        int neighbors = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int newX = x + i;
                int newY = y + j;

                if (newX >= 0 && newX < Main.ROWS && newY >= 0 && newY < Main.COLS) {
                    if (grid[newX][newY]) {
                        neighbors++;
                    }
                }
            }
        }
        return neighbors;
    }

    public static void changeState() {
        boolean[][] newGrid = new boolean[Main.ROWS][Main.COLS];

        for (int i = 0; i < Main.grid.length; i++) {
            for (int j = 0; j < Main.grid[0].length; j++) {
                int neighbors = countLiveNeighbors(Main.grid, i, j);

                // REPRODUCTION
                if (!Main.grid[i][j] && neighbors == 3) {
                    newGrid[i][j] = true;
                }
                // UNDERPOPULATION
                else if (Main.grid[i][j] && neighbors < 2) {
                    newGrid[i][j] = false;
                }
                // OVERPOPULATION
                else  if (Main.grid[i][j] && neighbors > 3) {
                    newGrid[i][j] = false;
                }
                else {
                    newGrid[i][j] = Main.grid[i][j];
                }
            }
        }
        for (int i = 0; i < Main.grid.length; i++) {
            for (int j = 0; j < Main.grid[0].length; j++) {
                Main.grid[i][j] = newGrid[i][j];
            }
        }
    }
}
