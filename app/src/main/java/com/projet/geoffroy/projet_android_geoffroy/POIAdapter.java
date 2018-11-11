package com.projet.geoffroy.projet_android_geoffroy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class POIAdapter extends BaseAdapter {
    List<POI> biblio;

    // LayoutInflater aura pour mission de charger notre fichier XML
    LayoutInflater inflater;

    private class ViewHolder {
        TextView tvType;
        TextView tvDisplay;
        TextView tvDistance;
        ImageView ivImage;
    }

    public POIAdapter (Context context, List<POI> objects) {
        inflater = LayoutInflater.from(context);
        this.biblio = objects;
    }

    @Override
    public View getView(int position , View convertView, ViewGroup parent){
        ViewHolder holder;

        if (convertView == null){
            Log.v("test","convertView is null");
            holder=new ViewHolder();
            convertView = inflater.inflate(R.layout.layoutitem,null);
            holder.tvType = (TextView) convertView.findViewById(R.id.type);
            holder.tvDisplay = (TextView) convertView.findViewById(R.id.display);
            holder.tvDistance = (TextView) convertView.findViewById(R.id.distance);
            holder.ivImage = (ImageView) convertView.findViewById(R.id.imageView3);
            convertView.setTag(holder);
        }
        else {
            Log.v("test", "convertView is not null");
            holder=(ViewHolder) convertView.getTag();
        }

        POI poi = biblio.get(position);
        holder.tvType.setText(poi.getType());
        holder.tvDisplay.setText(poi.getDisplay());
        holder.tvDistance.setText(poi.getDistance());
        Picasso.get().load(poi.getImage()).into(holder.ivImage);
        return convertView;
    }
    @Override
    public int getCount() {
        return biblio.size();
    }
    @Override
    public POI getItem(int position) {
        return biblio.get(position);
    }
    @Override
    public long getItemId(int position) { return position;
    }
}
