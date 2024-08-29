import processing.core.PApplet;

public class Main extends PApplet {
    static int WIDTH = 300;
    static int BREADTH = 300;
    static int ROWS = WIDTH / 5;
    static int COLS = BREADTH / 5;

    static boolean[][] grid = new boolean[ROWS][COLS];

    public void draw() {
        background(0);
        RulesOfLife.changeState();

        for (int i = 0; i < grid.length; i++) {
            int x = 0;
            int y = i * 5;

            for (int j = 0; j < grid[0].length; j++) {
                // render ALIVE Cells
                if (grid[i][j]) {
                    fill(152, 255, 152);
                    square(x, y, 5);
                }
                // render DEAD Cells
                else {
                    fill(0);
                    square(x, y, 5);
                }
                // change ROW-coordinate
                x = x + 5;
            }
        }
    }

    public void initializeGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                float probLife = 0.5f;
                grid[i][j] = random(0, 1) < probLife;
            }
        }
    }

    public void setup() {
        initializeGrid();
        background(0);
    }

    public void settings() {
        size(WIDTH, BREADTH);
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
