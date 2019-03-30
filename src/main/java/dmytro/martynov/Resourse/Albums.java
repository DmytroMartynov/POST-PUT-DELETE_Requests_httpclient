package dmytro.martynov.Resourse;

public class Albums {
    private int id;
    private int userId;
    private String title;

    @Override
    public String toString() {
        return "Albums{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                '}';
    }
}
