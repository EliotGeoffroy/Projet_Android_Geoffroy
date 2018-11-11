package com.projet.geoffroy.projet_android_geoffroy;

import android.content.Intent;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class POIActivity extends ListActivity {

    List<POI> maBibliotheque = new ArrayList<POI>();
    private String TAG = "AffichagePOI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        String response = bundle.getString("response");
        Log.i(TAG,response.toString());
        try {
            JSONObject myJson= new JSONObject(response.toString());
            JSONArray myPlaces= myJson.getJSONArray("data");
            Log.i(TAG,myPlaces.toString());
            ListView myListView= getListView();
            this.RemplirLaBibliotheque(myPlaces);
            Log.i(TAG,maBibliotheque.toString());
            POIAdapter adapter=new POIAdapter(this, maBibliotheque);
            myListView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            Log.i(TAG, "Il y a une erreur !");
            e.printStackTrace();
        }
    }

    private void RemplirLaBibliotheque(JSONArray myPlaces){
        maBibliotheque.clear();
        try{
            Log.i(TAG,myPlaces.getJSONObject(0).getString("type") + maBibliotheque.toString());
            for (int i=0; i<myPlaces.length(); i++){
                String myImageUrl = "";
                Double myDistance = 0.0;

                if(myPlaces.getJSONObject(i).getString("type").contains("POI")){
                    Log.i(TAG,"POI" + maBibliotheque.toString());
                    if (myPlaces.getJSONObject(i).has("distance")){
                        myDistance= myPlaces.getJSONObject(i).getDouble("distance");
                    }
                    if (myPlaces.getJSONObject(i).getString("media").length()!=0 && myPlaces.getJSONObject(i).getString("media")!= null) {
                        myImageUrl= myPlaces.getJSONObject(i).getString("media");
                    }
                    else {
                        myImageUrl = "https://uaecm.fr/images/logos_assos/technopole_logo.png";
                    }
                    maBibliotheque.add(new POI(myPlaces.getJSONObject(i).getString("type"),myPlaces.getJSONObject(i).getString("display"),
                            myDistance, myImageUrl));
                }
                else if(myPlaces.getJSONObject(i).getString("type").contains("RESTAURANT")){
                    Log.i(TAG,"Restaurant" + maBibliotheque.toString());
                    if (myPlaces.getJSONObject(i).has("distance")){
                        myDistance= myPlaces.getJSONObject(i).getDouble("distance");
                    }                    if (myPlaces.getJSONObject(i).getString("media").length()!=0 && myPlaces.getJSONObject(i).getString("media")!= null) {
                        myImageUrl= myPlaces.getJSONObject(i).getString("media");
                    }
                    else {
                        myImageUrl = "https://uaecm.fr/images/logos_assos/technopole_logo.png";
                    }
                    maBibliotheque.add(new POI(myPlaces.getJSONObject(i).getString("type"),myPlaces.getJSONObject(i).getString("display"),
                            myDistance, myImageUrl));
                }
                else if(myPlaces.getJSONObject(i).getString("type").contains("HOTEL")){
                    Log.i(TAG,"Hotel" + maBibliotheque.toString());
                    if (myPlaces.getJSONObject(i).has("distance")){
                        myDistance= myPlaces.getJSONObject(i).getDouble("distance");
                    }
                    if (myPlaces.getJSONObject(i).getString("media").length()!=0 && myPlaces.getJSONObject(i).getString("media")!= null) {
                        myImageUrl= myPlaces.getJSONObject(i).getString("media");
                    }
                    else {
                        myImageUrl = "https://uaecm.fr/images/logos_assos/technopole_logo.png";
                    }
                    maBibliotheque.add(new POI(myPlaces.getJSONObject(i).getString("type"),myPlaces.getJSONObject(i).getString("display"),
                            myDistance, myImageUrl));
                }
                else if(myPlaces.getJSONObject(i).getString("type").contains("CITY")){
                    if (myPlaces.getJSONObject(i).has("distance")){
                        myDistance= myPlaces.getJSONObject(i).getDouble("distance");
                    }                    if (myPlaces.getJSONObject(i).getString("media").length()!=0 && myPlaces.getJSONObject(i).getString("media")!= null) {
                        myImageUrl= myPlaces.getJSONObject(i).getString("media");
                    }
                    else {
                        myImageUrl = "https://uaecm.fr/images/logos_assos/technopole_logo.png";
                    }
                    maBibliotheque.add(new POI(myPlaces.getJSONObject(i).getString("type"),myPlaces.getJSONObject(i).getString("display"),
                            myDistance, myImageUrl));
                }
            }
        }catch(JSONException e){
            Log.i(TAG, "Il y a une erreur !");
            e.printStackTrace();
        }
    }

}
