package az.atlacademy.module01.lesson36;

import java.util.Comparator;

public class PlayerNameDescComparator implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        return p2.getName().compareTo(p1.getName());
    }

}
