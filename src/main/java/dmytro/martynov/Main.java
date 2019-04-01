package dmytro.martynov;


import dmytro.martynov.Resourse.Posts;
import dmytro.martynov.Resourse.Users;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ApiService service = ApiService.getInstance();
        Posts post = service.getPostById(1);
        List<Posts> postsList = service.getPosts();
        Users user = service.getUserById(10);
        System.out.println(postsList);
        System.out.println("------------------------------");
        System.out.println(user);
        System.out.println("------------------------------");
        System.out.println(post);
        System.out.println("------------------------------");
        System.out.println(service.getComentsFromPostId(10));
        System.out.println("------------------------------");
        System.out.println(service.getPostsFromUserId(1));
        System.out.println("------------------------------");
        System.out.println(service.getPosts());
        System.out.println("------------------------------");
        service.putRequest(post);
        service.postRequest(post);
        service.deleteRequest(post);






    }
}
