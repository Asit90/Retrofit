package cakart.cakart.in.retrofit;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class BloggerApi {
    private static final String key="AIzaSyBpi14Mz6D19pqIMRHgiOIhnq6kJtXjHpM";
    private static final String url="https://www.googleapis.com/blogger/v3/blogs/4938342209824181372/posts/";


    public static PostService postService=null;

    public static PostService getService(){
         if(postService == null){
             Retrofit retrofit= new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
             postService=retrofit.create(PostService.class);
         }
         return postService;
    }

    public interface PostService{
        @GET("?key="+key)
        Call<PostList> getPostList();

       // @GET("{postId}/?key="+key)
      //  Call<Item> getPostById(@Path("postId") String id);
        //Access Post By id=BASE URL +/postid
        //SEARCH POST=BASE URL + search?q=query terms

    }
}
