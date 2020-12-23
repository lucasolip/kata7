package view;

public interface BlockDisplay {
    public static final int SIZE = 50;

    void paintBlock(int x, int y);
    void on(Moved moved);
    
    interface Moved {
        void to(int x, int y);
    }
}
