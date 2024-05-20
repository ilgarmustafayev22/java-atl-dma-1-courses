package az.atlacademy.module01.lesson36;

import java.util.Objects;

public class Player implements Comparable<Player> {

    private String name;
    private Integer score;

    public Player(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Player player = (Player) object;
        return Objects.equals(name, player.name) && Objects.equals(score, player.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Player{name='%s', score=%d}".formatted(name, score);
    }

    @Override
    public int compareTo(Player that) {
        if (!this.score.equals(that.score)) {
            return -Integer.compare(this.score, that.score);
        } else {
            return this.name.compareTo(that.name);
        }
    }

}
