package com.example.nosmoking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating date format
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        tv = findViewById(R.id.tv);

        int seconds = 0, minutes = 0, hours = 0, days = 0;
        String s1 = "", s2 = "", s3 = "";

        try {
            Date date1 = sdf.parse("28.03.2023 04:51:48");
            // milliseconds
            long millisecondsFirstDate = date1.getTime();
            // Creating date from milliseconds using Date() constructor
            Date result = new Date(millisecondsFirstDate);
            // Formatting Date according to the given format to the string
            s1 = sdf.format(result);

            Date dateNow = new Date();
            long millisecondsDateNow = dateNow.getTime() + 4*3600*1000;
            Date result2 = new Date(millisecondsDateNow);
            s2 = sdf.format(result2);

            long milliseconds = millisecondsDateNow - millisecondsFirstDate;

            // 1000 миллисекунд = 1 секунда
            seconds = (int) (milliseconds / (1000));
            // 60 000 миллисекунд = 60 секунд = 1 минута
            minutes = (int) (milliseconds / (60 * 1000));
            // 3 600 секунд = 60 минут = 1 час
            hours = (int) (milliseconds / (60 * 60 * 1000));
            // 24 часа = 1 440 минут = 1 день
            days = (int) (milliseconds / (24 * 60 * 60 * 1000));

        } catch (Exception e) {
            e.printStackTrace();
        }

        String text = "Seconds: " + seconds + "\nMinutes: " + minutes +
                "\nHours: " + hours + "\nDays: " + days;
        tv.setText(s1 + "\n" + s2 + "\n" + text);
    }
}