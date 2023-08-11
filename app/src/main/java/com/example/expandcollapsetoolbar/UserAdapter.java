package com.example.expandcollapsetoolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{
    private List<User> mlistUser;
    public void setData(List<User> list){
        this.mlistUser = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_user,parent,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = mlistUser.get(position);
        holder.HinhUser.setImageResource(user.getResourceId());
        holder.TenUser.setText(user.getName());
        holder.DiaChiUser.setText(user.getAddress());

    }

    @Override
    public int getItemCount() {
        return mlistUser.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView HinhUser;
        private TextView TenUser, DiaChiUser;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            HinhUser = itemView.findViewById(R.id.id_circle_image);
            TenUser = itemView.findViewById(R.id.id_ten);
            DiaChiUser = itemView.findViewById(R.id.id_address);
        }
    }
}
