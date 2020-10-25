import java.util.concurrent.RecursiveTask;

public class ArraySumCalculator extends RecursiveTask<Integer> {
    private final int[] array;
    private int start;
    private int end;

    public ArraySumCalculator(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    private int forkTaskAndGetResult() {
        final int middle = (end - start) / 2;
        ArraySumCalculator task1 = new ArraySumCalculator(start, middle, array);
        ArraySumCalculator task2 = new ArraySumCalculator(middle, end, array);
        //invokeAll(task1, task2);
        task1.fork();
        task2.fork();
        return task1.join() + task2.join();
    }

    @Override
    protected Integer compute() {
        final int diff = end - start;
        switch (diff) {
            case 0: return 0;
            case 1: return array[start];
            case 2: return array[start] + array[start + 1];
            default: return forkTaskAndGetResult();
        }
    }
}
