package com.androidapp.bitoasis.bitoasis.listeners;

import com.androidapp.bitoasis.bitoasis.fragments.FirstViewFragment;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * Created by Ahmad  awad on 06/11/2018.
 */
public class BitWebSocketListener extends WebSocketListener {
    private static final int NORMAL_CLOSURE_STATUS = 1000;
    private FirstViewFragment firstViewFragment;

    public void setFirstViewFragment(FirstViewFragment mainActivity) {
        this.firstViewFragment = mainActivity;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {

        webSocket.send("{\n" +
                "\n" +
                "\"command\": \"subscribe\",\n" +
                "\n" +
                "\"channel\": 1002\n" +
                "\n" +
                "}");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        firstViewFragment.output("Receiving : " + text);


    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        firstViewFragment.output("Receiving : " + bytes);

    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        firstViewFragment.output("Error : " + t.getMessage());
    }
}
