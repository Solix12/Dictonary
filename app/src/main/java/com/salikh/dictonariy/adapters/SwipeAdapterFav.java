package com.salikh.dictonariy.adapters;

import static com.salikh.dictonariy.activity.FavouriteActivity.chekViziblFav;

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
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.salikh.dictonariy.R;
import com.salikh.dictonariy.cache.MemoryHelper;
import com.salikh.dictonariy.database.DataBase;
import com.salikh.dictonariy.model.WordEngData;

import java.util.ArrayList;

public class SwipeAdapterFav extends RecyclerView.Adapter<SwipeAdapterFav.SwipeHolder> {


    private final Context context;
    private final ViewBinderHelper viewBinderHelper = new ViewBinderHelper();
    private ArrayList<WordEngData> wordEngData;


    public SwipeAdapterFav(Context context, ArrayList<WordEngData> wordEngData) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_fav_swipe, parent, false);
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


        holder.textFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("TAGaaa", wordEngData.get(position).getEng());
                Log.e("TAGaaa", wordEngData.get(position).getUzb());

                DataBase.getDataBase().insertWordDelete(wordEngData.get(position).getEng(), wordEngData.get(position).getUzb());

                DataBase.getDataBase().deleteWordFavouritiy(wordEngData.get(position).getId());

                DataBase.getDataBase().deleteWordInter(wordEngData.get(position));
                wordEngData.remove(wordEngData.get(position));
                notifyDataSetChanged();
                chekViziblFav();
            }
        });

    }


    @Override
    public int getItemCount() {
        return wordEngData.size();
    }

    public void clearData() {
        wordEngData.clear();
        notifyDataSetChanged();
    }

    class SwipeHolder extends RecyclerView.ViewHolder {

        private final TextView textEng;
        private final TextView textUzb;
        private final ImageView textFav;
        private final SwipeRevealLayout swipeRevealLayout;
        private final LinearLayout layout;

        public SwipeHolder(@NonNull View itemView) {
            super(itemView);
            textFav = itemView.findViewById(R.id.textDelete_fav);
            textEng = itemView.findViewById(R.id.textEng_fav);
            textUzb = itemView.findViewById(R.id.textUzb_fav);
            swipeRevealLayout = itemView.findViewById(R.id.swipeFav);
            layout = itemView.findViewById(R.id.border_fav);

            textFav.setImageResource(MemoryHelper.getHelpr().getDelete());
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
