package com.example.gaurang.hope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView textView;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void quest(View view)
    {

        String button_text;
        button_text = ((Button) view).getText().toString();
        if(button_text.equals("Movies")) {
            Intent intent = new Intent(this, quiz.class);
            startActivity(intent);
        }
        else if (button_text.equals("Food"))
        {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        }


            }
        }

