package comp47500.advds;
/**
 * Simulates a task scheduling system using a queue
 */
public class TaskScheduler {

    public static void main(String[] args) {

        MyLinkedQueue<Task> taskQueue = new MyLinkedQueue<>();

        System.out.println("Adding tasks to scheduler...\n");

        taskQueue.enqueue(new Task("Print Research Paper", 10));
        taskQueue.enqueue(new Task("Compile Java Program", 5));
        taskQueue.enqueue(new Task("Send Email Report", 3));
        taskQueue.enqueue(new Task("Backup Files", 7));

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