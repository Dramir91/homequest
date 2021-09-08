package Dramir.Game.Field;

import Dramir.Game.Character;
import Dramir.Game.GameState;

import java.awt.*;

public class Wall implements Field{
    @Override
    public char getSymbol() {
        return '#';
    }

    @Override
    public boolean isPassable() {
        return false;
    }

    @Override
    public Color getColor() {
        return Color.darkGray;
    }

    @Override
    public void interact(Character player) {

        GameState.LogWindow.write("you hit a wall"); // dodajemy cos do loga
        // odswiezyc pole gry // zarequestowac pole gry
    }
}
