package it.unimib.cheaptrip.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.unimib.cheaptrip.R;
import it.unimib.cheaptrip.adapter.PopularDirectionsFromFavoriteListViewArrayAdapter;
import it.unimib.cheaptrip.model.PopularDirectionsFromFavorite;
import it.unimib.cheaptrip.model.PopularDirectionsFromFavorite_Response;


/**
 * A fragment representing a list of Items.
 */
public class PopularDestinationsFragment extends Fragment {

    private static final String TAG = "PopularDestinationsFragment";
    private PopularDirectionsFromFavorite[] mPopularDirectionsFromFavoriteArray;
    private List<PopularDirectionsFromFavorite> mPopularDirectionsFromFavoriteList;

    private List<PopularDirectionsFromFavorite> mPopularDirectionsFromFavoriteListWithJsonReader;
    private List<PopularDirectionsFromFavorite> mPopularDirectionsFromFavoriteListWithJsonObjectArray;
    private List<PopularDirectionsFromFavorite> mPopularDirectionsFromFavoriteListWithGson;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PopularDestinationsFragment() {
    }


    @SuppressLint("LongLogTag")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPopularDirectionsFromFavoriteArray = new PopularDirectionsFromFavorite[20];
        mPopularDirectionsFromFavoriteList = new ArrayList<>();

        for (int i = 0; i < mPopularDirectionsFromFavoriteArray.length; i++) {
            mPopularDirectionsFromFavoriteArray[i] = new PopularDirectionsFromFavorite(
                    "Origin", null, null, null, null, null, null, null, null);
            mPopularDirectionsFromFavoriteList.add(new PopularDirectionsFromFavorite(
                    "Origin", null, null, null, null, null, null, null, null));
        }

        PopularDirectionsFromFavorite_Response newsResponseWithGson = readJsonFileWithGson();


        mPopularDirectionsFromFavoriteListWithGson = newsResponseWithGson.getOptions();


        for (int i = 0; i < mPopularDirectionsFromFavoriteListWithGson.size(); i++) {
            Log.d(TAG, "Gson: " + mPopularDirectionsFromFavoriteListWithGson.get(i));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.popular_directions_from_favorite_list_item, container, false);

        ListView mListViewCountryNews = view.findViewById(R.id.list_popular_destination);

        /* ###### Examples with ListView and different types of Adapters ###### */




        // Custom Adapter that extends ArrayAdapter

        PopularDirectionsFromFavoriteListViewArrayAdapter optionsPopularDirectionsFromFavoriteListViewArrayAdapter =
                new PopularDirectionsFromFavoriteListViewArrayAdapter(requireContext(), R.layout.popular_directions_from_favorite_list_item, mPopularDirectionsFromFavoriteArray);

        mListViewCountryNews.setAdapter(optionsPopularDirectionsFromFavoriteListViewArrayAdapter);

        mListViewCountryNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "onItemClick: " + mPopularDirectionsFromFavoriteArray[i]);
            }
        });



        return view;
    }


                        /*{
                            "success": true,
                            "data": {
                                "MOW": {
                                    "origin": "MIL",
                                    "destination": "MOW",
                                    "price": 263,
                                    "airline": "S7",
                                    "flight_number": 3634,
                                    "departure_at": "2021-12-15T13:55:00+01:00",
                                    "return_at": "2021-12-15T22:30:00+03:00",
                                    "transfers": 0,
                                    "expires_at": "2021-12-08T15:48:37Z"
                                }, ....
                        * */

    private PopularDirectionsFromFavorite_Response readJsonFileWithGson() {

        PopularDirectionsFromFavorite_Response popularDirectionsFromFavorite_Response = null;

        try {
            InputStream inputStream = getActivity().getAssets().open("The popular directions from a city.json");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            popularDirectionsFromFavorite_Response = new Gson().fromJson(bufferedReader, PopularDirectionsFromFavorite_Response.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return popularDirectionsFromFavorite_Response;
    }
}
