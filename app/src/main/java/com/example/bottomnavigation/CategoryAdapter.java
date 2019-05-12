package com.example.bottomnavigation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private Context context;
    private LayoutInflater inflate;
    private List<Category> listCategories;
    private String[] text;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);   //gọi đến contructor của viewHolder truyền vào view
            name = view.findViewById(R.id.grid_text);
            thumbnail = view.findViewById(R.id.grid_image);
        }
    }

    public CategoryAdapter(Context context, List<Category> listCategories) {
        this.context = context;
        this.listCategories = listCategories;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_single, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        final Category category = listCategories.get(i);
        holder.name.setText(category.getName());

        Glide.with(context)
                .load(category.getImage())
                .into(holder.thumbnail);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        if(inflate == null)
//        {
//            inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        }
//        if(convertView == null)
//        {
//            convertView = inflate.inflate(R.layout.grid_single, null);
//        }
//        ImageView imageView = convertView.findViewById(R.id.grid_image);
//        TextView textView = convertView.findViewById(R.id.grid_text);
//
//        imageView.setImageResource(listCategories.get(position).getImage());
//        textView.setText(listCategories.get(position).getName());
//        return convertView;
//    }
}
