package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    private int mStoryIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        if (savedInstanceState == null) {
            mStoryIndex = 1;
        } else {
            mStoryIndex = savedInstanceState.getInt("mStoryIndex");
            mStoryTextView.setText(savedInstanceState.getString("mStoryTextView"));
            mButtonTop.setText(savedInstanceState.getString("mButtonTop"));
            mButtonBottom.setText(savedInstanceState.getString("mButtonBottom"));
        }
    }

    public void topButtonClicked(View view) {
    }

    public void bottomButtonClicked(View view) {
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("mStoryIndex", mStoryIndex);
        outState.putString("mStoryTextView", mStoryTextView.getText().toString());
        outState.putString("mButtonTop", mButtonTop.getText().toString());
        outState.putString("mButtonBottom", mButtonBottom.getText().toString());
    }
}
