package com.example.wirdakurnia.intentlatihan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView nama, alamat, telp;
    private Button button;
    private ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nama = findViewById(R.id.name_output);
        alamat = findViewById(R.id.alamat_output);
        telp = findViewById(R.id.telp_output);
        button = findViewById(R.id.buttonShare);

        Bundle b = getIntent().getExtras();
        nama.setText("Nama : " + b.getCharSequence("nama"));
        alamat.setText("Alamat : "+b.getCharSequence("alamat"));
        telp.setText("No Telp : "+b.getCharSequence("notelp"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = (nama.getText().toString())+"\n"+(alamat.getText().toString())+"\n"+(telp.getText().toString());
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });
    }

}
