package concurrent.chapter5.barrier;


import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CellularAutomata {
    private final Board mainBoard;
    private final CyclicBarrier barrier;
    private final Worker[] workers;

    public CellularAutomata(Board mainBoard) {
        this.mainBoard = mainBoard;
        int count = Runtime.getRuntime().availableProcessors();
        this.barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                mainBoard.commitNewValues();
            }
        });

        this.workers = new Worker[count];
        for (int i = 0; i < count; i++) {
            workers[i] = new Worker(mainBoard.getSubBoard(count, i));
        }
    }

    public void start() {
        for (int i = 0; i < workers.length; i++) {
            new Thread(workers[i]).start();
        }

        mainBoard.waitForConvergence();
    }

    private class Worker implements Runnable {
        private final Board board;

        public Worker(Board board) {
            this.board = board;
        }

        @Override
        public void run() {
            while (!board.hasConverged()) {
                for (int x = 0; x < board.getMaxX(); x++) {
                    for (int y = 0; y < board.getMaxY(); y++) {
                        board.setNewValue(x, y, compute(x, y));
                    }
                }
            }

            try {
                barrier.await();
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {

            }
        }


        private int compute(int x, int y) {
            Random random = new Random();
            int deltaX = random.nextInt(10);
            int deltaY = random.nextInt(10);
            return (x + deltaX) * (y + deltaY);
        }
    }

}
