package com.example.purva.bmwandroidchallenge;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.vision.text.Line;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by purva on 4/14/18.
 */

public class MyAdapterDistance extends RecyclerView.Adapter<MyAdapterDistance.MyViewHolder> {

    ArrayList<Location> locationList;
    Context context;
    Location location;

    public MyAdapterDistance(ArrayList<Location> locations, Context context) {
        this.locationList = locations;
        this.context = context;
    }

    @Override
    public MyAdapterDistance.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new MyAdapterDistance.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapterDistance.MyViewHolder holder, int position) {

        Collections.sort(locationList, Location.locationDistanceComparator);
        location = locationList.get(position);
        //locationList.sort(location.name);
        holder.id.setText("ID: "+location.getId());
        holder.name.setText("Name: "+location.getName());
        holder.longitude.setText("Longitude: "+location.getLogitude());
        holder.latitude.setText("Latitude: "+location.getLatitude());
        holder.adress.setText("Address: "+location.getAddress());
        holder.arivalTime.setText("Arrival Time: "+location.getArrivalTime());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putDouble("latitude",location.getLatitude());
                bundle.putDouble("longitude",location.getLogitude());
                i.putExtra("location",bundle);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        LinearLayout linearLayout;
        TextView id,name,longitude, latitude,adress, arivalTime;
        public MyViewHolder(View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.textViewID);
            name = itemView.findViewById(R.id.textViewName);
            longitude = itemView.findViewById(R.id.textViewLongitutude);
            latitude = itemView.findViewById(R.id.textView4Latitude);
            adress = itemView.findViewById(R.id.textViewAddress);
            arivalTime = itemView.findViewById(R.id.textViewArrivalTime);
            linearLayout = itemView.findViewById(R.id.linearLayout);


        }
    }
}
