package it.unimib.cheaptrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import it.unimib.cheaptrip.R;
import it.unimib.cheaptrip.model.PopularDirectionsFromFavorite;



public class PopularDirectionsFromFavoriteListViewArrayAdapter  extends ArrayAdapter<PopularDirectionsFromFavorite> {

    private PopularDirectionsFromFavorite[] mPopularDirectionsFromFavorite;
    private int mLayout;

    public PopularDirectionsFromFavoriteListViewArrayAdapter(@NonNull Context context, int resource, @NonNull PopularDirectionsFromFavorite[] objects) {
        super(context, resource, objects);
        this.mPopularDirectionsFromFavorite = objects;
        this.mLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(mLayout, parent, false);
        }

        TextView textViewDestination = convertView.findViewById(R.id.textView_destination);
        TextView textViewAirline = convertView.findViewById(R.id.textView_airline);
        TextView textViewPrice = convertView.findViewById(R.id.textView_price);

        textViewDestination.setText(mPopularDirectionsFromFavorite[position].getDestination());
        textViewAirline.setText(mPopularDirectionsFromFavorite[position].getAirline());
        textViewPrice.setText(mPopularDirectionsFromFavorite[position].getPrice());

        return convertView;
    }
}


