import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.io.IOException;

//        2) Программно послать POST запрос на https://postman-echo.com/post где в BODY передать foo1=bar1&foo2=bar2 в формате x-www-form-urlencoded
//        Ответ распарсить и вывести.

public class Task2 {
    private static final String URL = "https://postman-echo.com/post";
    private static final String BODY = "foo1=bar1&foo2=bar2";

    public static void main(String[] args) throws IOException {
        System.out.println("Initializing query to " + URL + " with BODY " + BODY + " . . . ");
        ResponseModel response = deserialize(getBody(URL, BODY));
        System.out.println(response.toString());
        System.out.println("Completed");
    }

    public static String getBody(String URL, String BODY) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType type = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(type, BODY);
        Request request = new Request.Builder()
                .url(URL)
                .method("POST", body)
                .build();
        String result = client.newCall(request).execute().body().string();
        return result;
    }

    private static ResponseModel deserialize(String str) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(str, ResponseModel.class);

    }
}
