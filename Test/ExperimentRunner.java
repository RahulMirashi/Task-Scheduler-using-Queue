import comp47500.advds.*;
public class ExperimentRunner {

    /**
     * Runs enqueue experiment
     */
    public static void runEnqueueExperiment(int taskCount) {
        MyQueue<Task> queue = new MyQueue<>();

        long start = System.nanoTime();

        for (int i = 0; i < taskCount; i++) {
            queue.enqueue(new Task("Task " + i, 10));
        }

        long end = System.nanoTime();
        System.out.println("Enqueue " + taskCount + " tasks: " + (end - start) / 1_000_000 + " ms");
    }

    /**
     * Runs dequeue experiment
     */
    public static void runDequeueExperiment(int taskCount) {
        MyQueue<Task> queue = new MyQueue<>();

        for (int i = 0; i < taskCount; i++) {
            queue.enqueue(new Task("Task " + i, 10));
        }

        long start = System.nanoTime();

        while (!queue.isEmpty()) {
            queue.dequeue();
        }

        long end = System.nanoTime();
        System.out.println("Dequeue " + taskCount + " tasks: " + (end - start) / 1_000_000 + " ms");
    }

    /**
     * Runs mixed workload experiment
     * Enqueue 70%, Dequeue 30% repeatedly
     */
    public static void runMixedExperiment(int taskCount) {
        MyQueue<Task> queue = new MyQueue<>();
        int enqueueCount = (int) (taskCount * 0.7);
        int dequeueCount = (int) (taskCount * 0.3);

        long start = System.nanoTime();

        // First batch enqueue
        for (int i = 0; i < enqueueCount; i++) {
            queue.enqueue(new Task("Task " + i, 10));
        }

        // Dequeue some
        for (int i = 0; i < dequeueCount; i++) {
            if (!queue.isEmpty()) queue.dequeue();
        }

        // Repeat until total tasks processed
        int remaining = taskCount - enqueueCount;
        for (int i = enqueueCount; i < taskCount; i++) {
            queue.enqueue(new Task("Task " + i, 10));
            if (i % 3 == 0 && !queue.isEmpty()) queue.dequeue(); // simulate 30% dequeue
        }

        // Clear remaining
        while (!queue.isEmpty()) {
            queue.dequeue();
        }

        long end = System.nanoTime();
        System.out.println("Mixed workload " + taskCount + " tasks: " + (end - start) / 1_000_000 + " ms");
    }

    /**
     * Main method to run all experiments
     */
    public static void main(String[] args) {
        int[] taskSizes = {10_000, 50_000, 100_000, 500_000};

        System.out.println("=== Enqueue Experiments ===");
        for (int n : taskSizes) runEnqueueExperiment(n);

        System.out.println("\n=== Dequeue Experiments ===");
        for (int n : taskSizes) runDequeueExperiment(n);

        System.out.println("\n=== Mixed Workload Experiments ===");
        for (int n : taskSizes) runMixedExperiment(n);
    }
}