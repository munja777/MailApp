package com.domij.artur.mailapp.config.shared.preferences;


import android.content.SharedPreferences;
import android.widget.EditText;

public interface SharedPreferencesConfig {

    void setSharedPreferences(SharedPreferences sharedPreferences, EditText loginEditText,
                                     EditText passwordEditText, EditText hostEditText,
                                     EditText portEditText, EditText mailToEditText);

    void setSingleSharedPreference(SharedPreferences sharedPreferences, EditText editText, String editTextKey);

    void editSharedPreference(SharedPreferences sharedPreferences, String editTextKey, CharSequence charSequence);
}
