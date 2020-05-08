import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//        1)Программно послать HEAD запрос для файла доступного по прямой ссылке,например:
//        https://dl.dropboxusercontent.com/s/vxnydq4xjkmefrp/CLUVAL.java
//        Скачать сначала первую половину этого файла,а потом докачать вторую.
//        Range:bytes=0-500

public class Task1 {
    private static final String URL = "https://dl.dropboxusercontent.com/s/vxnydq4xjkmefrp/CLUVAL.java";
    private static final String HEADER_CL = "Content-Length";
    private static final String FILE_NAME = "Result.txt";

    public static void main(String[] args) throws IOException {
        resetFile(FILE_NAME);
        System.out.println("Initializing download from " + URL + " . . . ");
        int fileSize = getContentLength(URL);
        System.out.println("Downloading first " + fileSize / 2 + " bytes");
        saveToTXT(download(URL, 0, fileSize / 2), FILE_NAME);
        System.out.println("Downloading second " + fileSize / 2 + " bytes");
        saveToTXT(download(URL, fileSize / 2, fileSize), FILE_NAME);
        System.out.println("Download completed to file " + FILE_NAME);

    }

    public static String download(String URL, int from, int to) throws IOException {
        if (from < 0 || to < 0 || from > to) {
            System.out.println("Invalid size");
        }
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(URL)
                .method("GET", null)
                .addHeader("Range", "bytes=" + from + to)
                .build();
        String result = client.newCall(request).execute().body().string();
        return result;
    }

    public static int getContentLength(String URL) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(URL).method("HEAD", null).build();
        String contentLength = client.newCall(request).execute().header(HEADER_CL);
        int result = Integer.parseInt(contentLength);
        return result;
    }

    private static void saveToTXT(String input, String fileName) throws FileNotFoundException {
        try {
            Files.write(Paths.get(fileName), input.getBytes(), StandardOpenOption.APPEND);
        } catch (Exception FileNotFoundException) {
            System.out.println("File not found");
        }
    }

    private static void resetFile(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName, false);
            fw.write("");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
