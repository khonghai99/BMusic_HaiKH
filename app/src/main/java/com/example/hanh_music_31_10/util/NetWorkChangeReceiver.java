package com.example.hanh_music_31_10.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.hanh_music_31_10.ui.splashscreen.SplashScreenFragment;


public class NetWorkChangeReceiver extends BroadcastReceiver {
    SplashScreenFragment splashScreenFragment;
    @Override
    public void onReceive(Context context, Intent intent) {
        splashScreenFragment = new SplashScreenFragment();
        try{
            if (isOnline(context)){
                Log.i("HaiKH1", "onReceive: show");
            }else {
                Log.i("HaiKH1", "onReceive: hide");
                Toast.makeText(context, "disconnected", Toast.LENGTH_SHORT).show();
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    private boolean isOnline(Context context){
        try{
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }
}
