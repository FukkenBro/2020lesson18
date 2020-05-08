import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MyApiService {

    private static MyApiService instance;

    private MyApiService() {
    }

    public static synchronized MyApiService getInstance() {
        if (instance == null) {
            instance = new MyApiService();
        }
        return instance;
    }

    private static final String URL_ALBUM = "https://jsonplaceholder.typicode.com/albums";
    private static final String URL_COMMENTS = "https://jsonplaceholder.typicode.com/comments";
    private static final String URL_PHOTOS = "https://jsonplaceholder.typicode.com/photos";
    private static final String URL_POST = "https://jsonplaceholder.typicode.com/posts";
    private static final String URL_TODOS = "https://jsonplaceholder.typicode.com/todos";
    private static final String URL_USERS = "https://jsonplaceholder.typicode.com/users";

    private static final Type ALBUM_TYPE = new TypeToken<List<Albums>>() {
    }.getType();
    private static final Type COMMENTS_TYPE = new TypeToken<List<Comments>>() {
    }.getType();
    private static final Type PHOTOS_TYPE = new TypeToken<List<Photos>>() {
    }.getType();
    private static final Type POST_TYPE = new TypeToken<List<Post>>() {
    }.getType();
    private static final Type TODOS_TYPE = new TypeToken<List<Todos>>() {
    }.getType();
    private static final Type USERS_TYPE = new TypeToken<List<Users>>() {
    }.getType();

    public List<Albums> getAlbums() throws IOException {
        List<Albums> list = new Gson().fromJson(getJson(URL_ALBUM), ALBUM_TYPE);
        return list;
    }

    public List<Comments> getComments() throws IOException {
        List<Comments> list = new Gson().fromJson(getJson(URL_COMMENTS), COMMENTS_TYPE);
        return list;
    }

    public List<Photos> getPhotos() throws IOException {
        List<Photos> list = new Gson().fromJson(getJson(URL_PHOTOS), PHOTOS_TYPE);
        return list;
    }

    public List<Post> getPost() throws IOException {
        List<Post> list = new Gson().fromJson(getJson(URL_POST), POST_TYPE);
        return list;
    }

    public List<Todos> getTodos() throws IOException {
        List<Todos> list = new Gson().fromJson(getJson(URL_TODOS), TODOS_TYPE);
        return list;
    }

    public List<Users> getUsers() throws IOException {
        List<Users> list = new Gson().fromJson(getJson(URL_USERS), USERS_TYPE);
        return list;
    }

    private String getJson(String url) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .callTimeout(120, TimeUnit.SECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();
        String result = Objects.requireNonNull(client.newCall(request).execute().body()).string();
        return result;
    }


}