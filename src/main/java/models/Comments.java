package models;

public class Comments {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public Comments() {
    }

    @Override
    public String toString() {
        return "Comments{" +
                "postId=" + postId +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\nemail='" + email + '\'' +
                "\nbody='" + body + '\'' +
                '}';
    }
}