package com.mahugu.quotes;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuotesActivity extends AppCompatActivity {

    @BindView(R.id.quoteTextView) TextView mQuoteTextView;
    @BindView(R.id.listView) ListView mListView;


    private String[] quotes = new String[] {"Just in a professional world sometimes a phone call is definitely more meaningful than a text"
            ,"I like to swim a few times a week. It's relaxing, and no one can call, email, or text me while I'm in the pool",
            "Music is the melody whose text is the world", "Compare sending someone a text message and getting a love letter delivered by carrier pigeon. No contest",
            };

    private String[] author = new String[] {"Justin Lake", "Pauline Jane", "Jack Bauer", "Brenda Jameson"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        ButterKnife.bind(this);

        QuotesArrayAdapter adapter = new QuotesArrayAdapter(this, android.R.layout.simple_list_item_1, quotes, author);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mQuoteTextView.setText("Here are all the Available Quotes: " + location);

        mQuoteTextView = (TextView) findViewById(R.id.quoteTextView);
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(adapter);



        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(QuotesActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });


    }
}
