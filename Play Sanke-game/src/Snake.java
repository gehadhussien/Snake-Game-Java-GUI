import com.company.SnakeGame;

public class Snake {
    SnakeGame main;

    public int direction = 0;
    public int length = 2;

    public int snakeX[] = new int[main.WIDTH * main.HEIGHT];
    public int snakeY[] = new int[main.WIDTH * main.HEIGHT];

    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }
}
