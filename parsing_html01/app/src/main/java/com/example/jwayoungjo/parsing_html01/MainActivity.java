package com.example.jwayoungjo.parsing_html01;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String htmlPageUrl = "https://www.hotslogs.com/Default";
    private TextView textviewHtmlDocument;
    private String htmlContentInStringFormat;
    private ArrayList<String> nameList = new ArrayList<String>();
    private ArrayList<String> tmpList = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviewHtmlDocument = (TextView)findViewById(R.id.textView);
        textviewHtmlDocument.setMovementMethod(new ScrollingMovementMethod());

        Button htmlTitleButton = (Button)findViewById(R.id.button);
        htmlTitleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsoupAsyncTask jsoupAsyncTask = new JsoupAsyncTask();
                jsoupAsyncTask.execute();
            }
        });
    }


    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Document doc = Jsoup.connect(htmlPageUrl).get();
                Elements links = doc.select("img[src]");

                for (Element link : links) {
                    htmlContentInStringFormat += (link.attr("abs:src") + link.text().trim() + "\n");
                }
            }
            /*
            try {
                Document doc = Jsoup.connect(htmlPageUrl).get();
                Elements links = doc.select("tr[class]");

                int i = 0;
                for (Element link : links) {
                    htmlContentInStringFormat += (link.attr("abs:href") + "(" + link.text().trim() + ")\n");
                    nameList.add("JY ["+ i +"] " + (link.attr("abs:href") + "(" + link.text().trim() + ")"));
                    i++;
                }
            }*/
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //super.onPostExecute(aVoid);
            textviewHtmlDocument.setText(htmlContentInStringFormat);
            //textviewHtmlDocument.setText(nameList.get(nameList.size() - 1));
            //Log.d("StormBRINGER", nameList.get(nameList.size() - 1));
        }
    }

}
