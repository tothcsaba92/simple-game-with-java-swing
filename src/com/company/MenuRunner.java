package com.company;


import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MenuRunner extends JPanel implements ActionListener, KeyListener, LineListener {

    JButton buttonNewGame;
    JButton buttonScore;
    JButton buttonExit;
    JFrame menuJ;
    boolean playCompleted;


    Timer tm = new Timer(5, this);

    Menu menu = new MenuPanel();


    public MenuRunner() {
        tm.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        this.buttonNewGame = new JButton("NEW GAME");
        this.buttonScore = new JButton("SCORE");
        this.buttonExit = new JButton("EXIT");


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        menu.paintComponent(g);
        System.out.println("Menu run");
        tm.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void exit(ActionEvent event) {
        if (event.getActionCommand().equals("EXIT")) {

            menuJ.dispatchEvent(new WindowEvent(menuJ, WindowEvent.WINDOW_CLOSING));
        }
    }

    public void newGame(ActionEvent event) {
        if (event.getActionCommand().equals("NEW GAME")) {
            Game game = new Game();
            game.window();

        }
    }

    public void score(ActionEvent event) {
        if (event.getActionCommand().equals("SCORE")) {


        }
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public void createMenu() {


        menuJ = new JFrame();
        menuJ.setTitle("MENU");
        menuJ.setSize(810, 495);
        menuJ.setVisible(true);
        menuJ.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuRunner panel = new MenuRunner();
        panel.setLayout(null);
        menuJ.add(panel);


        buttonNewGame.setBounds(260, 150, 250, 40);
        buttonNewGame.setFont(new Font("Bauhaus 93", Font.BOLD, 28));
        buttonNewGame.setForeground(Color.BLACK);
        panel.add(buttonNewGame);
        buttonNewGame.addActionListener(this::newGame);

        buttonScore.setBounds(260, 250, 250, 40);
        buttonScore.setFont(new Font("Bauhaus 93", Font.BOLD, 28));
        buttonScore.setForeground(Color.BLACK);
        panel.add(buttonScore);
        buttonScore.addActionListener(this::score);

        buttonExit.setBounds(260, 350, 250, 40);
        buttonExit.setFont(new Font("Bauhaus 93", Font.BOLD, 28));
        buttonExit.setForeground(Color.BLACK);
        panel.add(buttonExit);
        buttonExit.addActionListener(this::exit);

        String audioFilePath = "data/sound/Megalovania.wav";
        SoundPlayer player = new SoundPlayer();
        player.play(audioFilePath);


    }


    @Override
    public void update(LineEvent event) {

    }

}