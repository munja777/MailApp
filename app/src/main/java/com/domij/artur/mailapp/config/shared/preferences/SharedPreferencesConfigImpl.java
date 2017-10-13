package com.domij.artur.mailapp.config.shared.preferences;


import android.content.SharedPreferences;
import android.widget.EditText;

import com.domij.artur.mailapp.R;

public class SharedPreferencesConfigImpl implements SharedPreferencesConfig {

    private static final String DEFAULT_EDIT_TEXT_KEY = "";

    @Override
    public void setSharedPreferences(SharedPreferences sharedPreferences, EditText loginEditText,
                                     EditText passwordEditText, EditText hostEditText,
                                     EditText portEditText, EditText mailToEditText) {

        setSingleSharedPreference(sharedPreferences, loginEditText, String.valueOf(R.string.LOGIN_EDIT_TEXT_KEY));
        setSingleSharedPreference(sharedPreferences, passwordEditText, String.valueOf(R.string.PASSWORD_EDIT_TEXT_KEY));
        setSingleSharedPreference(sharedPreferences, hostEditText, String.valueOf(R.string.HOST_EDIT_TEXT_KEY));
        setSingleSharedPreference(sharedPreferences, portEditText, String.valueOf(R.string.PORT_EDIT_TEXT_KEY));
//        setSingleSharedPreference(sharedPreferences, mailToEditText, String.valueOf(R.string.MAIL_TO_EDIT_TEXT_KEY));
    }

    @Override
    public void setSingleSharedPreference(SharedPreferences sharedPreferences, EditText editText, String editTextKey) {
        editText.setText(sharedPreferences.getString(editTextKey, DEFAULT_EDIT_TEXT_KEY));
    }

    @Override
    public void editSharedPreference(SharedPreferences sharedPreferences, String editTextKey, CharSequence charSequence) {
        sharedPreferences.edit().putString(editTextKey, charSequence.toString()).apply();
    }
}
