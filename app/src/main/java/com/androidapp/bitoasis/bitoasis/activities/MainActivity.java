package com.androidapp.bitoasis.bitoasis.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidapp.bitoasis.bitoasis.R;
import com.androidapp.bitoasis.bitoasis.listeners.BitWebSocketListener;
import com.androidapp.bitoasis.bitoasis.model.TickerDetailsModel;
import com.androidapp.bitoasis.bitoasis.utils.NetworkUtils;
import com.androidapp.bitoasis.bitoasis.utils.StringParsingUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

public class MainActivity extends BaseActivity {
    private OkHttpClient client;
    Button _startButton;
    EditText _numberText;
    ImageView _stockImageView;
    TextView _lastTrade, _pcl, _htp, _ltp;
    WebSocket wSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = new OkHttpClient();


        _lastTrade = findViewById(R.id.lastTrade);
        _pcl = findViewById(R.id.pcl);
        _htp = findViewById(R.id.htp);
        _ltp = findViewById(R.id.ltp);


        _startButton = findViewById(R.id.btn_start);
        _numberText = findViewById(R.id.input_number);
        _stockImageView = findViewById(R.id.stock_imageview);
        _startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO:Check internet connection and user input
                // TODO:Check if its already started
                if (_numberText.getText().toString().trim().length() > 0) {
                    if (NetworkUtils.isInternetConnected(MainActivity.this)) {

                        start();


                    } else {
                        showSnackMessage("Please Connect to the Internet");
                    }
                } else {
                    showSnackMessage("Please Fill the Above with a Number");

                }
            }


        });
    }

    private void start() {
        Request request = new Request.Builder().url("wss://api2.poloniex.com").build();
        BitWebSocketListener listener = new BitWebSocketListener();
        listener.setMainActivity(MainActivity.this);
        if (wSocket == null) {
            wSocket = client.newWebSocket(request, listener);
            client.dispatcher().executorService().shutdown();
        }

    }

    public void output(final String txt) {
        final StringParsingUtil stringParsingUtil = new StringParsingUtil();

        final TickerDetailsModel tickerDetailsModel = stringParsingUtil.getModelFromText(txt);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                SetData(tickerDetailsModel);
            }
        });
    }

    private void SetData(TickerDetailsModel tickerDetailsModel) {
        if (_numberText.getText().toString().trim().length() > 0 && tickerDetailsModel.getLastTradePrice() != null) {
            if (Integer.parseInt(_numberText.getText().toString()) > Double.parseDouble(tickerDetailsModel.getLastTradePrice())) {
                _stockImageView.setImageResource(R.drawable.ic_arrow_down);
            } else {

                _stockImageView.setImageResource(R.drawable.ic_arrow_up);
            }
            _lastTrade.setText(tickerDetailsModel.getLastTradePrice());
            _pcl.setText(tickerDetailsModel.getPercentChangeInLast());
            _htp.setText(tickerDetailsModel.getHighestTradePrice());
            _ltp.setText(tickerDetailsModel.getLowestTradePrice());
        }
    }


}
