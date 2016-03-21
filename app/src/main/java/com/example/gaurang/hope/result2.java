package com.example.gaurang.hope;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result2 extends Activity{
    //Sets up the TextView variable
    TextView tv;
    //Sets up the onCreate method and displays the result page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
    //Finds the TextView through the use of the ID
        tv = (TextView) findViewById(R.id.result);
    //Displays the text "your final result is" as well as the number of correct answers from the number of questions asked
        tv.setText("your final result is:" +Main2Activity.correct+"/"+Main2Activity.questions.length);
    //Sets up the "return to main menu" button
        Button btnBack = (Button) this.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new Button.OnClickListener() {
    //Begins the Main Activity again on click of the button (the menu page shows) and clears all previous activity
            public void onClick(View v) {
                Intent intent = new Intent(result2.this, MainActivity.class);
                startActivity(intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

            }
        }
