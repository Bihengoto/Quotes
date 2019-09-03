package com.mahugu.quotes.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mahugu.quotes.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.button) Button mbutton;
    @BindView(R.id.quoteEditText) EditText mQuoteEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mQuoteEditText = (EditText) findViewById(R.id.quoteEditText);
        mbutton = (Button) findViewById(R.id.button);

        mbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mbutton) {
            String location = mQuoteEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, QuotesActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}
