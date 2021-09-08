package Dramir.App;

import javax.swing.JFrame;

import Dramir.Screen.GameView;
import Dramir.Screen.Screen;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ApplicationMain extends JFrame {

    private AsciiPanel terminal;
    private Screen screen;
    public static int width = 80;
    public static int height = 40;

    public ApplicationMain(){
        super();
        terminal = new AsciiPanel(width, height);
        add(terminal);
        pack();

        screen = new GameView();
       // screen = new MenuScreen();
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                screen = screen.respondToUserInput(e);
                screen.displayOutput(terminal);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        screen.displayOutput(terminal);
    }


    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }


}