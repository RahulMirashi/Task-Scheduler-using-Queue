public class Task {

    private String name;
    private long arrivalTime;
    private long duration; // in milliseconds

    public Task(String name) {
        this(name, 0);
    }

    public Task(String name, long duration) {
        this.name = name;
        this.arrivalTime = System.currentTimeMillis();
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return name + " (arrived at " + arrivalTime + ", duration " + duration + "ms)";
    }
}