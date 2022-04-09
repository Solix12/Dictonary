package com.salikh.dictonariy.adapters;


import static com.salikh.dictonariy.activity.DeletesActivity.setVis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.salikh.dictonariy.R;
import com.salikh.dictonariy.cache.MemoryHelper;
import com.salikh.dictonariy.model.WordEngData;

import java.util.ArrayList;

public class DeleteAdapter extends RecyclerView.Adapter<DeleteAdapter.DeleteHolder> {

    private ArrayList<WordEngData> data = new ArrayList<>();

    public DeleteAdapter(ArrayList<WordEngData> data) {
        this.data = data;
    }

    public void setData(ArrayList<WordEngData> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DeleteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delete, parent, false);
        return new DeleteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeleteHolder holder, int position) {

        holder.textEng.setText(data.get(position).getEng());
        holder.textUzb.setText(data.get(position).getUzb());
        setVis();

    }

    public void clearData() {
        data.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class DeleteHolder extends RecyclerView.ViewHolder {

        private final TextView textEng;
        private final TextView textUzb;
        private final LinearLayout layout;

        public DeleteHolder(@NonNull View itemView) {
            super(itemView);
            textEng = itemView.findViewById(R.id.word_text_eng_del);
            textUzb = itemView.findViewById(R.id.word_text_uzb_del);
            layout = itemView.findViewById(R.id.border_del);

            textEng.setTextColor(MemoryHelper.getHelpr().getTextColor());
            textUzb.setTextColor(MemoryHelper.getHelpr().getTextColor());
            layout.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        }


    }
}
