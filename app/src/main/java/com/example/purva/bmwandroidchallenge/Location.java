package com.example.purva.bmwandroidchallenge;

import java.sql.Timestamp;
import java.util.Comparator;

/**
 * Created by purva on 4/14/18.
 */

public class Location {

    String id, name, address,arrivalTime;
    double logitude, latitude;

    public Location(String id, String name, double logitude, double latitude, String address, String arrivalTime) {
        this.id = id;
        this.name = name;
        this.logitude = logitude;
        this.latitude = latitude;
        this.address = address;
        this.arrivalTime = arrivalTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLogitude() {
        return logitude;
    }

    public void setLogitude(double logitude) {
        this.logitude = logitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public static Comparator<Location> locationNameComparator = new Comparator<Location>() {

        public int compare(Location s1, Location s2) {
            String locationName1 = s1.getName();
            String locationName2 = s2.getName();

            //ascending order
            return locationName1.compareTo(locationName2);

        }};

    public static Comparator<Location> locationArrivalTimeComparator = new Comparator<Location>() {

        public int compare(Location s1, Location s2) {
            String locationArrivalTime1 = s1.getArrivalTime().replaceAll("T", " ");
            String locationArrivalTime2 = s2.getArrivalTime().replaceAll("T", " ");

            //ascending order
            return Timestamp.valueOf(locationArrivalTime1).compareTo(Timestamp.valueOf(locationArrivalTime2));

        }};

    public static Comparator<Location> locationDistanceComparator = new Comparator<Location>() {

        float[] result;
        public int compare(Location s1, Location s2) {
            Double locationLatitude1 = Double.valueOf(s1.getLatitude());
            Double locationLongitude1 = Double.valueOf(s1.getLogitude());
            Double locationLatitude2 = Double.valueOf(s2.getLatitude());
            Double locationLongitude2 = Double.valueOf(s2.getLogitude());

            android.location.Location location1 = new android.location.Location("point A");
            location1.setLatitude(locationLatitude1);
            location1.setLongitude(locationLongitude1);
            android.location.Location location2 = new android.location.Location("point B");
            location1.setLatitude(locationLatitude2);
            location1.setLongitude(locationLongitude2);

            float distance = location1.distanceTo(location2);
            //ascending order
            return (int) distance;
        }};

}
