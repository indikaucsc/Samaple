package org.example;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static void main(String[] args) {
        // Asynchronous computation
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            // Simulating a long-running task
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        // Non-blocking callback
        CompletableFuture<Integer> resultFuture = future.thenApply(result -> result * 2);

        // Combining two futures
        CompletableFuture<Integer> combinedFuture = resultFuture.thenCombine(
                CompletableFuture.supplyAsync(() -> 20),
                (result1, result2) -> result1 + result2
        );

        // Handling exceptions
        CompletableFuture<Integer> finalFuture = combinedFuture.exceptionally(ex -> {
            System.out.println("Exception: " + ex.getMessage());
            return 0;
        });

        // Non-blocking result processing
        finalFuture.thenAccept(result -> {
            System.out.println("Final Result: " + result);
        });

        // Blocking call to get the result (for demonstration purposes)
        try {
            System.out.println("Main Thread Result: " + finalFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
