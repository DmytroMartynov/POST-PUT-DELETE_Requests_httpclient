package dmytro.martynov.Resourse;

public class Photos {
    private int albumId;
    private int id;
    private String thumbnailUrl;
    private String title;
    private String url;

    @Override
    public String toString() {
        return "Photos{" +
                "albumId=" + albumId +
                ", id=" + id +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
