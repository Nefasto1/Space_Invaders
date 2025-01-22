package sdm.gui;

import sdm.space.Alien;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlienFactory {
    public static ArrayList<Alien> generate(int rows, int windowWidth, int windowHeight) {
        int alienPerRow = windowWidth/50;
        return IntStream.range(0, rows*alienPerRow)
                .mapToObj(i -> new Alien(15 + i%alienPerRow *40, 5 + i/alienPerRow *40, 30, 30, windowWidth, windowHeight,"alien.png"))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
