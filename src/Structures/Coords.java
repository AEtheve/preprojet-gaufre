package Structures;

public class Coords {
    public int x, y;

    @Override
    public boolean equals(Object o) {
        Coords c = (Coords)o;
        return (c.x==x && c.y==y);
    }

    public Coords() {
        this(0, 0);
    }

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }
}