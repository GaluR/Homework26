package pl.javastart.todo.entity;

public enum TaskComplited {

    YES("Do zrobienia"),
    NO("Wykonane");

    private String displayName;

    TaskComplited(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
