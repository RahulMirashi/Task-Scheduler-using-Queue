package comp47500.advds;


public class QueueExperiment {

    private static final int WARMUP_RUNS = 2;
    private static final int MEASURE_RUNS = 3;

    public static void main(String[] args) {

        int[] sizes = {50000 ,100000, 500000, 1000000, 5000000, 10000000};

        System.out.println("===== ARRAY QUEUE =====");
        for (int n : sizes) {
            runAllExperiments(new MyArrayQueue<>(), n);
        }

        System.out.println("\n===== LINKED QUEUE =====");
        for (int n : sizes) {
            runAllExperiments(new MyLinkedQueue<>(), n);
        }
    }

    private static void runAllExperiments(Object queueType, int n) {

        warmUp(queueType, n);

        long enqueueTime = measureEnqueue(queueType, n);
        long dequeueTime = measureDequeue(queueType, n);
        long mixedTime = measureMixed(queueType, n);

        System.out.println("Tasks: " + n);
        System.out.println("Enqueue: " + enqueueTime + " ms");
        System.out.println("Dequeue: " + dequeueTime + " ms");
        System.out.println("Mixed: " + mixedTime + " ms");
        System.out.println("--------------------------");
    }

    private static void warmUp(Object queueType, int n) {
        for (int i = 0; i < WARMUP_RUNS; i++) {
            measureEnqueue(queueType, 10_000);
        }
    }

    private static long measureEnqueue(Object queueType, int n) {

        long totalTime = 0;

        for (int run = 0; run < MEASURE_RUNS; run++) {

            if (queueType instanceof MyArrayQueue) {
                MyArrayQueue<Integer> queue = new MyArrayQueue<>();
                long start = System.nanoTime();
                for (int i = 0; i < n; i++) queue.enqueue(i);
                long end = System.nanoTime();
                totalTime += (end - start);
            } else {
                MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
                long start = System.nanoTime();
                for (int i = 0; i < n; i++) queue.enqueue(i);
                long end = System.nanoTime();
                totalTime += (end - start);
            }
        }

        return (totalTime / MEASURE_RUNS) / 1_000_000;
    }

    private static long measureDequeue(Object queueType, int n) {

        long totalTime = 0;

        for (int run = 0; run < MEASURE_RUNS; run++) {

            if (queueType instanceof MyArrayQueue) {
                MyArrayQueue<Integer> queue = new MyArrayQueue<>();
                for (int i = 0; i < n; i++) queue.enqueue(i);

                long start = System.nanoTime();
                while (!queue.isEmpty()) queue.dequeue();
                long end = System.nanoTime();
                totalTime += (end - start);

            } else {
                MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
                for (int i = 0; i < n; i++) queue.enqueue(i);

                long start = System.nanoTime();
                while (!queue.isEmpty()) queue.dequeue();
                long end = System.nanoTime();
                totalTime += (end - start);
            }
        }

        return (totalTime / MEASURE_RUNS) / 1_000_000;
    }

    private static long measureMixed(Object queueType, int n) {

        long totalTime = 0;

        for (int run = 0; run < MEASURE_RUNS; run++) {

            if (queueType instanceof MyArrayQueue) {
                MyArrayQueue<Integer> queue = new MyArrayQueue<>();
                long start = System.nanoTime();

                for (int i = 0; i < n; i++) {
                    queue.enqueue(i);
                    if (i % 3 == 0 && !queue.isEmpty()) queue.dequeue();
                }

                while (!queue.isEmpty()) queue.dequeue();

                long end = System.nanoTime();
                totalTime += (end - start);

            } else {
                MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
                long start = System.nanoTime();

                for (int i = 0; i < n; i++) {
                    queue.enqueue(i);
                    if (i % 3 == 0 && !queue.isEmpty()) queue.dequeue();
                }

                while (!queue.isEmpty()) queue.dequeue();

                long end = System.nanoTime();
                totalTime += (end - start);
            }
        }

        return (totalTime / MEASURE_RUNS) / 1_000_000;
    }
}