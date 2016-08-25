package com.example.sony.jesquiz;

/**
 * Created by SONY on 8/13/2016.
 */
public class PrimeCheck {

    public Boolean Check(int n){

        int i,m=0,flag=0;
        m=n/2;
        for(i=2;i<=m;i++){
            if(n%i==0){
               // System.out.println("Number is not prime");
                flag=1;
                break;
            }
        }
        if(flag==0)
            return true;
        else
            return false;





    }

}
