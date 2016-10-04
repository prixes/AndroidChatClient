package com.prixeSoft.easymessages;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by david on 04-Jun-16.
 */
public class Client  {

    private Socket socket;
    boolean online = false;

    private String server, username;
    private int port;
    private Messaging msgActivity ;
    boolean getName=false;
    String error;

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
        prepMsg.setTypeValue(1);
        prepMsg.setFrom(username);
        prepMsg.setMessage(msg);
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
                                    Client.this.msgActivity.lblUsername.setText("Loged as: " + username);
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
                    ComProtobuf.msg readMsg = ComProtobuf.msg.parseDelimitedFrom(socket.getInputStream());
                    if(readMsg != null ) {
                        if (readMsg.getType().getNumber() == 1) {
                            final String msg = readMsg.getMessage();

                            msgActivity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Client.this.msgActivity.append(msg);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
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
