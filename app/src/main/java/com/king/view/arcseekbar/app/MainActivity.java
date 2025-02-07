package com.king.view.arcseekbar.app;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.king.view.arcseekbar.ArcSeekBar;

/**
 * 示例
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <p>
 * <a href="https://github.com/jenly1314">Follow me</a>
 */
public class MainActivity extends AppCompatActivity {

    ArcSeekBar arcSeekBar1;
    ArcSeekBar arcSeekBar2;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arcSeekBar1 = findViewById(R.id.arcSeekBar1);
        arcSeekBar2 = findViewById(R.id.arcSeekBar2);
        cb = findViewById(R.id.cb);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                arcSeekBar1.setShowTick(isChecked);
                arcSeekBar2.setShowTick(isChecked);
            }
        });
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                arcSeekBar2.showAnimation(arcSeekBar2.getProgress() == 100 ? 0 : arcSeekBar2.getProgress(), 100, 3000);
                break;
            case R.id.btn2:
                arcSeekBar2.showAnimation(arcSeekBar2.getProgress() == 0 ? 100 : arcSeekBar2.getProgress(), 0, 3000);
                break;
        }
    }
}
