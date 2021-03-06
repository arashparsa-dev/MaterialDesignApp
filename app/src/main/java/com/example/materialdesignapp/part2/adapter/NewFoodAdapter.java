package com.example.materialdesignapp.part2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdesignapp.R;
import com.example.materialdesignapp.part2.DetailFoodActivity;
import com.example.materialdesignapp.part2.model.Food;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewFoodAdapter extends RecyclerView.Adapter<NewFoodAdapter.MyViewHolder> {
    Context context;
    List<Food> data;

    public NewFoodAdapter(Context context, List<Food> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food_new,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name.setText(data.get(position).getName());
        holder.tv_count.setText("("+data.get(position).getCount()+")");
        holder.tv_rate.setText(data.get(position).getRating());
        holder.tv_price.setText("قیمت : "+data.get(position).getPrice()+" تومان");
        Picasso.with(context).load(data.get(position).getLink_img()).into(holder.iv_recommend);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailFoodActivity.class);
                intent.putExtra("name",data.get(position).getName());
                intent.putExtra("price",data.get(position).getPrice());
                intent.putExtra("count",data.get(position).getCount());
                intent.putExtra("rate",data.get(position).getRating());
                intent.putExtra("link_img",data.get(position).getLink_img());
                intent.putExtra("desc",data.get(position).getDescription());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name,tv_rate,tv_count,tv_price;
        ImageView iv_recommend;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_itemRecommend_foodName);
            tv_rate = itemView.findViewById(R.id.tv_itemRecommend_foodRate);
            tv_count = itemView.findViewById(R.id.tv_itemRecommend_foodCount);
            tv_price = itemView.findViewById(R.id.tv_itemRecommend_foodPrice);
            iv_recommend = itemView.findViewById(R.id.iv_itemRecommend_food);

        }
    }
}
