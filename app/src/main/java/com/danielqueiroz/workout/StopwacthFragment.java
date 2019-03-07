package com.danielqueiroz.workout;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class StopwacthFragment extends Fragment implements View.OnClickListener{

    private Button btnStart, btnStop, btnReset;
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(layout);

        btnStart = (Button) layout.findViewById(R.id.start_button);
        btnStart.setOnClickListener(this);
        btnStop = (Button) layout.findViewById(R.id.stop_button);
        btnStop.setOnClickListener(this);
        btnReset = (Button) layout.findViewById(R.id.reset_button);
        btnReset.setOnClickListener(this);

        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning",wasRunning);
    }

    @Override
    public void onStop() {
        super.onStop();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (wasRunning){
            running = true;
        }
    }

    public void onClickStart(View v){
        running = true;
    }

    public void onClickStop(View v){
        running = false;
    }

    public void onClickReset(View v){
        running = false;
        seconds = 0;
    }

    private void runTimer(View v){
        final TextView timeView =  (TextView) v.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes =  (seconds%3600)/ 60;
                int secs =  seconds%60;

                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);

                if (running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_button:
                onClickStart(v);
                break;
            case R.id.stop_button:
                onClickStop(v);
                break;
            case R.id.reset_button:
                onClickReset(v);
                break;
        }
    }
}
