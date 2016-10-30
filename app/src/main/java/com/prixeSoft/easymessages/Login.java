package com.prixeSoft.easymessages;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.prixeSoft.easymessages.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * A login screen that offers login via username/password.
 */
public class Login extends AppCompatActivity  {

    private String username, port, address;


    // UI references.
    private AutoCompleteTextView mUsername, mAddress, mPort;
    private View mProgressView, mLoginFormView;
    File file;
    String fileName= "lastUserName.txt";
    FileOutputStream outputStream = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mUsername = (AutoCompleteTextView) findViewById(R.id.username);
        mAddress = (AutoCompleteTextView) findViewById(R.id.address);
        mPort = (AutoCompleteTextView) findViewById(R.id.port);
        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        try {
            loadLoginInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    attemptLogin();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
});
    }

    //saving login info ( on login )
    void saveNewLogin() throws IOException {

        file = new File(fileName);
        if(!file.exists()) {
            file.mkdir();
            outputStream = openFileOutput(fileName,  Context.MODE_PRIVATE);
            outputStream.write((mUsername.getText().toString()+"\n").getBytes());
            outputStream.write((mAddress.getText().toString()+"\n").getBytes());
            outputStream.write(mPort.getText().toString().getBytes());
            outputStream.flush();
            outputStream.close();
        }

    }

    void loadLoginInfo() throws IOException {

        FileInputStream fIn = openFileInput("lastUserName.txt");
        InputStreamReader isr = new InputStreamReader(fIn);
        BufferedReader buffreader = new BufferedReader(isr);
        mUsername.setText(buffreader.readLine());
        mAddress.setText( buffreader.readLine());
        mPort.setText(buffreader.readLine());
    }

    private void attemptLogin() throws IOException {

        // Reset errors.
        mUsername.setError(null);
        mPort.setError(null);
        mAddress.setError(null);

        // Store values at the time of the login attempt.
        username = mUsername.getText().toString().trim();
        port = mPort.getText().toString().trim();
        address= mAddress.getText().toString().trim();
        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.

        // Check for a valid username address.
        if (TextUtils.isEmpty(username)) {
            mUsername.setError(getString(R.string.error_field_required));
            focusView = mUsername;
            cancel = true;
        } else if (TextUtils.isEmpty(port)) {
            mPort.setError(getString(R.string.error_field_required));
            focusView = mPort;
            cancel = true;
        }else if(!TextUtils.isDigitsOnly(port)){
            mPort.setError("Port have to contain only digits");
            focusView = mPort;
            cancel = true;
        } else if (TextUtils.isEmpty(address)) {
            mAddress.setError(getString(R.string.error_field_required));
            focusView = mAddress;
            cancel = true;
         }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();

        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
           //  showProgress(true);
             saveNewLogin();
            Intent intent= new Intent(Login.this, Messaging.class);
            intent.putExtra("address",  address);
            intent.putExtra("port" ,    port );
            intent.putExtra("username", username );

            startActivity(intent);
        }
    }


    /**
     * Shows the progress UI and hides the login form.
     */
    private void showProgress(final boolean show) {
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }



}

