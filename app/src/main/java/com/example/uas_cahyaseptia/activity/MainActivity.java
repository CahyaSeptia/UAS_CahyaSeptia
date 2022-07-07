package com.example.uas_cahyaseptia.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.uas_cahyaseptia.tugas.Asynctask;
import com.example.uas_cahyaseptia.tugas.Kamera;
import com.example.uas_cahyaseptia.adapter.ListAdapter;
import com.example.uas_cahyaseptia.tugas.Maps;
import com.example.uas_cahyaseptia.R;
import com.example.uas_cahyaseptia.tugas.SMS;
import com.example.uas_cahyaseptia.tugas.Network;
import com.example.uas_cahyaseptia.tugas.Sqlite;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    int[] iconList = new int[]{
            R.drawable.asyntask,
            R.drawable.camera,
            R.drawable.maps,
            R.drawable.sms,
            R.drawable.network,
            R.drawable.sqlite
    };

    String[] Headline = {
            "Asynctask",
            "Kamera",
            "Maps",
            "SMS",
            "Network",
            "Sqlite"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.List);
        ListAdapter listAdapter = new ListAdapter(this, iconList, Headline);
        lv.setAdapter(listAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), Asynctask.class);
                    startActivityForResult(intent, 0);
                } else if (position == 1) {
                    Intent intent = new Intent(view.getContext(), Kamera.class);
                    startActivityForResult(intent, 0);
                } else if (position == 2) {
                    Intent intent = new Intent(view.getContext(), Maps.class);
                    startActivityForResult(intent, 0);
                } else if (position == 3) {
                    Intent intent = new Intent(view.getContext(), SMS.class);
                    startActivityForResult(intent, 0);
                } else if (position == 4) {
                    Intent intent = new Intent(view.getContext(), Network.class);
                    startActivityForResult(intent, 0);
                } else if (position == 5) {
                    Intent intent = new Intent(view.getContext(), Sqlite.class);
                    startActivityForResult(intent, 0);
                }
            }
        });
    }
}