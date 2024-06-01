package org.example;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinSum extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10;
    private final long[] array;
    private final int start;
    private final int end;

    public ForkJoinSum(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            // Small enough to compute directly
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Split the task
            int mid = (start + end) / 2;
            ForkJoinSum leftTask = new ForkJoinSum(array, start, mid);
            ForkJoinSum rightTask = new ForkJoinSum(array, mid, end);

            // Fork the subtasks
            leftTask.fork();
            rightTask.fork();

            // Join the results
            long rightResult = rightTask.join();
            long leftResult = leftTask.join();

            // Combine the results
            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        long[] array = new long[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinSum task = new ForkJoinSum(array, 0, array.length);

        long result = pool.invoke(task);

        System.out.println("Sum: " + result);
    }
}
