package com.domij.artur.mailapp.config.listener;


import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.domij.artur.mailapp.R;
import com.domij.artur.mailapp.config.shared.preferences.SharedPreferencesConfig;
import com.domij.artur.mailapp.config.shared.preferences.SharedPreferencesConfigImpl;

public class EditTextListener {

    public void setEditTextListeners(SharedPreferences sharedPreferences, EditText loginEditText,
                                     EditText passwordEditText, EditText hostEditText,
                                     EditText portEditText, EditText mailToEditText) {
        setSingleEditTextListener(sharedPreferences, loginEditText, String.valueOf(R.string.LOGIN_EDIT_TEXT_KEY));
        setSingleEditTextListener(sharedPreferences, passwordEditText, String.valueOf(R.string.PASSWORD_EDIT_TEXT_KEY));
        setSingleEditTextListener(sharedPreferences, hostEditText, String.valueOf(R.string.HOST_EDIT_TEXT_KEY));
        setSingleEditTextListener(sharedPreferences, portEditText, String.valueOf(R.string.PORT_EDIT_TEXT_KEY));
        setSingleEditTextListener(sharedPreferences, mailToEditText, String.valueOf(R.string.MAIL_TO_EDIT_TEXT_KEY));
    }

    private void setSingleEditTextListener(final SharedPreferences sharedPreferences, final EditText editText,
                                           final String editTextKey) {

        final SharedPreferencesConfig sharedPreferencesConfig = new SharedPreferencesConfigImpl();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                sharedPreferencesConfig.editSharedPreference(sharedPreferences, editTextKey, charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
//                sharedPreferencesConfigImpl.editSharedPreference(sharedPreferences, editTextKey, editable);
            }
        });
    }
}
