package struktury;

public abstract class Element {

    int x = 0;
    int y = 0;
    int error = 0;
    int[][] tab1;

    public Element(int[][] tab1) {
        this.tab1 = tab1;
    }

    public abstract void insert(String text);
}
