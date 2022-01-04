package com.example.preparation;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.FileUriExposedException;
import android.telephony.SmsManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Locale;

public class LocationSDCardSMS extends AppCompatActivity {
    String LocationMessage;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_sdcard_sms);
        findViewById(R.id.bt_gps).setOnClickListener(view -> getLocation());
        findViewById(R.id.bt_send).setOnClickListener(view -> sendLocation());
        findViewById(R.id.bt_save).setOnClickListener(view -> saveLocation());
        findViewById(R.id.bt_reset).setOnClickListener(view -> resetLocation());
        findViewById(R.id.bt_read).setOnClickListener(view -> readLocation());
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void saveLocation() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            try {
                TextView tv = findViewById(R.id.tv_gps);

                File file = new File("/sdcard/test.txt");
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.append(LocationMessage);

                outputStreamWriter.close();
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(), "Location Saved", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void resetLocation() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            File file = new File("/sdcard/test.txt");
            try {
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.append(" ");

                outputStreamWriter.close();
                fileOutputStream.close();
                Toast.makeText(getApplicationContext(), "Location Reset", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else {
            requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void readLocation() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            String s = "";
            try {
                File file = new File("/sdcard/test.txt");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while(line!=null)
                {
                    s += line + "\n";
                    line = br.readLine();
                }
                Toast.makeText(getApplicationContext(), "read",Toast.LENGTH_LONG).show();
            }
            catch (IOException e) {
                Toast.makeText(getApplicationContext(), "error",Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
            finally {
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
        }
        else {
            requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void sendLocation() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            SmsManager smsManager = SmsManager.getDefault();
            TextView tv = findViewById(R.id.tv_gps);
            smsManager.sendTextMessage("9123539217", null, tv.getText().toString(), null, null);
        }
        else {
            requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 99);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getLocation() {
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getCurrentLocation(LocationRequest.PRIORITY_HIGH_ACCURACY, null).addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    TextView tv = findViewById(R.id.tv_gps);
                    Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        LocationMessage = "Latitude: " + addresses.get(0).getLatitude() + "\n" +
                                "Longitude: " + addresses.get(0).getLongitude() + "\n" +
                                "Country Name: " + addresses.get(0).getCountryName() + "\n" +
                                "Country Code: " + addresses.get(0).getCountryCode() + "\n" +
                                "Locality: " + addresses.get(0).getLocality() + "\n";
                        tv.setText(LocationMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}