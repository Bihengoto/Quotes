package com.mahugu.quotes.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahugu.quotes.R;
import com.mahugu.quotes.models.Quotes;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuoteListAdapter extends RecyclerView.Adapter<QuoteListAdapter.QuoteViewHolder> {
    private ArrayList<Quotes> mQuotes = new ArrayList<>();
    private Context mContext;

    public QuoteListAdapter(Context context, ArrayList<Quotes> quotes) {
        mContext = context;
        mQuotes = quotes;
    }

    @Override
    public QuoteListAdapter.QuoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.quote_list_item, parent, false);
        QuoteViewHolder viewHolder = new QuoteViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(QuoteListAdapter.QuoteViewHolder holder, int position) {
        holder.bindRead(mQuotes.get(position));
    }

    @Override
    public int getItemCount() {
        return mQuotes.size();
    }

    public class QuoteViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.quoteNameTextView) TextView mAuthorTextView;
        @BindView(R.id.quoteTextView) TextView mQuoteTextView;
        @BindView(R.id.quotesTextView) TextView mLinkTextView;

        private Context mContext;

        public QuoteViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRead(Quotes quote) {
            mAuthorTextView.setText(quote.getAuthor());
            mQuoteTextView.setText(quote.getQuote());
            mLinkTextView.setText(quote.getPermalink());
        }
    }
}






