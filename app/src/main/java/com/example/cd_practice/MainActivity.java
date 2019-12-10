package com.example.cd_practice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author oriin
 */
public class MainActivity extends AppCompatActivity {
LinearLayout ll;
Button rgb,all_colors,reset,text_toast;
AlertDialog.Builder adb;
final String[] color = {"Red","Green","Blue"};
    final String[] rdc = {"Random Color"};
Random rd;
int colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll  =(LinearLayout) findViewById(R.id.ll);
    }

    /**
     * @param view
     */
    public void rgb(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("pick a color");
        adb.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setItems(color, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which==0)
                    ll.setBackgroundColor(Color.RED);
                if (which==1)
                    ll.setBackgroundColor(Color.GREEN);
                if (which==2)
                    ll.setBackgroundColor(Color.BLUE);
            }
        });
        AlertDialog adb1 =adb.create();
        adb1.show();
    }

    public void all_colors(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setMessage("Random color");
        adb.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                rd = new Random();
                colors = Color.argb(255,rd.nextInt(256),rd.nextInt(256),rd.nextInt(256));
                ll.setBackgroundColor(colors);
            }
        });
        AlertDialog adb1 =adb.create();
        adb1.show();
    }

    public void reset(View view) {
        ll.setBackgroundColor(Color.WHITE);
    }

    public void text_toast(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Edit Text Widget");
        final EditText et = new EditText(this);
        et.setHint("Type text here");
        adb.setView(et);
        adb.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb.setPositiveButton("Copy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = et.getText().toString();
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog adb1 =adb.create();
        adb1.show();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     *
     * @param item
     * @return checks if "credits" button is pressed and if so moves to "credits" activity
     */
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if (id==R.id.credits)
        {
            Intent si = new Intent(this,Credits.class);
            startActivity(si);
        }
        return true;
    }

}
