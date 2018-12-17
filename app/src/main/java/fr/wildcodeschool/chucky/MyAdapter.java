package fr.wildcodeschool.chucky;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import fr.wildcodeschool.chucky.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<String> mCatergory;
    // ajoute le constructeur initialisant la liste d'itinéraires
    public MyAdapter(ArrayList<String> category) {
        mCatergory = category;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false);

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        String category = mCatergory.get(position);
        holder.tvCategory.setText(category);
    }

    @Override
    public int getItemCount() {
        // modifie pour afficher le nombre d'itinéraires
        return mCatergory.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvCategory;

        public ViewHolder(View v) {
            super(v);
            this.tvCategory = v.findViewById(R.id.tv_category);
        }
    }


}
