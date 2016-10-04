package com.prixeSoft.easymessages;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import com.prixeSoft.easymessages.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by david on 11-Jun-16.
 */
public class Messaging extends Activity {
    private Client client;

    //GUI objects
    EditText msgLine;
    TextView txtChatLog, lblUsername;
    ImageButton btnSend;
    Button btnOnline;
    ProgressDialog dialog;
    AlertDialog.Builder dlgAlert;

    String username, address, port, mgsAppend;

    private static String fileName="chatLog.txt";
    private static String folder = "/EasyMsg/";
    FileOutputStream fos;
    File root,file;
    FileWriter writer;
    FileOutputStream outputStream = null;

    @Override
    public void onBackPressed()
    {
        client.logOut();
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        client.disconnect();
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialize GUI objects
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_screen);
        msgLine = (EditText) findViewById(R.id.msgLine);
        txtChatLog = (TextView) findViewById(R.id.txtChatLog);
        txtChatLog.setMovementMethod(new ScrollingMovementMethod());
        txtChatLog.setSelected(true);

        lblUsername = (TextView) findViewById(R.id.lblUsername);
        btnSend = (ImageButton) findViewById(R.id.btnSend);
        ScrollView sv = (ScrollView)findViewById(R.id.scroll);
        sv.setEnabled(false);

        //retrieving the information from loginActivity
        final Intent intent = getIntent();
        address  = intent.getExtras().getString("address");
        port     = intent.getExtras().getString("port");;
        username = intent.getExtras().getString("username");

        try {
            //check for chat log file
            checkLogFile();
            //load chat logs
            loadChatLog();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Connecting dialog
        dialog=new ProgressDialog(this);
        dialog.setMessage("Connecting");
        dialog.setCancelable(false);
        dialog.setInverseBackgroundForced(false);
        dlgAlert  = new AlertDialog.Builder(this);

        //Error alert box
        dlgAlert.setTitle("Connection problem please try again !");
        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dlgAlert.setCancelable(true);

        //connecting dialog show
        dialog.show();
        try {                    //Prepare file of last messages received
            checkLogFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Ready to start connection to server
        client = new Client( address, Integer.parseInt(port) ,username,this);
        client.start();


        //buttons onClick functions
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(! msgLine.getText().toString().isEmpty() ){
                client.sendMessage(msgLine.getText().toString());
                msgLine.setText("");
                }
            }});

        btnOnline = (Button) findViewById(R.id.btnOnline);
        btnOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                client.whoIsOnline();
            }});
    }

    void checkLogFile() throws IOException {
        file = new File(fileName);
        if(!file.exists()) {
            file.mkdir();
        }
            outputStream = openFileOutput(fileName,  MODE_APPEND);
    }

    public void loadChatLog() throws IOException {
        StringBuffer datax = new StringBuffer("");
            FileInputStream fIn = openFileInput ( "chatLog.txt" ) ;
            InputStreamReader isr = new InputStreamReader ( fIn ) ;
            BufferedReader buffreader = new BufferedReader ( isr ) ;
            String readString = buffreader.readLine ( ) ;
            while ( readString != null ) {
                datax.append(readString +"\n");
                readString = buffreader.readLine ( ) ;
            }
            isr.close ( ) ;
        //append all previous messages
        txtChatLog.append(datax.toString()) ;
    }


    //not implemented
    private void triggerNotification(String s) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.card)
                        .setContentTitle("EasyMsg")
                        .setContentText(s);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }



    //Its called by the client class when receives information from the server appending it to
    void append(String str) throws IOException {
            txtChatLog.append(str);
            final int scrollAmount = txtChatLog.getLayout().getLineTop(txtChatLog.getLineCount()) - txtChatLog.getHeight();
            if (scrollAmount > 0)
                txtChatLog.scrollTo(0, scrollAmount);

        //save chat message on local storage
        outputStream.write(str.getBytes());
        outputStream.flush();
    }

}
