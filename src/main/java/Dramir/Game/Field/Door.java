package Dramir.Game.Field;

import Dramir.Game.Character;

import java.awt.*;

public class Door implements Field {
    boolean open;

    public Door(boolean open) {
        this.open = open;
    }

    @Override
    public char getSymbol() {
        return open ? '/' : '+';
    }

    @Override
    public boolean isPassable() {
        return open;
    }

    @Override
    public Color getColor() {
        return new Color(128, 79, 8);
    }

    @Override
    public void interact(Character player) {
        if (!open) {
            open = true;
        }
    }
}
