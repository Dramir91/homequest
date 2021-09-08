package Dramir.Screen.Launch;

import Dramir.Game.GameState;
import Dramir.Screen.Screen;
import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CharacterSummaryScreen implements Screen {

    @Override
    public void displayOutput(AsciiPanel terminal) {
        terminal.clear();
        terminal.write("HOMEQUEST", 35, 1, new Color(135, 213, 17));
        terminal.write("Name: " + GameState.Player.Name, 4, 5);
        terminal.write("Gender: " + GameState.Gender, 4, 7);
        terminal.write("Profession: " + GameState.Profession, 4, 9);
        terminal.write("Race: " + GameState.Race, 4, 11);
        terminal.write("Your base statistics: " + GameState.Player, 4, 13);
        terminal.repaint();
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return null;
    }
}
