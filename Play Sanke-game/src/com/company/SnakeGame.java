package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class SnakeGame extends JPanel implements ActionListener{
   public static final int SCALE = 35;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static  final int SPEED = 4;

    //Timer  running a block of code after some regular instant of time
    Timer t = new Timer(1000 / SPEED, this);

    public SnakeGame() {
        //snake move automatic to right because direction is 0
        t.start();
        addKeyListener(new Keyboard());
        //keyboard events sent to the focus.
        setFocusable(true);
    }
    //object from apple and snake.
    Apple a = new Apple((int) (Math.random() * WIDTH), (int) (Math.random() * HEIGHT));
    Snake s = new Snake(10, 10, 9, 10);

    public void paint(Graphics g) {
        //background
        g.setColor(Color.BLACK);
        g.fillRect(0 , 0, WIDTH*SCALE , HEIGHT*SCALE );

        //lines x and y.
        g.setColor(Color.ORANGE);
        for (int x = 0; x <= WIDTH* SCALE ; x += SCALE) {
            g.drawLine(x, 0, x, HEIGHT * SCALE);
        }
        for (int y = 0; y <= HEIGHT * SCALE; y += SCALE) {
            g.drawLine(0, y, WIDTH * SCALE,y);
        }

        //draw snake
        for (int i = 0; i < s.length; i++) {
            g.setColor(Color.BLUE);
            g.fillRect(s.snakeX[i] * SCALE , s.snakeY[i] * SCALE , SCALE , SCALE );
        }
        //draw apple
        g.setColor(Color.red);
        g.fillRect(a.posX * SCALE , a.posY * SCALE , SCALE , SCALE );


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        s.move();

        //check if the snake eat the apple, make the apple appear in another position.
        if ((s.snakeX[0] == a.posX) & (s.snakeY[0] == a.posY)) {
            a.setRandomPosition();
            s.length++;

        }



        repaint();
    }
    private class Keyboard extends KeyAdapter {
        public void keyPressed(KeyEvent kEve) {
            int key = kEve.getKeyCode();

            if ((key == KeyEvent.VK_RIGHT) & s.direction != 2) s.direction = 0;
            if ((key == KeyEvent.VK_DOWN) & s.direction != 3) s.direction = 1;
            if ((key == KeyEvent.VK_LEFT) & s.direction != 0) s.direction = 2;
            if ((key == KeyEvent.VK_UP) & s.direction != 1) s.direction = 3;
        }
    }
}



