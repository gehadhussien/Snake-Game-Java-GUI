package com.company;

public class Snake {

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    SnakeGame main;

    public int direction = 0;
    public int length = 2;

    public int snakeX[] = new int[WIDTH];
    public int snakeY[] = new int[HEIGHT];

    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }

    public void move()
    {
        //when i remove this the snake split
        for (int d = length; d > 0; d--) {
        snakeX[d] = snakeX[d - 1];
        snakeY[d] = snakeY[d - 1];
        }

        if (direction == 0) snakeX[0]++;
        if (direction == 1) snakeY[0]++;
        if (direction == 2) snakeX[0]--;
        if (direction == 3) snakeY[0]--;




        // if the snake hit the wall it start again from the opposite direction

        // start from left
        if (snakeX[0] > main.WIDTH) snakeX[0] = 0;
        //start from right
        if (snakeX[0] < 0) snakeX[0] = main.WIDTH ;
        //start from bottom
        if (snakeY[0] > main.HEIGHT ) snakeY[0] = 0;
        //start from top
        if (snakeY[0] < 0) snakeY[0] = main.HEIGHT ;


    }
}



