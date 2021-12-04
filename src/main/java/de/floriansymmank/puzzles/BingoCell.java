package de.floriansymmank.puzzles;

class BingoCell {
    private final int number;
    private boolean marked;

    public BingoCell(int number) {
        this.number = number;
    }

    public void mark() {
        marked = true;
    }

    public boolean isMarked() {
        return marked;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        // pad number 2 digits
        return String.format("%02d", number) + " " + (marked ? "X" : "_");
    }
}
