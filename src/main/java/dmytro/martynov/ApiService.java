package dmytro.martynov;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dmytro.martynov.Resourse.*;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class ApiService {
    private static ApiService instance;
    private static String URL_NAME = "https://jsonplaceholder.typicode.com/";
    private Gson gson = new Gson();
    private CloseableHttpClient httpclient = HttpClients.createDefault();


    public static ApiService getInstance() {
        if (instance == null) {
            instance = new ApiService();
        }
        return instance;
    }

    private static String readUrl(String urlString) {
        BufferedReader reader = null;
        try {
            try {
                URL url = new URL(urlString);
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                StringBuffer buffer = new StringBuffer();
                int read;
                char[] chars = new char[1024];
                while ((read = reader.read(chars)) != -1)
                    buffer.append(chars, 0, read);

                return buffer.toString();
            } finally {
                if (reader != null)
                    reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlString;
    }

    public void postRequest(Posts posts) throws IOException {
        try {
            HttpPost httpPost = new HttpPost("https://jsonplaceholder.typicode.com/posts");
            StringEntity postingString = new StringEntity(gson.toJson(posts));
            httpPost.addHeader("content-type", "application/json");
            httpPost.setEntity(postingString);
            System.out.println("Executing request " + httpPost.getRequestLine());
            ResponseHandler< String > responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPost, responseHandler);
            System.out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void putRequest(Posts posts) {
        try {
            HttpPut httpPut = new HttpPut("https://jsonplaceholder.typicode.com/posts/1");
            System.out.println("Executing request " + httpPut.getRequestLine());
            StringEntity postingString = new StringEntity(gson.toJson(posts));
            httpPut.addHeader("content-type", "application/json");
            httpPut.setEntity(postingString);
            ResponseHandler< String > responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpPut, responseHandler);
            System.out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteRequest(Posts posts) {
        try {
            HttpDelete httpDelete = new HttpDelete("https://jsonplaceholder.typicode.com/posts/1");
            System.out.println("Executing request " + httpDelete.getRequestLine());
            ResponseHandler< String > responseHandler = response -> {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            };
            String responseBody = httpclient.execute(httpDelete, responseHandler);
            System.out.println(responseBody);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Posts getPostById(int id) {
        return gson.fromJson(readUrl(URL_NAME + "posts/" + id), Posts.class);
    }

    public List< Posts > getPosts() {
        Type listType = new TypeToken< List< Posts > >() {
        }.getType();
        return gson.fromJson(readUrl(URL_NAME + "posts/"), listType);
    }

    public Coments getCommentById(int id) {
        return gson.fromJson(readUrl(URL_NAME + "comments/" + id), Coments.class);
    }

    public List< Coments > getComments() {
        Type listType = new TypeToken< List< Coments > >() {
        }.getType();
        return gson.fromJson(readUrl(URL_NAME + "comments"), listType);
    }

    public Albums getAlbumById(int id) {
        return gson.fromJson(readUrl(URL_NAME + "albums/" + id), Albums.class);
    }

    public List< Albums > getAlbums() {
        Type listType = new TypeToken< List< Albums > >() {
        }.getType();
        return gson.fromJson(readUrl(URL_NAME + "albums"), listType);
    }

    public Photos getPhotoById(int id) {
        return gson.fromJson(readUrl(URL_NAME + "photos/" + id), Photos.class);
    }

    public List< Photos > getPhotos() {
        Type listType = new TypeToken< List< Photos > >() {
        }.getType();
        return gson.fromJson(readUrl(URL_NAME + "photos"), listType);
    }

    public Todos getTodoById(int id) {
        return gson.fromJson(readUrl(URL_NAME + "todos/" + id), Todos.class);
    }

    public List< Todos > getTodos() {
        Type listType = new TypeToken< List< Todos > >() {
        }.getType();
        return gson.fromJson(readUrl(URL_NAME + "todos"), listType);
    }

    public Users getUserById(int id) {
        return gson.fromJson(readUrl(URL_NAME + "users/" + id), Users.class);
    }

    public List< Users > getUsers() {
        Type listType = new TypeToken< List< Users > >() {
        }.getType();
        return gson.fromJson(readUrl(URL_NAME + "users"), listType);
    }

    public List< Coments > getComentsFromPostId(int postId) {
        Type listType = new TypeToken< List< Coments > >() {
        }.getType();
        return gson.fromJson(readUrl(URL_NAME + "comments?postId=" + postId), listType);
    }

    public List< Posts > getPostsFromUserId(int userId) {
        Type listType = new TypeToken< List< Posts > >() {
        }.getType();
        return gson.fromJson(readUrl(URL_NAME + "posts?userId=" + userId), listType);
    }
}



