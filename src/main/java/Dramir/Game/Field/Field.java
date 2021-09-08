package Dramir.Game.Field;

import Dramir.Game.Character;

import java.awt.*;

public interface Field {
    char getSymbol();
    boolean isPassable();
    Color getColor();

    void interact(Character player);

}
