package com.example.gaurang.hope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Gaurang on 13/03/2016.
 */
public class result2 extends Activity{

    TextView tv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.result);
        tv = (TextView) findViewById(R.id.result);
        tv.setText("your final result is:" +Main2Activity.correct+"/"+Main2Activity.questions.length);


            }
        }
