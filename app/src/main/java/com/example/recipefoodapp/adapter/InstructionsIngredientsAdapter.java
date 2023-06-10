package com.example.recipefoodapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipefoodapp.R;
import com.example.recipefoodapp.model.Equipment;
import com.example.recipefoodapp.model.Ingredient;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InstructionsIngredientsAdapter extends RecyclerView.Adapter<InstructionsIngredientsViewHolder> {
    Context context;
    List<Ingredient> list;

    public InstructionsIngredientsAdapter(Context context, List<Ingredient> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public InstructionsIngredientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InstructionsIngredientsViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.list_instructions_step_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull InstructionsIngredientsViewHolder holder, int position) {
//        holder.textView_instruction_name.setText(list.get(position).name);
//        holder.recycler_instruction_steps.setHasFixedSize(true);
//        holder.recycler_instruction_steps.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
//
//        InstructionsStepAdapter instructionsStepAdapter = new InstructionsStepAdapter(context, list.get(position).);
//        holder.recycler_instruction_steps.setAdapter(instructionsStepAdapter);

        holder.textView_instruction_step_name.setText(list.get(position).name);
        holder.textView_instruction_step_name.setSelected(true);
        Picasso.get().load("https://spoonacular.com/cdn/ingredients_100x100/" + list
                .get(position).image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class InstructionsIngredientsViewHolder extends RecyclerView.ViewHolder {
    TextView textView_instruction_step_name;
    ImageView imageView_instructions_step_items;
    public InstructionsIngredientsViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_instruction_step_name = itemView.findViewById(R.id.textView_instructions_step_item);
        imageView_instructions_step_items = itemView.findViewById(R.id.imageView_instructions_step_items);
    }
}
