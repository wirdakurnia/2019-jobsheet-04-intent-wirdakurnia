package com.example.wirdakurnia.intentlatihan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText namaText, alamatText, telpText;
    private Button inputButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaText = findViewById(R.id.namaText);
        alamatText = findViewById(R.id.alamatText);
        telpText = findViewById(R.id.telpText);
        inputButton = findViewById(R.id.buttonInput);

        inputButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        Bundle b = new Bundle();

        b.putString("nama", namaText.getText().toString());
        b.putString("alamat", alamatText.getText().toString());
        b.putString("notelp", telpText.getText().toString());

        intent.putExtras(b);

        startActivity(intent);
    }
}
