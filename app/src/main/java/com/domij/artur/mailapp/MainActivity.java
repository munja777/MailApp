package com.domij.artur.mailapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.domij.artur.mailapp.task.SendMailTask;
import com.domij.artur.mailapp.config.listener.EditTextListener;
import com.domij.artur.mailapp.config.shared.preferences.SharedPreferencesConfig;
import com.domij.artur.mailapp.config.shared.preferences.SharedPreferencesConfigImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferencesConfig sharedPreferencesConfig = new SharedPreferencesConfigImpl();
    EditTextListener editTextListener = new EditTextListener();

    @BindView(R.id.loginEditText)
    EditText loginEditText;

    @BindView(R.id.passwordEditText)
    EditText passwordEditText;

    @BindView(R.id.hostEditText)
    EditText hostEditText;

    @BindView(R.id.portEditText)
    EditText portEditText;

    @BindView(R.id.mailToEditText)
    EditText mailToEditText;

    @BindView(R.id.subjectEditText)
    EditText subjectEditText;

    @BindView(R.id.bodyEditText)
    EditText bodyEditText;

    @BindView(R.id.testConnectionButton)
    Button testConnectionButton;

    @BindView(R.id.putLastMailToButton)
    Button putLastMailToButton;

    @BindView(R.id.sendMailButton)
    Button sendMailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        sharedPreferencesConfig.setSharedPreferences(sharedPreferences, loginEditText, passwordEditText,
                hostEditText, portEditText, mailToEditText);
        editTextListener.setEditTextListeners(sharedPreferences, loginEditText, passwordEditText,
                hostEditText, portEditText, mailToEditText);
    }

    @OnClick(R.id.testConnectionButton)
    public void testConnection() {

    }

    @OnClick(R.id.putLastMailToButton)
    public void putLastMailTo() {
        sharedPreferencesConfig.setSingleSharedPreference(sharedPreferences, mailToEditText, String.valueOf(R.string.MAIL_TO_EDIT_TEXT_KEY));
    }

    @OnClick(R.id.sendMailButton)
    public void sendMail() {
        new SendMailTask().execute(this, loginEditText, passwordEditText, hostEditText, portEditText, mailToEditText, subjectEditText, bodyEditText);
    }
}
