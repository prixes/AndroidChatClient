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
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    Button btnOnline,btnPlus ;
    ProgressDialog dialog;
    AlertDialog.Builder dlgAlert;

    //new stuff !!!
    Button btnChat[] = new Button[6];
    String chatLog[] =      {"","","","","",""}; //x6 strings
    String currentChats[] = {"general","","","","",""}; //x6 strings
    String chatWith;
    String chatPrefix = "";
    int curChat= 0;
    int openChats= 0;
    //new stuff !!!


    String username, address, port;
    private static String fileName="chatLog.txt";
    File file;
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
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnChat[0] = (Button) findViewById(R.id.btnGeneral);
        btnChat[1] = (Button) findViewById(R.id.btnChat1);
        btnChat[2] = (Button) findViewById(R.id.btnChat2);
        btnChat[3] = (Button) findViewById(R.id.btnChat3);
        btnChat[4] = (Button) findViewById(R.id.btnChat4);
        btnChat[5] = (Button) findViewById(R.id.btnChat5);

        ScrollView sv = (ScrollView)findViewById(R.id.scroll);
        sv.setEnabled(false);

        // Retrieving the information from loginActivity
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


        // Connecting dialog
        dialog=new ProgressDialog(this);
        dialog.setMessage("Connecting");
        dialog.setCancelable(false);
        dialog.setInverseBackgroundForced(false);
        dlgAlert  = new AlertDialog.Builder(this);

        // Error alert box
        dlgAlert.setTitle("Connection problem please try again !");
        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        dlgAlert.setCancelable(true);

        //connecting dialog show
        //dialog.show();  making problems :/
        try {                    //Prepare file of last messages received
            checkLogFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Ready to start connection to server
        client = new Client( address, Integer.parseInt(port) ,username,this);
        client.start();

        BtnListeners btnListeners= new BtnListeners(this);

        // Listeners that require client class
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(! msgLine.getText().toString().isEmpty() ){
                    client.sendMessage( chatPrefix + msgLine.getText().toString());
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



// Delete tab actions
    void deleteChatTab(int i)
    {
        for(int n=i;n<openChats;n++) {
            chatLog[n]=chatLog[n+1];
            btnChat[n].setText(currentChats[n+1]);
            currentChats[n]=currentChats[n+1];
        }

        if(curChat>i) btnChat[curChat-1].callOnClick(); else btnChat[curChat].callOnClick();
        chatWith=currentChats[curChat];
        btnChat[openChats].setVisibility(View.GONE);
        chatLog[openChats]= "";
        currentChats[openChats]="";
        openChats -=1;
    }

// Start new chat tab open
    void startNewChat(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("You want to chat with:");
        AlertDialog dialog;

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT );
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chatWith= input.getText().toString();

                if(chatWith.contains(" ")) { errorDisplay("Invalid username (contain spaces) !"); return; }
                if(openChats == 5) { errorDisplay("" + "Maximum chat tabs reached (5 private chats) !"); return; }
                for(int i=openChats;i>0;i--) if(chatWith.equals(currentChats[i])) { btnChat[i].callOnClick(); return;}

                openChats += 1;
                currentChats[openChats]=chatWith;
                btnChat[openChats].setVisibility(View.VISIBLE);
                btnChat[openChats].setText(chatWith);
                chatPrefix = "/w " + chatWith + " ";
                btnChat[curChat].setBackgroundResource( R.drawable.button_background);
                btnChat[openChats].setBackgroundResource(R.drawable.button_on_foreground);
                curChat=openChats;
                chatLog[openChats]="";
                txtChatLog.setText("");
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialog = builder.create();
        dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        builder.show();

        input.requestFocus();
    }

    // When user PM some one througth general chat "/w name message"
    void startNewChat(String name) {
        for(int i = openChats;i>0 ; i--)
            if(btnChat[i].getText().equals(name)) return;
        if(openChats<5) {
            openChats+=1;
            chatWith=name;
            btnChat[openChats].setVisibility(View.VISIBLE);
            btnChat[openChats].setText(chatWith);
            btnChat[openChats].setBackgroundResource(R.drawable.button_on_new_chat);
            openChats += 1;
        }
    }

    // Check if there is log file in the system
    void checkLogFile() throws IOException {
        file = new File(fileName);
        if(!file.exists()) {
            file.mkdir();
        }
            outputStream = openFileOutput(fileName,  MODE_APPEND);
    }

    // Loading the chat file
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
        chatLog[0]=datax.toString();
        txtChatLog.append(chatLog[0]) ;
    }

    // All the notification logic
    public void triggerNotification(String from ,String message) {
        if(this.hasWindowFocus()) return;
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.card)
                        .setContentTitle(from)
                        .setContentText(message);
                if(from.equals("")) mBuilder.setContentTitle("General chat");
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }

    // Error display feature
    void errorDisplay(String error){
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(error)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    //Its called by the client class when receives information from the server appending it to
    void append(String str) throws IOException {
            final int scrollAmount = txtChatLog.getLayout().getLineTop(txtChatLog.getLineCount()) - txtChatLog.getHeight();
            if (scrollAmount > 0)
                txtChatLog.scrollTo(0, scrollAmount);

        //save chat message on local storage
        outputStream.write(str.getBytes());
        outputStream.flush();
    }

}
