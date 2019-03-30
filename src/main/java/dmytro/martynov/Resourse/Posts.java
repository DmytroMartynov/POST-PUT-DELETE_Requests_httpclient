package dmytro.martynov.Resourse;

public class Posts {
    private int id;
    private int userId;
    private String title;
    private String body;

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", userld=" + userId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
