package task1;

public class Task {

    private String name;
    private String category;

    public Task(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}