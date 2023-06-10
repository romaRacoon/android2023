package com.example.recipefoodapp.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipefoodapp.R;
import com.example.recipefoodapp.listener.RecipeClickListener;
import com.example.recipefoodapp.model.Recipe;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RandomRecipeAdapter extends RecyclerView.Adapter<RandomRecipeViewHolder> {
    Context context;
    List<Recipe> recipes;
    RecipeClickListener listener;

    public RandomRecipeAdapter(Context context, List<Recipe> recipes,
                               RecipeClickListener listener) {
        this.context = context;
        this.recipes = recipes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomRecipeViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.list_random_recipe, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int position) {
        holder.textView_title.setText(recipes.get(position).title);
        holder.textView_title.setSelected(true);
        holder.textView_likes.setText(recipes.get(position).aggregateLikes + " Likes");
        holder.textView_servings.setText(recipes.get(position).servings + " Servings");
        holder.textView_time.setText(recipes.get(position).readyInMinutes + " Minutes");
        Picasso.get().load(recipes.get(position).image).into(holder.imageView_food);

        holder.random_list_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRecipeClicked(String.valueOf(recipes.get(holder.getAdapterPosition()).id));
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
class RandomRecipeViewHolder extends RecyclerView.ViewHolder {
    CardView random_list_container;
    TextView textView_title;
    ImageView imageView_food;
    TextView textView_servings;
    TextView textView_likes;
    TextView textView_time;

    public RandomRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        random_list_container = itemView.findViewById(R.id.random_list_container);
        textView_title = itemView.findViewById(R.id.textView_title);
        imageView_food = itemView.findViewById(R.id.imageView_food);
        textView_servings = itemView.findViewById(R.id.textView_servings);
        textView_likes = itemView.findViewById(R.id.textView_likes);
        textView_time = itemView.findViewById(R.id.textView_time);
    }
}
