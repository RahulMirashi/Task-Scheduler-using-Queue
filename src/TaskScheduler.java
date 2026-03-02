/**
 * Simulates a task scheduling system using a queue
 */
public class TaskScheduler {

    public static void main(String[] args) {

        MyQueue<Task> taskQueue = new MyQueue<>();

        System.out.println("Adding tasks to scheduler...\n");

        taskQueue.enqueue(new Task("Print Research Paper"));
        taskQueue.enqueue(new Task("Compile Java Program"));
        taskQueue.enqueue(new Task("Send Email Report"));
        taskQueue.enqueue(new Task("Backup Files"));

        System.out.println("Processing tasks...\n");

        while (!taskQueue.isEmpty()) {
            Task task = taskQueue.dequeue();
            System.out.println("Processing: " + task);

            try {
                Thread.sleep(500); // simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nAll tasks completed.");
    }
}