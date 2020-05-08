package models;

public class Todos {

    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todos() {
    }

    @Override
    public String toString() {
        return "Todos{" +
                "userId=" + userId +
                "\nid=" + id +
                "\ntitle='" + title + '\'' +
                "\ncompleted=" + completed +
                '}';
    }
}
