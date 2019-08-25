package com.mahugu.quotes;

import android.content.Context;
import android.widget.ArrayAdapter;


public class QuotesArrayAdapter extends ArrayAdapter{
    private Context mContext;
    private String[] mQuotes;
    private String[] mAuthor;

    public QuotesArrayAdapter(Context mContext, int resource, String[] mQuotes, String[] mAuthor) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mQuotes = mQuotes;
        this.mAuthor = mAuthor;
    }

    @Override
    public Object getItem(int position) {
        String quotes = mQuotes[position];
        String author = mAuthor[position];
        return String.format("The Quote states: %s \nBy: %s", quotes, author);
    }

    @Override
    public int getCount() {
        return mQuotes.length;
    }
}
