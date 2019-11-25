package com.example.trywater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView fees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        Float fee = intent.getFloatExtra("FEE",-1);
        Log.d("ResultActivity",fee+"");
        fees = findViewById(R.id.fee);
        int c = (int)(fee+0.5f);
        fees.setText(c+"");

    }
}
