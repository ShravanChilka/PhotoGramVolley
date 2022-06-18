package com.example.photovolleyapi;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.postHolder> {

    Context context;
    List<Items> postList;

    public PostAdapter(Context context, List<Items> postList) {
        this.context = context;
        this.postList = postList;
    }

    @NonNull
    @Override
    public postHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.post_card,parent,false);
        return new postHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull postHolder holder, int position) {
        Items items = postList.get(position);
        holder.setImageView(items.getImageURL());
        holder.setUserName(items.getUserName());
        holder.setLikes(items.getLikes());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class postHolder extends RecyclerView.ViewHolder{

        ImageView postImage;
        TextView userName, likes ;
        View view;

        public postHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }
        public void  setImageView(String imageURL){
            postImage = view.findViewById(R.id.img);
            Glide.with(context).load(imageURL).into(postImage);
        }
        public void setLikes(int mLikes){
            likes = view.findViewById(R.id.like_count);
            likes.setText(mLikes + " likes");
        }
        public void setUserName(String mUserName) {
            userName = view.findViewById(R.id.user_name);
            userName.setText(mUserName);
        }
    }
}
