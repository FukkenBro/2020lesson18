import models.*;

import java.io.IOException;
import java.util.List;

//        3*) Написать класс MyApiService с использованием паттерна синглтон для доступа к API:
//        (предварительно создать все необходимые модели List, Post, User...)
//
//        Пример:
//        ApiService service = ApiService.getInstance();
//        List<Post> posts = service.getPosts();
//        List<User> users = service.getUses();
//
//        Для следующих запросов:
//        Posts https://jsonplaceholder.typicode.com/posts
//        Comments https://jsonplaceholder.typicode.com/comments
//        Albums https://jsonplaceholder.typicode.com/albums
//        Photos https://jsonplaceholder.typicode.com/photos
//        Users https://jsonplaceholder.typicode.com/users
//        Todos https://jsonplaceholder.typicode.com/todos

public class Task3 {

    public static void main(String[] args) throws IOException {
        MyApiService apiService = MyApiService.getInstance();
        System.out.println("Getting Albums . . . ");
        List<Albums> albums = apiService.getAlbums();
        System.out.println("Getting Comments . . . ");
        List<Comments> comments = apiService.getComments();
        System.out.println("Getting Photos . . . ");
        List<Photos> photos = apiService.getPhotos();
        System.out.println("Getting Posts . . . ");
        List<Post> posts = apiService.getPost();
        System.out.println("Getting Todos . . . ");
        List<Todos> todos = apiService.getTodos();
        System.out.println("Getting Users . . . ");
        List<Users> users = apiService.getUsers();

        System.out.println(albums.get(2));
        System.out.println("===============================================");
        System.out.println(comments.get(4));
        System.out.println("===============================================");
        System.out.println(photos.get(6));
        System.out.println("===============================================");
        System.out.println(posts.get(8));
        System.out.println("===============================================");
        System.out.println(todos.get(10));
        System.out.println("===============================================");
        System.out.println(users.get(5));
    }
}
