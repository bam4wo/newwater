package com.example.trywater;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edmonth;
    private EditText ednext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edmonth = findViewById(R.id.editText);
        ednext = findViewById(R.id.editText2);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void enter(View view){
        String month = edmonth.getText().toString();
        float fee = 0;
        if(!TextUtils.isEmpty(month)){
            int mon = Integer.parseInt(month);
            if(mon>=1 && mon<=10){
                fee = mon*7.35f;
            }else if (mon>=11 && mon<=30){
                fee = mon*9.45f-21;
            }else if (mon>=31 && mon<=50){
                fee = mon*11.55f-84;
            }else if (mon>=51){
                fee = mon*12.075f-110.25f;
            }
            Intent intent = new Intent(this,ResultActivity.class);
            intent.putExtra("FEE",fee);
            startActivity(intent);
            /*new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用"+fee)
                    .setPositiveButton("ok",null)
                    .show();*/
        }else {
            String next = ednext.getText().toString();
            if (!TextUtils.isEmpty(next)){
                int nextt = Integer.parseInt(next);
                if(nextt>=1 && nextt<=20){
                    fee = nextt*7.35f;
                }else if (nextt>=21 && nextt<=60){
                    fee = nextt*9.45f-42;
                }else if (nextt>=61 && nextt<=100){
                    fee = nextt*11.55f-168;
                }else if (nextt>=101){
                    fee = nextt*12.075f-220.5f;
                }
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("隔月抄表費用")
                        .setMessage("費用"+fee)
                        .setPositiveButton("ok",null)
                        .show();
            }
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
