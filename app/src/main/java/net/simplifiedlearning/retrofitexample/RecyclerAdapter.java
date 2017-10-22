package net.simplifiedlearning.retrofitexample;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import net.simplifiedlearning.retrofitexample.R;

import java.net.URL;

import static net.simplifiedlearning.retrofitexample.MainActivity.headings1;
import static net.simplifiedlearning.retrofitexample.MainActivity.images1;
import static net.simplifiedlearning.retrofitexample.MainActivity.likes1;
import static net.simplifiedlearning.retrofitexample.MainActivity.views1;

/**
 * Created by Madhus on 05-08-2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {

        public int currentItem;
        public ImageView itemImage;
        public ImageView itemImage1;
        public ImageView itemImage2;
        public TextView itemViews;
        public TextView itemHeadings;
        public TextView itemLikes;

        public ViewHolder(View itemView) {
            super(itemView);

            itemImage = (ImageView)itemView.findViewById(R.id.ivMain);
            itemImage1 = (ImageView)itemView.findViewById(R.id.ivViews);
            itemImage1.setImageResource(R.drawable.views);
            itemImage2 = (ImageView)itemView.findViewById(R.id.ivLikes);
            itemImage2.setImageResource(R.drawable.likes);
            itemViews = (TextView)itemView.findViewById(R.id.tvViews);
            itemHeadings = (TextView)itemView.findViewById(R.id.tvHeadings);
            itemLikes = (TextView)itemView.findViewById(R.id.tvLikes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position= getAdapterPosition();

                    //if(position==0)
                    //{Intent intent = new Intent(v.getContext(),WeekActivity.class);
                    //    v.getContext().startActivity(intent);}

                    //Snackbar snackbar=Snackbar.make(v, "Click detected on item " + position,
                    //        Snackbar.LENGTH_LONG);
                    //snackbar.show();
                }
            });
        }
    }



    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, int i) {

        //viewHolder.itemTitle.setText(titles[i]);
        //String theurl="http://www.notpap.com?param=" + java.net.URLEncoder.encode(images1[i],"UTF-8");
        //URL myurl=new URL(images1[i]);
        Picasso.with(viewHolder.itemImage.getContext()).load(images1[i]).into(viewHolder.itemImage);
        viewHolder.itemHeadings.setText(headings1[i]);
        viewHolder.itemViews.setText(views1[i]);
        viewHolder.itemLikes.setText(likes1[i]);

    }

    @Override
    public int getItemCount() {
        return headings1.length;
    }


}
