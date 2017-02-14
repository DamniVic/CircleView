package com.damni.circleview.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.TextView;

import com.damni.circleview.R;
import com.damni.circleview.costumview.CircleView;

public class MainActivity extends Activity {

    private CircleView circleProgressBar;
    private TextView textProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        intView();
    }

    private void intView() {
        circleProgressBar = (CircleView) findViewById(R.id.cpb);
        circleProgressBar.setDotDiameter(20);
        circleProgressBar.setMaxProgressWidth(5);
        circleProgressBar.setFirstProgressWidth(8);
        circleProgressBar.setSecondProgressWidth(10);
        circleProgressBar.setFirstProgress(80, 1000);
        circleProgressBar.setSecondProgress(40, 1000);
        SeekBar sbFirst = (SeekBar) findViewById(R.id.sb_first);
        SeekBar sbSecond = (SeekBar) findViewById(R.id.sb_second);
        sbFirst.setProgress(80);
        sbSecond.setProgress(40);
        sbFirst.setOnSeekBarChangeListener(new MyOnSeekBarChangeListener());
        sbSecond.setOnSeekBarChangeListener(new MyOnSeekBarChangeListener());
        textProgress=(TextView) findViewById(R.id.second_progress);
        textProgress.setText("40%");
    }
    private final class MyOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Log.e("damni","progress = "+progress);
            if(R.id.sb_first == seekBar.getId()){
                circleProgressBar.setFirstProgress(progress);
            }else if(R.id.sb_second == seekBar.getId()){
                circleProgressBar.setSecondProgress(progress);
                textProgress.setText(progress+"%");
            }
            if(progress > 90){
                circleProgressBar.setCanDisplayDot(false);
            }else{
                circleProgressBar.setCanDisplayDot(true);
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}
