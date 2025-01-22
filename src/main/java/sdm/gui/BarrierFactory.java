package sdm.gui;

import sdm.space.Barrier;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BarrierFactory {
    public static ArrayList<Barrier> generate(int shields, int windowWidth, int windowHeight) {
        return IntStream.range(1, shields+1)
                .mapToObj(i -> new Barrier(windowWidth / (shields+1) * i, windowHeight-windowHeight/4 - 100, 35, 35, windowWidth, windowHeight, "shield_"))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
