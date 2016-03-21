package com.example.gaurang.hope;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Gaurang on 13/03/2016.
 */
public class quiz extends Activity {

    Button bt;
    TextView tv;
    RadioGroup rg;
    RadioButton r1,r2,r3;

    public static String questions []= {"1.\tWho played James Bond in 'Live and Let Die'?","2.\tWhat was the name of the boy in the Jungle Book?","3.\tWhat is the name of the actor who played the role of Harry Potter in the film series?","4.\tWhat was the name of Dorothy's dog in the Wizard of Oz?","5.\tWhich film does the song 'Circle of Life' come from?"};
    String answers []= {"Roger Moore","Mowgli","Daniel Radcliffe","Toto","The Lion King"};
    String opts []= {"Roger Moore", "Daniel Radcliff", "Idris Elba","Simba","Mowgli","Tarzan","Daniel Radcliffe","Rupert Grint","Alan Rickman", "Toto","Marley","Dodo","The Lion King","the Jungle Book","Into the wild"};

    int position=0;
    public static int correct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        tv=(TextView)findViewById(R.id.question);
        bt=(Button)findViewById(R.id.movebt);
        rg=(RadioGroup)findViewById(R.id.rg);
        r1=(RadioButton)findViewById(R.id.r1);
        r2=(RadioButton)findViewById(R.id.r2);
        r3=(RadioButton)findViewById(R.id.r3);

        tv.setText(questions[position]);
        r1.setText(opts[position]);
        r2.setText(opts[position+1]);
        r3.setText(opts[position+2]);



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton selectedans = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                String selectedansText = selectedans.getText().toString();
                if (selectedansText==answers[position]) {
                    correct++;
                }
                position++;
                if(position<questions.length){

                    tv.setText(questions[position]);
                    r1.setText(opts[position*3]);
                    r2.setText(opts[position*3+1]);
                    r3.setText(opts[position*3+2]);
                }else{

                    Intent in = new Intent(getApplicationContext(),result.class);
                    startActivity(in);

                }
            }
        });
    }
}
