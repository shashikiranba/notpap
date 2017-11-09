package net.simplifiedlearning.retrofitexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

  //  ListView listView;

    public static String[] headings1;
    public static String[] images1;
    public static String[] views1;
    public static String[] likes1;
    public static String[] id1;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // listView = (ListView) findViewById(R.id.listViewHeroes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarmain);
        initToolbar(toolbar);

        setUpDrawer(toolbar);
        //calling the method to display the heroes
        getHeroes();


    }


    public void setUpDrawer(Toolbar toolbar){
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Madhusudhan K").withEmail("madhusk167@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Settings");

//create the drawer and remember the `Drawer` result object
        final Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1, item2
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D
                        switch(position){

                            case 1:return false;
                            case 2:break;
                        }
                        return true;
                    }
                })
                .build();
    }


    public void initToolbar(Toolbar toolbar){
        toolbar.setTitle("Notpap");
        setSupportActionBar(toolbar);
    }
    private void getHeroes() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<Posts>> call = api.getHeroes();

        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                List<Posts> postsList = response.body();

                //Creating an String array for the ListView
                String[] headings = new String[postsList.size()];
                String[] images = new String[postsList.size()];
                String[] views = new String[postsList.size()];
                String[] likes = new String[postsList.size()];
                String[] id = new String[postsList.size()];
                headings1= new String[postsList.size()];
                images1= new String[postsList.size()];
                views1= new String[postsList.size()];
                likes1= new String[postsList.size()];
                id1= new String[postsList.size()];

                //looping through all the heroes and inserting the names inside the string array
                for (int i = 0; i < postsList.size(); i++) {
                    headings[i] = postsList.get(i).getHeading();
                    images[i]=postsList.get(i).getImage();
                    views[i]=postsList.get(i).getViews();
                    likes[i]=postsList.get(i).getLikes();
                    id[i]=postsList.get(i).getId();
                }


                //displaying the string array into listview
                //listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, heroes));
                setUpRecyclerView(headings,images,views,likes,id);

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void setUpRecyclerView(String[] temp,String[] temp1,String[] temp2,String[] temp3, String[] temp4){
        for(int i=0;i<temp.length;i++){
            headings1[i]=temp[i];
            images1[i]=temp1[i];
            views1[i]=temp2[i];
            likes1[i]=temp3[i];
            id1[i]=temp4[i];
        }
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new net.simplifiedlearning.retrofitexample.RecyclerAdapter();
        recyclerView.setAdapter(adapter);


    }


}
