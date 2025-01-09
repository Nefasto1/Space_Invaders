package sdm.gui;

import sdm.space.Barrier;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BarrierFactory {
    public static ArrayList<Barrier> generate(int shields){
        return IntStream.range(1, shields+1)
                .mapToObj(i -> new Barrier(500 / (shields+1) * i, 300, 30, 30, "shield_"))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
