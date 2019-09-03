package com.mahugu.quotes.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahugu.quotes.R;
import com.mahugu.quotes.models.Quotes;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuoteListAdapter extends RecyclerView.Adapter<QuoteListAdapter.RestaurantViewHolder> {
    private ArrayList<Quotes> mQuotes = new ArrayList<>();
    private Context mContext;

    public QuoteListAdapter(Context context, ArrayList<Quotes> quotes) {
        mContext = context;
        mQuotes = quotes;
    }

    @Override
    public QuoteListAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_list_item, parent, false);
        RestaurantViewHolder viewHolder = new RestaurantViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(QuoteListAdapter.RestaurantViewHolder holder, int position) {
        holder.bindRestaurant(mQuotes.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuotes.size();
    }

    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.restaurantImageView) ImageView mRestaurantImageView;
        @BindView(R.id.restaurantNameTextView) TextView mNameTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;
        private Context mContext;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRestaurant(Quotes restaurant) {
            mNameTextView.setText(restaurant.getAuthor());
            mCategoryTextView.setText(restaurant.getQuote());
            mRatingTextView.setText(restaurant.getPermalink());
        }
    }
}























//public class QuoteListAdapter extends RecyclerView.Adapter<QuoteListAdapter.QuoteViewHolder> {
//    private ArrayList<Quotes> mQuotes = new ArrayList<>();
//    private Context mContext;
//
//    public QuoteListAdapter(Context context, ArrayList<Quotes> quotes) {
//        mContext = context;
//        mQuotes = quotes;
//    }
//
//    public class QuoteViewHolder extends RecyclerView.ViewHolder {
//        @BindView(R.id.restaurantImageView)
//        ImageView mRestaurantImageView;
//        @BindView(R.id.restaurantNameTextView)
//        TextView mNameTextView;
//        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
//        @BindView(R.id.ratingTextView) TextView mRatingTextView;
//
//        private Context mContext;
//
//        public RestaurantViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            mContext = itemView.getContext();
//        }
//
//        public void bindRestaurant(Quotes restaurant) {
//            mNameTextView.setText(restaurant.getAuthor());
//            mCategoryTextView.setText(restaurant.getQuote();
//            mRatingTextView.setText(restaurant.getPermalink());
//        }
//    }
//}
