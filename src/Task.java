/**
 * Represents a task in the scheduler
 */
public class Task {

    private String name;
    private long arrivalTime;

    public Task(String name) {
        this.name = name;
        this.arrivalTime = System.currentTimeMillis();
    }


    }
}