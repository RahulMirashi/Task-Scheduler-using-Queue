/**PerformanceTest.java
 * Measures performance of enqueue and dequeue operations
 */
public class PerformanceTest {

    public static void main(String[] args) {
        runTest(1000);
        runTest(10000);
        runTest(100000);
    }

    private static void runTest(int n) {
        MyQueue<Integer> queue = new MyQueue<>();

        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            queue.dequeue();
        }

        long end = System.nanoTime();

        System.out.println("Tasks: " + n + " | Time (ns): " + (end - start));
    }
}