package Dramir.Game.Field;

import Dramir.Game.Character;

import java.awt.*;

public class Ground implements Field {
    @Override
    public char getSymbol() {
        return '.';
    }

    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public void interact(Character player) {

    }
}
