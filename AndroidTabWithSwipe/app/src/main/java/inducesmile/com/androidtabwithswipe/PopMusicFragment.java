package inducesmile.com.androidtabwithswipe;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PopMusicFragment extends Fragment {


    private String htmlPageUrl = "https://www.hotslogs.com/Default";

    //String strom_bringer = "Gall 166 180 0.4 % 25.9 % -6.5 % Assassin Sustained Damage Галл,갈,加尔,Gal,加利";

    private TextView textviewHtmlDocument;
    private String htmlContentInStringFormat;
    private ArrayList<String> nameList = new ArrayList<String>();
    private ArrayList<String> tmpList = new ArrayList<String>();



    List<ItemObject> itemsz = new ArrayList<>();
    //String url = "http://www.yonhapnews.co.kr/bulletin/2017/01/26/0200000000AKR20170126105500005.HTML";
    ProgressDialog mProgressDialog;

    public PopMusicFragment() {

        //new Logo().execute();
        new JsoupAsyncTask().execute();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pop_music, container, false);
        GridView gridview = (GridView)view.findViewById(R.id.gridview);


        //List<ItemObject> allItems = getAllItemObject();
        List<ItemObject> allItems = itemsz;
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), allItems);
        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "Position: " + position, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    /*
    public static List<ItemObject> getAllItemObject(){
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject(R.drawable.milian,"Dip It Low", "JJY"));
        items.add(new ItemObject(R.drawable.ciara,"Ride", "J"));
        items.add(new ItemObject(R.drawable.gaga,"Paparazzi", "Lady Gaga"));
        items.add(new ItemObject(R.drawable.brown,"Forever", "Chris Brown"));
        items.add(new ItemObject(R.drawable.rihana,"Stay", "Rihanna"));
        items.add(new ItemObject(R.drawable.jason,"Marry me", "Jason Derulo"));
        items.add(new ItemObject(R.drawable.shakira,"Waka Waka", "Shakira"));
        items.add(new ItemObject(R.drawable.perry,"Dark Horse", "Katy Perry"));
        items.add(new ItemObject(R.drawable.milian,"Dip It Low", "Christina Milian"));
        items.add(new ItemObject(R.drawable.milian,"Dip It Low", "Christina Milian"));
        items.add(new ItemObject(R.drawable.milian,"Dip It Low", "Christina Milian"));

        return items;
    }
*/
    private class Logo extends AsyncTask<Void, Void, Void> {
        Bitmap bitmap;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            /*
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
            */
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                String url = "http://www.yonhapnews.co.kr/bulletin/2017/01/26/0200000000AKR20170126105500005.HTML";
                Document document = Jsoup.connect(url).get();
                Elements img = document.select("meta[name=image]");

                String imgSrc = img.attr("content");

                InputStream input = new java.net.URL(imgSrc).openStream();

                bitmap = BitmapFactory.decodeStream(input);

            }catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            //ImageView logoimg = (ImageView) findViewById(R.id.logo);
            //logoimg.setImageBitmap(bitmap);
            //mProgressDialog.dismiss();

                List<ItemObject> items = new ArrayList<>();
              //  itemsz.add(new ItemObject(bitmap,"AAAAAAAAAA", "AAAAAAAAAA"));
//                itemsz.add(new ItemObject(bitmap,"AAAAAAAAAA", "AAAAAAAAAA"));
//                itemsz.add(new ItemObject(bitmap,"AAAAAAAAAA", "AAAAAAAAAA"));


            super.onPostExecute(aVoid);
        }


    }

    private class JsoupAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document doc = Jsoup.connect(htmlPageUrl).get();
                Elements links = doc.select("tr[class]");

                int i = 0;
                for (Element link : links) {
                    htmlContentInStringFormat += (link.attr("abs:href") + "(" + link.text().trim() + ")\n");
                    //nameList.add("["+ i +"] " + (link.attr("abs:href") + "(" + link.text().trim() + ")"));
                    nameList.add((link.attr("abs:href")  + link.text().trim()));
                    i++;
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            /*
            strom_bringer = strom_bringer.replaceAll("\\% ","");
            nameList.add(strom_bringer);
            */

/*
            nameList.add(0, nameList.get(0).replaceAll("\\% ",""));
            String retStr = "";
            //String[] split = strom_bringer.split(" ");
            String[] split = nameList.get(0).split(" ");
            for( String oneStr : split){
                tmpList.add(oneStr);
                retStr += oneStr;
                retStr += "\n";
            }
*/
            //textviewHtmlDocument.setText(retStr);

            Hero Test_Check = new Hero(
                    nameList.get(0),
                    //tmpList.get(0),
                    1, 1, 1, 1, 1
/*
                    Integer.parseInt(tmpList.get(1)),
                    Integer.parseInt(tmpList.get(2)),
                    Float.parseFloat(tmpList.get(3)),
                    Float.parseFloat(tmpList.get(4)),
                    Float.parseFloat(tmpList.get(5))
*/
            );




            itemsz.add(new ItemObject(R.drawable.ubuntu_l,
                    Test_Check.getName(),
                    "GAL+JY"));




            super.onPostExecute(aVoid);
        }
    }












}


















