package com.example.sony.jesquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    private int x;
    private int cheat_flag=0;
    private static final String TAG = "CheatActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Intent intent=getIntent();
        x=intent.getIntExtra("x",x);
        Log.d(TAG,"OnCreate"+x);
    }
    public void onCheatView(View v){

        cheat_flag=1;
        PrimeCheck p=new PrimeCheck();
        if(p.Check(x)){

            TextView cheat_view=(TextView)findViewById(R.id.answer);
            String s=x+getString(R.string.text_Prime);
            cheat_view.setText(s);
        }
        else{

            TextView cheat_view=(TextView)findViewById(R.id.answer);
            String s=x+getString(R.string.text_NotPrime);
            cheat_view.setText(s);
        }


    }
    public void onBackClick(View v){

        Intent ToMain=new Intent(getApplicationContext(),MainActivity.class);
        Log.d(TAG,"onBackClick");
        if(cheat_flag==1)
        {
            ToMain.putExtra("cheat_flag",1);
        }
        else{
            ToMain.putExtra("cheat_flag",0);
        }
        setResult(RESULT_OK,ToMain);
        finish();
    }



}
