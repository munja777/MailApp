package com.domij.artur.mailapp.task;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;

import com.domij.artur.mailapp.config.Toaster;
import com.domij.artur.mailapp.sender.MailSender;


public class SendMailTask extends AsyncTask<Object, Void, Void> {

    private Toaster toaster = new Toaster();
    private static final String networkConnectionIsDisabled = "Network connection is disabled. First turn on";

//    private Context context;
//    private EditText loginEditText;
//    private EditText passwordEditText;
//    private EditText hostEditText;
//    private EditText portEditText;
//    private EditText mailToEditText;
//    private EditText subjectEditText;
//    private EditText bodyEditText;
//
//    public SendMailTask(Context context, EditText loginEditText, EditText passwordEditText,
//                        EditText hostEditText, EditText portEditText, EditText mailToEditText,
//                        EditText subjectEditText, EditText bodyEditText){
//        this.context = context;
//        this.loginEditText = loginEditText;
//        this.passwordEditText = passwordEditText;
//        this.hostEditText = hostEditText;
//        this.portEditText = portEditText;
//        this.mailToEditText = mailToEditText;
//        this.subjectEditText = subjectEditText;
//        this.bodyEditText = bodyEditText;
//    }



    @Override
    protected Void doInBackground(Object... params) {

        Context context = (Context) params[0];
        EditText loginEditText = (EditText) params[1];
        EditText passwordEditText = (EditText) params[2];
        EditText hostEditText = (EditText) params[3];
        EditText portEditText = (EditText) params[4];
        EditText mailToEditText = (EditText) params[5];
        EditText subjectEditText = (EditText) params[6];
        EditText bodyEditText = (EditText) params[7];

        if (MailSender.isOnline(context)) {
            MailSender.sendMail(loginEditText, passwordEditText, hostEditText, portEditText,
                    mailToEditText, subjectEditText, bodyEditText);
        } else {
            toaster.toast(context, networkConnectionIsDisabled);
        }
        return null;
    }
}