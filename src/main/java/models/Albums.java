package models;

public class Albums {

    private int userId;
    private int id;
    private String title;

    public Albums() {
    }

    @Override
    public String toString() {
        return "Albums{" +
                "usedId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}