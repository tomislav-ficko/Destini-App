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
            recoverApplication();
        }
    }

    private void recoverApplication() {
        if (mStoryIndex <= 3) {
            loadChoice(mStoryIndex);
        } else {
            loadEnding(mStoryIndex);
        }
    }

    public void topButtonClicked(View view) {
        switch (mStoryIndex) {
            case 1:
                loadChoice(3);
                break;
            case 2:
                loadChoice(3);
                break;
            case 3:
                loadEnding(6);
                break;
        }
    }

    public void bottomButtonClicked(View view) {
        switch (mStoryIndex) {
            case 1:
                loadChoice(2);
                break;
            case 2:
                loadEnding(4);
                break;
            case 3:
                loadEnding(5);
                break;
        }
    }

    private void loadChoice(int storyIndex) {
        mStoryIndex = storyIndex;

        switch (storyIndex) {
            case 1:
                mStoryTextView.setText(R.string.T1_Story);
                mButtonTop.setText(R.string.T1_Ans1);
                mButtonBottom.setText(R.string.T1_Ans2);
                break;
            case 2:
                mStoryTextView.setText(R.string.T2_Story);
                mButtonTop.setText(R.string.T2_Ans1);
                mButtonBottom.setText(R.string.T2_Ans2);
                break;
            case 3:
                mStoryTextView.setText(R.string.T3_Story);
                mButtonTop.setText(R.string.T3_Ans1);
                mButtonBottom.setText(R.string.T3_Ans2);
                break;
        }
    }

    private void loadEnding(int endingIndex) {
        mStoryIndex = endingIndex;

        switch (endingIndex) {
            case 4:
                mStoryTextView.setText(R.string.T4_End);
                break;
            case 5:
                mStoryTextView.setText(R.string.T5_End);
                break;
            case 6:
                mStoryTextView.setText(R.string.T6_End);
                break;
        }
        mButtonTop.setVisibility(View.INVISIBLE);
        mButtonBottom.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("mStoryIndex", mStoryIndex);
    }
}
