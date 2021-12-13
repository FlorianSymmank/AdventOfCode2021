package de.floriansymmank.puzzles;

public class Node {
    private final String name;
    private final boolean isSmall;

    public Node(String name) {
        this.name = name;
        this.isSmall = name.equals(name.toLowerCase());
    }

    public String getName() {
        return name;
    }

    public boolean isSmall() {
        return isSmall;
    }

    @Override
    public String toString() {
        return name;
    }
}
