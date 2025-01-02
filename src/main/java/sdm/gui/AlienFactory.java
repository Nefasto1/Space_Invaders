package sdm.gui;

import sdm.space.Alien;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlienFactory {
    public static ArrayList<Alien> generate(int rows){
//        ArrayList<Alien> aliens = new ArrayList<>();
//        for (int i = 0; i < rows; i++) {
//            aliens.add(new Alien(15 + i%5 * 40, 5 + i/5 * 40, "alien.png", 32, 32));
//            aliens.add(new Alien(15 + i%5 * 40, 5 + i/5 * 40));
//        }

        return IntStream.range(0, rows*5)
                .mapToObj(i -> new Alien(15 + i%5 *40, 5 + i/5 *40))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
