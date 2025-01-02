package sdm.gui;

import sdm.space.Alien;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlienFactory {
    public static ArrayList<Alien> generate(int rows){
        return IntStream.range(0, rows*10)
                .mapToObj(i -> new Alien(15 + i%10 *40, 5 + i/10 *40, 30, 30, "alien.png"))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
