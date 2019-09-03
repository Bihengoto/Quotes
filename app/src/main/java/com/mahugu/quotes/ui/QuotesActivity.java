package com.mahugu.quotes.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.mahugu.quotes.R;
import com.mahugu.quotes.adapter.QuoteListAdapter;
import com.mahugu.quotes.models.Quotes;
import com.mahugu.quotes.services.QuoteService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class QuotesActivity extends AppCompatActivity {
    public static final String TAG = QuotesActivity.class.getSimpleName();

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    private QuoteListAdapter mAdapter;

    public ArrayList<Quotes> quotes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        ButterKnife.bind(this);


        Intent intent = getIntent();
        String author = intent.getStringExtra("author");
        getQuote(author);

    }

    private void getQuote(String location) {
        final QuoteService quoteService = new QuoteService();
        quoteService.findQuote(location, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                quotes = quoteService.processResults(response);

                QuotesActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new QuoteListAdapter(getApplicationContext(), quotes);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager =
                                new LinearLayoutManager(QuotesActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }

        });
    }
}
