package com.example.sony.jesquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView t;
    private int x;
    static int hintact = 0;
    static int cheatact=2;
    private int cheat_set=0;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
        t=(TextView) findViewById(R.id.question);
            Rand r=new Rand();
            x=r.rRand(1,1000);
            String s=Integer.toString(x)+getString(R.string.text_mainQuestion);
            t.setText(s);


    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

    public void onCorrectClick(View v){
        Log.d(TAG,"onCorrectClick");
        t=(TextView) findViewById(R.id.question);
        String value = t.getText().toString();
        value = value.trim().replaceAll("[^0-9]","|").replaceAll("(\\D)\\1+","$1");
        String values[] = value.trim().split("\\|");
        int intValues[] = new int[values.length];
        for(int i = 0; i < values.length; i ++){
            intValues[i] = Integer.parseInt(values[i]);
        }
        PrimeCheck p=new PrimeCheck();
        int number = intValues[0];
        if(p.Check(number)){


            CharSequence text = "Smart!!";
            if(cheat_set==0){
                Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"You have Cheated",Toast.LENGTH_SHORT).show();
            }

        }
        else
        {

            CharSequence textTryAgain = "Try Again!!";
            Toast.makeText(this,textTryAgain,Toast.LENGTH_SHORT).show();



        }




    }
    public void onIncorrectClick(View v){
        Log.d(TAG,"onIncorrectClick");
        t=(TextView) findViewById(R.id.question);
        String value = t.getText().toString();
        value = value.trim().replaceAll("[^0-9]","|").replaceAll("(\\D)\\1+","$1");
        String values[] = value.trim().split("\\|");
        int intValues[] = new int[values.length];
        for(int i = 0; i < values.length; i ++){
            intValues[i] = Integer.parseInt(values[i]);
        }
        PrimeCheck p=new PrimeCheck();
        int number = intValues[0];
        if(p.Check(number)){

            Context context = getApplicationContext();
            CharSequence text = "Try Again!!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();



        }
        else
        {

            if(cheat_set==0){
                Toast.makeText(this,"Smart!",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,"You have Cheated",Toast.LENGTH_SHORT).show();
            }



        }

    }


    public void onNextClick(View v){
        cheat_set=0;
        Log.d(TAG,"onNextClick");
        Rand r=new Rand();
        x=r.rRand(1,1000);
        t=(TextView) findViewById(R.id.question);
        String s=Integer.toString(x)+" is a Prime Number";
        t.setText(s);

    }

    @Override
     protected void onActivityResult(int requestcode,int resultcode,Intent data){

        Log.d(TAG,"OnActivityResult");
        if(requestcode==hintact){
            if(resultcode==RESULT_OK){
                int hint_flag=data.getIntExtra("hint_flag",0);
                if(hint_flag==1){

                    Toast.makeText(this,"Saw Hint",Toast.LENGTH_SHORT).show();
                }




            }
        }
        else if(requestcode==cheatact){

            if(resultcode==RESULT_OK){
                int cheat_flag=data.getIntExtra("cheat_flag",0);
                if(cheat_flag==1){
                    cheat_set=1;
                    Toast.makeText(this,"Cheated",Toast.LENGTH_SHORT).show();

                }


            }


        }

        }


    public void onHintClick(View v){
        Log.d(TAG,"onHintClick");
        Intent ToHint=new Intent(MainActivity.this,Hint_Activity.class);

        startActivityForResult(ToHint,hintact);
    }
    public void onCheatClick(View v){
        Log.d(TAG,"onCheatClick");
        Intent ToCheat=new Intent(MainActivity.this,CheatActivity.class);
        ToCheat.putExtra("x",x);
        startActivityForResult(ToCheat,cheatact);

    }



}
