package com.example.hw2q3;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ColorRGB colorRGB = new ColorRGB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating a ChangeHandler object
        ChangeHandler handler = new ChangeHandler();

        //red seek bar
        SeekBar redBar = findViewById(R.id.redSeekBar);
        redBar.setOnSeekBarChangeListener(handler);

        //green seek bar
        SeekBar greenBar = findViewById(R.id.greenSeekBar);
        greenBar.setOnSeekBarChangeListener(handler);

        //blue seek bar
        SeekBar blueBar = findViewById(R.id.blueSeekBar);
        blueBar.setOnSeekBarChangeListener(handler);

        //create a ColorRGB object


    }

    private class ChangeHandler implements SeekBar.OnSeekBarChangeListener
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
        {
            //getting the id of the passed seekBar
            int id = seekBar.getId();

            //if the id is red
            if(id == R.id.redSeekBar)
            {
                //getting the values textView to display the current value of the color
                TextView txtView = findViewById(R.id.redValue);
                txtView.setText(progress+"");

                //sending the value of the color to the model
                colorRGB.setRed(progress);
            }
            //if the id is green
            else if (id == R.id.greenSeekBar)
            {
                //getting the values textView to display the current value of the color
                TextView txtView = findViewById(R.id.greenValue);
                txtView.setText(progress+"");

                //sending the value of the color to the model
                colorRGB.setGreen(progress);
            }
            //if the id is blue
            else if (id == R.id.blueSeekBar)
            {
                //getting the values textView to display the current value of the color
                TextView txtView = findViewById(R.id.blueValue);
                txtView.setText(progress+"");

                //sending the value of the color to the model
                colorRGB.setBlue(progress);
            }

            //getting the values of colors from the model
            int red = colorRGB.getRed();
            int green = colorRGB.getGreen();
            int blue = colorRGB.getBlue();

            //getting the color box , and display the color
            TextView colorBox = findViewById(R.id.outputColor);
            colorBox.setBackgroundColor(Color.rgb(red,green,blue));

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
}