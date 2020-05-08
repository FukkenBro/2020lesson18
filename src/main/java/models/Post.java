package models;

public class Post {

    private int userId;
    private int id;
    private String title;
    private String body;

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                "\nid=" + id +
                "\ntitle='" + title + '\'' +
                "\nbody='" + body + '\'' +
                '}';
    }
}
