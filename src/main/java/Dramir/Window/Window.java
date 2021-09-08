package Dramir.Window;

import asciiPanel.AsciiPanel;

public class Window {
    protected int x, y, width, height;
    static int borderOffset = 1;

    public Window(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void drawBorder(AsciiPanel terminal) {
        // pionowe bordery
        for (int i = 0; i < height; i++) {
            terminal.write((char) 186, x, i + y);
            terminal.write((char) 186, x + width - 1, i + y);
        }
        // poziome bordery
        for (int i = 0; i < width; i++) {
            terminal.write((char) 205, i + x, y);
            terminal.write((char) 205, x + i, height - 1 + y);
        }

        terminal.write((char) 201, x, y); // lewy górny róg
        terminal.write((char) 188, x + width - 1, height - 1 + y); // prawy dolny róg
        terminal.write((char) 200, x, height - 1 + y); // lewy dolny
        terminal.write((char) 187, x + width - 1, y); // prawy górny
    }

    public int deltaX(int x) {
        return this.x+x+borderOffset;
    }
    public int deltaY(int y) {
        return this.y+y+borderOffset;
    }
}
