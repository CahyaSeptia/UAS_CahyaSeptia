package com.example.uas_cahyaseptia.tugas;


import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uas_cahyaseptia.R;

public class SMS extends Activity {

    private EditText etNoHp;
    private EditText etPesan;
    private CardView btnPesanManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        etNoHp = findViewById(R.id.et_hp);
        etPesan = findViewById(R.id.et_pesan);
        btnPesanManager = findViewById(R.id.smsManager);

        btnPesanManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kirimPesanManager();
            }
        });
    }

    private void kirimPesanManager() {
        Uri uri = Uri.parse("smsto:" + etNoHp.getText().toString());
        Intent smsManager = new Intent(Intent.ACTION_SENDTO, uri);
        smsManager.putExtra("sms_body", etPesan.getText().toString());
        try {
            startActivity(smsManager);
        } catch (Exception e) {
            Toast.makeText(SMS.this, "Gagal Mengirim SMS...",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}