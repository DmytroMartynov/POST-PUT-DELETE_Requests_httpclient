package dmytro.martynov;


import dmytro.martynov.Resourse.Posts;

public class Main {
    public static void main(String[] args) {
        ApiService service = ApiService.getInstance();
        Posts post = service.getPostById(1);
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
