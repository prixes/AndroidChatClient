package com.prixeSoft.easymessages;

import android.view.View;
import android.widget.Button;

/**
 * Created by david on 30-Oct-16.
 */
public class BtnListeners {
    BtnListeners(final Messaging messaging) {
        messaging.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messaging.btnChat[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        messaging.chatPrefix = "";
                        messaging.txtChatLog.setText(messaging.chatLog[0]);
                        messaging.btnChat[messaging.curChat].setBackgroundResource(R.drawable.button_background);
                        messaging.btnChat[0].setBackgroundResource(R.drawable.button_on_foreground);
                        messaging.curChat = 0;
                        messaging.chatWith = messaging.currentChats[0];
                    }
                });

                messaging.btnChat[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        messaging.chatPrefix = "/w " + messaging.btnChat[1].getText().toString() + " ";
                        messaging.txtChatLog.setText(messaging.chatLog[1]);
                        messaging.btnChat[messaging.curChat].setBackgroundResource(R.drawable.button_background);
                        messaging.btnChat[1].setBackgroundResource(R.drawable.button_on_foreground);
                        messaging.curChat = 1;
                        messaging.chatWith = messaging.currentChats[1];
                    }
                });
                messaging.btnChat[1].setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        messaging.deleteChatTab(1);
                        return true;
                    }
                });
                messaging.btnChat[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        messaging.chatPrefix = "/w " + messaging.btnChat[2].getText().toString() + " ";
                        messaging.txtChatLog.setText(messaging.chatLog[2]);
                        messaging.btnChat[messaging.curChat].setBackgroundResource(R.drawable.button_background);
                        messaging.btnChat[2].setBackgroundResource(R.drawable.button_on_foreground);
                        messaging.curChat = 2;
                        messaging.chatWith = messaging.currentChats[2];
                    }
                });
                messaging.btnChat[2].setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        messaging.deleteChatTab(2);
                        return true;
                    }
                });
                messaging.btnChat[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        messaging.chatPrefix = "/w " + messaging.btnChat[3].getText().toString() + " ";
                        messaging.txtChatLog.setText(messaging.chatLog[3]);
                        messaging.btnChat[messaging.curChat].setBackgroundResource(R.drawable.button_background);
                        messaging.btnChat[3].setBackgroundResource(R.drawable.button_on_foreground);
                        messaging.curChat = 3;
                        messaging.chatWith = messaging.currentChats[4];
                    }
                });
                messaging.btnChat[3].setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        messaging.deleteChatTab(3);
                        return true;
                    }
                });
                messaging.btnChat[4].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        messaging.chatPrefix = "/w " + messaging.btnChat[4].getText().toString() + " ";
                        messaging.txtChatLog.setText(messaging.chatLog[4]);
                        messaging.btnChat[messaging.curChat].setBackgroundResource(R.drawable.button_background);
                        messaging.btnChat[4].setBackgroundResource(R.drawable.button_on_foreground);
                        messaging.curChat = 4;
                        messaging.chatWith = messaging.currentChats[4];
                    }
                });

                messaging.btnChat[4].setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        messaging.deleteChatTab(4);
                        return true;
                    }
                });
                messaging.btnChat[5].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        messaging.chatPrefix = "/w " + messaging.btnChat[5].getText().toString() + " ";
                        messaging.txtChatLog.setText(messaging.chatLog[5]);
                        messaging.btnChat[messaging.curChat].setBackgroundResource(R.drawable.button_background);
                        messaging.btnChat[5].setBackgroundResource(R.drawable.button_on_foreground);
                        messaging.curChat = 5;
                        messaging.chatWith = messaging.currentChats[5];
                    }
                });
                messaging.btnChat[5].setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        messaging.deleteChatTab(5);
                        return true;
                    }
                });
                //buttons onClick functions
                messaging.btnPlus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        messaging.startNewChat();

                    }
                });

            }
        });
    }
}
