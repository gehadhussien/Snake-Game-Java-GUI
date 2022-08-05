package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

	// write your code here
        final int SCALE = 32;
        final int WIDTH = 20;
        final int HEIGHT = 20;
        SnakeGame sg= new SnakeGame();


        JFrame f = new JFrame();
        f.setTitle("Snake Game");
        f.setSize(WIDTH*SCALE, HEIGHT*SCALE) ;
        f.add(sg);
        f.setVisible(true);

    }
    }

