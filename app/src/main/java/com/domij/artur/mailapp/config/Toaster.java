package com.domij.artur.mailapp.config;


import android.content.Context;
import android.widget.Toast;

public class Toaster {

    public void toast(Context context, String textToShow) {  Toast.makeText(context, textToShow, Toast.LENGTH_LONG).show();  }
}
