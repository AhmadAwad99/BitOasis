package com.androidapp.bitoasis.bitoasis.listeners;

import com.androidapp.bitoasis.bitoasis.fragments.FirstViewFragment;
import com.androidapp.bitoasis.bitoasis.fragments.SecondViewkFragment;

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
    private SecondViewkFragment secondViewkFragmen;

    public void setFirstViewFragment(FirstViewFragment firstViewFragment1) {
        this.firstViewFragment = firstViewFragment1;
    }

    public void setSecondViewkFragmen(SecondViewkFragment secondViewkFragment) {
        this.secondViewkFragmen = secondViewkFragment;
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
        if (firstViewFragment != null)
            firstViewFragment.output("Receiving : " + text);
        else
            secondViewkFragmen.output("Receiving : " + text);


    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {

    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
    }
}
