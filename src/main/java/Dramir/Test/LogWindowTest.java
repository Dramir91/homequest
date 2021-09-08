package Dramir.Test;

import Dramir.Window.LogWindow;

public class LogWindowTest {
    public static void main(String[] args) {
        var sut = new LogWindow(0,0, 10, 10);
        String test = "jo cie krynca fest bratku co sie dzieje kurwa dupa sjdjd sksk";
        var result = sut.partitionText(test);
        System.out.print(result);
    }
}
