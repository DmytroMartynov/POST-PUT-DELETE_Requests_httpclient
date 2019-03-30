package dmytro.martynov.Resourse;

public class Todos {
    private boolean completed;
    private String title;
    private int id;
    private int userId;

    @Override
    public String toString() {
        return "Todos{" +
                "completed=" + completed +
                ", title='" + title + '\'' +
                ", id=" + id +
                ", userId=" + userId +
                '}';
    }
}
