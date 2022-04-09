package com.salikh.dictonariy.adapters;

import static com.salikh.dictonariy.activity.InterestActivity.chekVizibl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.salikh.dictonariy.R;
import com.salikh.dictonariy.cache.MemoryHelper;
import com.salikh.dictonariy.database.DataBase;
import com.salikh.dictonariy.model.WordEngData;

import java.util.ArrayList;

public class SwipeAdapterInter extends RecyclerView.Adapter<SwipeAdapterInter.SwipeHolder> {


    private final Context context;
    private final ViewBinderHelper viewBinderHelper = new ViewBinderHelper();
    private ArrayList<WordEngData> wordEngData;


    public SwipeAdapterInter(Context context, ArrayList<WordEngData> wordEngData) {
        this.context = context;
        this.wordEngData = wordEngData;
    }

    public void setData(ArrayList<WordEngData> data) {
        this.wordEngData = new ArrayList<>();
        this.wordEngData = data;
        notifyItemRangeInserted(wordEngData.size() - data.size(), data.size());
    }

    @NonNull
    @Override
    public SwipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_interes_swipe, parent, false);
        return new SwipeHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull SwipeHolder holder, @SuppressLint("RecyclerView") int position) {


        viewBinderHelper.setOpenOnlyOne(true);
        viewBinderHelper.bind(holder.swipeRevealLayout, String.valueOf(wordEngData.get(position).getEng()));
        viewBinderHelper.bind(holder.swipeRevealLayout, String.valueOf(wordEngData.get(position).getUzb()));
        viewBinderHelper.closeLayout(String.valueOf(wordEngData.get(position).getEng()));
        viewBinderHelper.closeLayout(String.valueOf(wordEngData.get(position).getUzb()));
        holder.bindData(wordEngData.get(position));


        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("TAGaaa", wordEngData.get(position).getEng());
                Log.e("TAGaaa", wordEngData.get(position).getUzb());

                DataBase.getDataBase().insertWordDelete(wordEngData.get(position).getEng(), wordEngData.get(position).getUzb());

                DataBase.getDataBase().deleteWordInter(wordEngData.get(position));
                wordEngData.remove(wordEngData.get(position));
                notifyDataSetChanged();

                chekVizibl();


            }
        });
    }


    @Override
    public int getItemCount() {
        return wordEngData.size();
    }


    class SwipeHolder extends RecyclerView.ViewHolder {

        private final TextView textEng;
        private final TextView textUzb;
        private final ImageView delete;
        private final SwipeRevealLayout swipeRevealLayout;
        private final LinearLayout layout;
        private final ConstraintLayout itemContainer;


        public SwipeHolder(@NonNull View itemView) {
            super(itemView);
            delete = itemView.findViewById(R.id.textDelete);
            textEng = itemView.findViewById(R.id.textEng_inter);
            textUzb = itemView.findViewById(R.id.textUzb_inter);
            swipeRevealLayout = itemView.findViewById(R.id.swipeInter);
            layout = itemView.findViewById(R.id.border_inter);
            itemContainer = itemView.findViewById(R.id.item_group_inter);


            delete.setImageResource(MemoryHelper.getHelpr().getDelete());
            textEng.setTextColor(MemoryHelper.getHelpr().getTextColor());
            textUzb.setTextColor(MemoryHelper.getHelpr().getTextColor());
            layout.setBackgroundColor(MemoryHelper.getHelpr().getBackColor());
        }

        private void bindData(WordEngData data) {
            textEng.setText(data.getEng());
            textUzb.setText(data.getUzb());
        }

    }

}
