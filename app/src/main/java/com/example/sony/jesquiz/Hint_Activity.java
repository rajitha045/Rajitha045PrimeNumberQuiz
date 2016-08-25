package com.example.sony.jesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;

public class Hint_Activity extends AppCompatActivity {

    TextView hintshow;
    private int hint_flag=0;
    private static final String TAG = "Hint_Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint_);
    }
    public void onHintView(View v){
        hint_flag=1;
        System.out.println("The value******************"+hint_flag);
        String s="onHintView"+hint_flag;
        Log.d(TAG,s);
        hintshow=(TextView)findViewById(R.id.hinttext);
        hintshow.setText(R.string.text_hint);
    }
    public void onBackClick(View v){


        Intent ToMain=new Intent(getApplicationContext(),MainActivity.class);
        System.out.println("The value******************"+hint_flag);
        String s="onBackClick";
        Log.d(TAG,s);
        if(hint_flag==1){

            ToMain.putExtra("hint_flag",1);
        }
        else{

            ToMain.putExtra("hint_flag",0);
        }
        setResult(RESULT_OK,ToMain);
        finish();


    }
}
