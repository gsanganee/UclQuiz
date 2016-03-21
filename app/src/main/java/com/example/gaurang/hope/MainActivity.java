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

    @Override
    //setting up the on create method for the main activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //using "quizee" as the "on click" method for both the "Movies" button and the "food" Button
    public void quizee(View view)
    {
    //Setting up "button_text" to get the text from the buttons and change it into a string
        String button_text;
        button_text = ((Button) view).getText().toString();
    //If else statement to move to new activities (the two separate quiz')(quiz is Movies and Main2Activity is Food)
        if(button_text.equals("Movies")) {
            Intent intent = new Intent(this, quiz.class);
            startActivity(intent);
        }
        else if (button_text.equals("Food"))
        {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        }
        else if (button_text.equals("Science"))
        {
            Intent intent = new Intent(this, Main3Activity.class);
            startActivity(intent);
        }


            }
        }

