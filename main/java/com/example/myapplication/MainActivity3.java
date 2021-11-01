package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {
    FusedLocationProviderClient fusedLocationProviderClient;

    TextView tv1, tv2, tv3, tv4, tv5;

    String LocationMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // components of the view
        Button get_location = findViewById(R.id.get_location);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);

        Button send_location = findViewById(R.id.send_location);
        Button store_location = findViewById(R.id.store_location);

        // Initializing location provider
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        get_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // check permissions
                if (ActivityCompat.checkSelfPermission(MainActivity3.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    // if FINE_LOCATION permission is granted then get location
                    getLocation();
                } else {
                    // else request for location
                    ActivityCompat.requestPermissions(MainActivity3.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });

        send_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(MainActivity3.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    sendMessage();
                }
                else {
                    ActivityCompat.requestPermissions(MainActivity3.this, new String[] {Manifest.permission.SEND_SMS}, 100);
                }
            }
        });

        store_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ActivityCompat.checkSelfPermission(MainActivity3.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    saveLocation();
                }
                else {
                    ActivityCompat.requestPermissions(MainActivity3.this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
            }
        });
    }

    private void saveLocation() {
        try {
            File file = new File("/sdcard/test.txt");
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.append(LocationMessage);

            outputStreamWriter.close();
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Location Saved", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "Location Not Saved", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void sendMessage() {
        String PhoneNumber = findViewById(R.id.phone_number).toString().trim();

        if(!PhoneNumber.equals("") && !LocationMessage.equals("")) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(PhoneNumber, null, LocationMessage, null, null);
            Toast.makeText(getApplicationContext(), "message sent", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Unable to get location or Phone Number", Toast.LENGTH_LONG).show();
        }

    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<Location> task) {
                // init location
                Location location = task.getResult();
                if (location != null) {
                    try {
                        // init geocoder
                        Geocoder geocoder = new Geocoder(MainActivity3.this, Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                        tv1.setText("Latitude: " + addresses.get(0).getLatitude());
                        tv2.setText("Longitude: " + addresses.get(0).getLongitude());
                        tv3.setText("Country Name: " + addresses.get(0).getCountryName());
                        tv4.setText("Country Code: " + addresses.get(0).getCountryCode());
                        tv5.setText("Locality: " + addresses.get(0).getLocality());

                        LocationMessage = "Latitude: " + addresses.get(0).getLatitude() + "\n" +
                                "Longitude: " + addresses.get(0).getLongitude() + "\n" +
                                "Country Name: " + addresses.get(0).getCountryName() + "\n" +
                                "Country Code: " + addresses.get(0).getCountryCode() + "\n" +
                                "Locality: " + addresses.get(0).getLocality() + "\n";

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}