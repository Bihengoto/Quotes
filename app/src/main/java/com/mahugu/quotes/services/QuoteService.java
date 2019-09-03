package com.mahugu.quotes.services;

import com.mahugu.quotes.Constants;
import com.mahugu.quotes.models.Quotes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;


import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class QuoteService {
    public static void findQuote(String id, Callback callback) {

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.QUOTE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.QUOTE_AUTHOR_QUERY_PARAMETER, id);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Quotes> processResults(Response response){
        ArrayList<Quotes> quotes = new ArrayList<>();
        try{
            String jsonData = response.body().string();
            JSONObject quoteJSON = new JSONObject(jsonData);
            JSONArray authorJSON = quoteJSON.getJSONArray("author");

            if (response.isSuccessful()){
                for (int i = 0; i < authorJSON.length(); i++){
                    JSONObject myQuoteJSON = authorJSON.getJSONObject(i);
                    int id = myQuoteJSON.getInt("id");
                    String author = myQuoteJSON.getString("author");
                    String quote = myQuoteJSON.getString("quote");
                    String permalink = myQuoteJSON.getString("permalink");

                    Quotes quoteMe = new Quotes(id, author, quote, permalink);
                    quotes.add(quoteMe);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return quotes;
    }
}