package sdm.gui;

import sdm.space.Alien;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlienFactory {
    public static ArrayList<Alien> generate(int rows){
        return IntStream.range(0, rows*5)
                .mapToObj(i -> new Alien(15 + i%5 *40, 5 + i/5 *40, 45, 45, "alien.png"))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
