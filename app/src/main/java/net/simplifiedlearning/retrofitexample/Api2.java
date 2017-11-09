package net.simplifiedlearning.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static net.simplifiedlearning.retrofitexample.MainActivity.id1;
import static net.simplifiedlearning.retrofitexample.RecyclerAdapter.poid;

/**
 * Created by Belal on 10/2/2017.
 */

public interface Api2 {

    String BASE_URL = "http://www.notpap.com/";

    //public String temporary=id1[postid];
    @GET("json1.php")
    Call<List<EachPost>> getEachPost(@Query("postid") String postid);
}


