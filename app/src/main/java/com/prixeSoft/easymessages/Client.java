package com.prixeSoft.easymessages;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.support.v4.app.NotificationCompat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by david on 04-Jun-16.
 */
public class Client  {

    boolean online = false , getName=false;
    private String server, username,message,to,error;
    private int port;

    private Socket socket;
    private Messaging msgActivity ;

    Client(String server, int port, String username, Messaging msgActivity) {
        this.server = server;
        this.port = port;
        this.username = username;
        this.msgActivity=msgActivity;
    }

    //making new threads that would make socket-connection and listen from server for massages
    public void start() {
        Thread t=new SocketHandleThread();
        t.start();
    }


    //send messages to server
    void sendMessage(String msg) {
        ComProtobuf.msg.Builder prepMsg = ComProtobuf.msg.newBuilder();
    if(msg.startsWith("/w")) {  // It's PM
        message = msg.substring(3);
        to = message.substring(0,message.indexOf(" "));
        message = message.substring(message.indexOf(" ")+1);
        Client.this.msgActivity.startNewChat(to);
        prepMsg.setTypeValue(4);
        prepMsg.setFrom(username);
        prepMsg.setTo(to);
        prepMsg.setMessage(message);
    } else {  // Broadcast message
        prepMsg.setTypeValue(1);
        prepMsg.setFrom(username);
        prepMsg.setMessage(msg);
    }
        try {
            prepMsg.build().writeDelimitedTo(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //sending log out message to server
    void logOut() {
        try {
            ComProtobuf.msg.Builder writeName = ComProtobuf.msg.newBuilder();
            writeName.setTypeValue(2);
            writeName.build().writeDelimitedTo(socket.getOutputStream());
            // streamOutput.writeObject(new ChatMessage(ChatMessage.LOGOUT, ""));
        } catch (IOException e) {
            error= e.getMessage();
            errorAlert();
        }
    }

    //requesting who in online
    void whoIsOnline() {
        try {
            ComProtobuf.msg.Builder writeName = ComProtobuf.msg.newBuilder();
            writeName.setTypeValue(0);
            writeName.build().writeDelimitedTo(socket.getOutputStream());
            //streamOutput.writeObject(new ChatMessage(ChatMessage.ONLINEUSERS, ""));
        } catch (IOException e) {
            error= e.getMessage();
            errorAlert();
        }
    }

    //request the username that server recognize the user
    void whoAmI() {

        ComProtobuf.msg.Builder writeName = ComProtobuf.msg.newBuilder();
        writeName.setTypeValue(3);
        writeName.setTo(username);
        try {
            writeName.build().writeDelimitedTo(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            error= e.getMessage();
            errorAlert();
        }


    }

    //Disconnect implementation
    public void disconnect() {
        try {
            if (socket != null)
                socket.close();
        } catch (Exception e) {
            error= e.getMessage();
            errorAlert();
        }
    }



    //error alert box while in messaging activity
    void errorAlert(){
        msgActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                msgActivity.dialog.hide();
                msgActivity.dlgAlert.setMessage("Error:" + error);
                msgActivity.dlgAlert.show();
            }
        });
    }



    //thread that handles the messages
    class SocketHandleThread extends Thread {

        public void run() {
            //creating connection to server
            try {
                Client.this.socket = new Socket(server, port);
                online=true;
            } catch (IOException e) {
              error= e.getMessage();
                errorAlert();
                e.printStackTrace();
            }

            //initialize I/O streams
            if(online==true) {

                    //requesting verified username from the server
                    try {
                        whoAmI();

                        if (getName == false) {
                            getName = true;
                            //Read server confirmed username
                            ComProtobuf.msg readName = ComProtobuf.msg.parseDelimitedFrom(socket.getInputStream());

                            username = readName.getTo();
                            msgActivity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Client.this.msgActivity.lblUsername.setText(username);
                                }
                            });
                        }
                    } catch (IOException e1) {
                        error = "Error while getting username from server!";
                        errorAlert();
                        e1.printStackTrace();
                    }
                    // start thread for listening for messages
                    new ListenFromServer().start();
                }



            //removing the connection dialog
            msgActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    msgActivity.dialog.hide();
                }
            });
        }
    }


    //thread that reads the messages broadcasted by the server
    class ListenFromServer extends Thread {
        public void run() {
            while (true) {
                try {
                    final ComProtobuf.msg readMsg = ComProtobuf.msg.parseDelimitedFrom(socket.getInputStream());
                    if(readMsg != null ) {
                        final String msg = readMsg.getMessage();
                        if (readMsg.getType().getNumber() == 1) {
                            ; // its broadcast
                            Client.this.msgActivity.chatLog[0] += msg;
                            }else { //its pm
                           // Client.this.msgActivity.startNewChatWith(readMsg.getTo());
                            Client.this.msgActivity.chatLog[0] += msg;
                           for( int i=1;i<6; i++) {
                               if(Client.this.msgActivity.currentChats[i] != null)
                                   if(Client.this.msgActivity.currentChats[i].equals(readMsg.getFrom()) || Client.this.msgActivity.currentChats[i].equals(readMsg.getTo()))
                                       Client.this.msgActivity.chatLog[i] += msg;
                           }

                        }


                        msgActivity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        if(msgActivity.curChat==0){
                                            msgActivity.txtChatLog.setText(msgActivity.chatLog[0]);
                                        } else if (readMsg.getFrom().equals(msgActivity.currentChats[msgActivity.curChat]) || readMsg.getTo().equals(msgActivity.currentChats[msgActivity.curChat])) {
                                            msgActivity.txtChatLog.setText( msgActivity.chatLog[ msgActivity.curChat]);
                                        }
                                        msgActivity.append(msg);
                                        msgActivity.triggerNotification(readMsg.getFrom(),msg);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                    }
                } catch (IOException e) {
                    error = "Connection lost please log again";
                    errorAlert();
                    break;
                }
            }
        }
    }

}
