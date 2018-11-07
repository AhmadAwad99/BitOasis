package com.androidapp.bitoasis.bitoasis.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidapp.bitoasis.bitoasis.R;
import com.androidapp.bitoasis.bitoasis.listeners.BitWebSocketListener;
import com.androidapp.bitoasis.bitoasis.model.TickerDetailsModel;
import com.androidapp.bitoasis.bitoasis.utils.NetworkUtils;
import com.androidapp.bitoasis.bitoasis.utils.StringParsingUtil;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SecondViewkFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondViewkFragment extends Fragment {
    private OkHttpClient client;
    Button _startButton;
    EditText _numberText;
    ImageView _stockImageView;
    TextView _lastTrade, _pcl, _htp, _ltp;
    WebSocket wSocket;



    public SecondViewkFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment SecondViewkFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondViewkFragment newInstance() {
        SecondViewkFragment fragment = new SecondViewkFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = new OkHttpClient();

    }
    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState) {
        _lastTrade = view.findViewById(R.id.lastTrade);
        _pcl = view.findViewById(R.id.pcl);
        _htp = view.findViewById(R.id.htp);
        _ltp = view.findViewById(R.id.ltp);

        _startButton = view.findViewById(R.id.btn_start);
        _numberText = view.findViewById(R.id.input_number);
        _stockImageView = view.findViewById(R.id.stock_imageview);
        _startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO:Check internet connection and user input
                // TODO:Check if its already started
                if (_numberText.getText().toString().trim().length() > 0) {
                    if (NetworkUtils.isInternetConnected(getActivity())) {

                        start();


                    } else {
                        Toast.makeText(getActivity(), "Please Connect to the Internet", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Please Fill the Above with a Number", Toast.LENGTH_SHORT).show();

                }
            }


        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_viewk, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void start() {
        Request request = new Request.Builder().url("wss://api2.poloniex.com").build();
        BitWebSocketListener listener = new BitWebSocketListener();
        listener.setSecondViewkFragmen(SecondViewkFragment.this);
            wSocket = client.newWebSocket(request, listener);
            client.dispatcher().executorService().shutdown();


    }

    public void output(final String txt) {
        final StringParsingUtil stringParsingUtil = new StringParsingUtil();

        final TickerDetailsModel tickerDetailsModel = stringParsingUtil.getModelFromText(txt);

        getActivity().runOnUiThread(new Runnable() {
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
