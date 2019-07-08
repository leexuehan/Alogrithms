package concurrent.chapter5.barrier;

public class Board {
    private final int MAX_X = 10;
    private final int MAX_Y = 10;

    private final int times = 20;

    public boolean hasConverged() {
        return false;
    }

    public int getMaxX() {
        return MAX_X;
    }

    public int getMaxY() {
        return MAX_Y;
    }

    public void setNewValue(int x, int y, int computeResult) {

    }

    public void commitNewValues() {

    }

    public Board getSubBoard(int count, int i) {
        return null;
    }

    public void waitForConvergence() {

    }
}
