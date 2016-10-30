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
                //General char (focus) onClick listeners
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


                // On click (focus) and On long click (delete) listeners
                for(int i=1;i<=5;i++)
                {
                    final int cur= i;
                    messaging.btnChat[cur].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            messaging.chatPrefix = "/w " + messaging.btnChat[cur].getText().toString() + " ";
                            messaging.txtChatLog.setText(messaging.chatLog[cur]);
                            messaging.btnChat[messaging.curChat].setBackgroundResource(R.drawable.button_background);
                            messaging.btnChat[1].setBackgroundResource(R.drawable.button_on_foreground);
                            messaging.curChat = cur;
                            messaging.chatWith = messaging.currentChats[cur];
                        }
                    });
                    messaging.btnChat[cur].setOnLongClickListener(new View.OnLongClickListener() {
                        public boolean onLongClick(View v) {
                            messaging.deleteChatTab(cur);
                            return true;
                        }
                    });
                }


                // btnPlus listener  (start new chat)
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
