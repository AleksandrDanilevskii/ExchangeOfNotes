//WaysGroup.java для хранения групп вариантов размена

import java.util.*;

public class WaysGroup {

    private final List<Way> ways;

    public WaysGroup() {
        ways = new ArrayList<>();
    }

    public void add(Way way) {
        ways.add(way);
    }

    public void add(int coin) {
        for (Way way : ways) {
            way.add(coin);
        }
    }

    public void add(WaysGroup group) {
        if (group == null) {
            return;
        }
        for (Way way : group.ways) {
            ways.add(new Way(way));
        }
    }

    public void print() {
        System.out.println("Возможные варианты размена: ");
        for (Way way : ways) {
            way.print();
        }
    }

}