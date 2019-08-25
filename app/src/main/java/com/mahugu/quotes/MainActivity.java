package com.mahugu.quotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

//        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
//        Typeface opensans = Typeface.createFromAsset(getAssets(), "fonts/opensans_regular.ttf");
//        mAppNameTextView.setTypeface(opensans);

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
