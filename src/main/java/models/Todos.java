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
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
