package net.simplifiedlearning.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.id;
import static net.simplifiedlearning.retrofitexample.MainActivity.id1;
import static net.simplifiedlearning.retrofitexample.MainActivity.images1;
import static net.simplifiedlearning.retrofitexample.RecyclerAdapter.poid;

public class IndividualPost extends AppCompatActivity {


    public static String[] headings2;
    public static String[] images2;
    public static String[] content2;
    public static int ans;
    public TextView PostHeading;
    public ImageView PostImage;
    public TextView Content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_post);

        Content = (TextView) findViewById(R.id.tvContent);

        PostHeading = (TextView) findViewById(R.id.tvPostheading);
        PostImage = (ImageView) findViewById(R.id.ivPostimage);

        getEachPost();






    }

    private void getEachPost() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api2.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api2 api = retrofit.create(Api2.class);

        Call<List<EachPost>> call = api.getEachPost(id1[poid]);

        call.enqueue(new Callback<List<EachPost>>() {
            @Override
            public void onResponse(Call<List<EachPost>> call, Response<List<EachPost>> response) {
                List<EachPost> eachPostList = response.body();

                //Creating an String array for the ListView
                String[] headings = new String[eachPostList.size()];
                String[] images = new String[eachPostList.size()];
                String[] content = new String[eachPostList.size()];

                ans = eachPostList.size();


                headings2= new String[eachPostList.size()];
                images2= new String[eachPostList.size()];
                content2= new String[eachPostList.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < eachPostList.size(); i++) {
                    headings[i] = eachPostList.get(i).getHeading();
                    images[i]=eachPostList.get(i).getImage();
                    content[i]=eachPostList.get(i).getContent();
                    Content.setText(Html.fromHtml(content[i]));
                    PostHeading.setText(headings[i]);
                    Picasso.with(getBaseContext()).load(images1[poid]).into(PostImage);
                    headings2[i] = eachPostList.get(i).getHeading();
                    images2[i]=eachPostList.get(i).getImage();
                    content2[i]=eachPostList.get(i).getContent();

                }


                //displaying the string array into listview
                //listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes))

            }

            @Override
            public void onFailure(Call<List<EachPost>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
