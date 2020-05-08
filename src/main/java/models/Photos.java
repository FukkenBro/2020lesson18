package models;

public class Photos {

    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photos() {
    }

    @Override
    public String toString() {
        return "Photos{" +
                "albumId=" + albumId +
                "\nid=" + id +
                "\ntitle='" + title + '\'' +
                "\nurl='" + url + '\'' +
                "\nthumbnailUrl='" + thumbnailUrl + '\'' +
                '}';
    }
}
