package com.sanskaru.portfolio;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static com.sanskaru.portfolio.MainActivity.darkMode;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{



    List<Item> list;
    CustomCallback listener;

    public MyAdapter(List<Item> list, CustomCallback listener)
    {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.side_bar, parent, false);

        if (!darkMode)if (!darkMode) {
            view.setBackgroundColor(Color.rgb(255, 255, 255));
            ((ImageView) view.findViewById(R.id.menu_icon)).setBackgroundColor(Color.rgb(255, 255, 255));
            ((ImageView) view.findViewById(R.id.menu_selector)).setBackgroundColor(Color.rgb(255, 255, 255));
        }

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.icon.setImageResource(list.get(position).getIcon());

        if (list.get(position).isSelected()) holder.selected.setVisibility(View.VISIBLE);
        else holder.selected.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount()
    {
        Log.i("List Size", list.toString());
        return list.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView icon, selected;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            icon = (ImageView) itemView.findViewById(R.id.menu_icon);
            selected = (ImageView) itemView.findViewById(R.id.menu_selector);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onSideMenuClick(getAdapterPosition());
                }
            });

        }
    }
}
