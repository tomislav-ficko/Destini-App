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
        String resourceName = "T" + mStoryIndex + "_";
        int resId;

        if (mStoryIndex > 3) {
            resId = getResources().getIdentifier(resourceName + "End", "string", getPackageName());
            mStoryTextView.setText(resId);
            mButtonTop.setVisibility(View.INVISIBLE);
            mButtonBottom.setVisibility(View.INVISIBLE);
        } else {
            resId = getResources().getIdentifier(resourceName + "Story", "string", getPackageName());
            mStoryTextView.setText(resId);
            resId = getResources().getIdentifier(resourceName + "Ans1", "string", getPackageName());
            mButtonTop.setText(resId);
            resId = getResources().getIdentifier(resourceName + "Ans2", "string", getPackageName());
            mButtonBottom.setText(resId);
        }
    }

    public void topButtonClicked(View view) {
        switch (mStoryIndex) {
            case 1:
                mStoryTextView.setText(R.string.T3_Story);
                mButtonTop.setText(R.string.T3_Ans1);
                mButtonBottom.setText(R.string.T3_Ans2);
                mStoryIndex = 3;
                break;
            case 2:
                mStoryTextView.setText(R.string.T3_Story);
                mButtonTop.setText(R.string.T3_Ans1);
                mButtonBottom.setText(R.string.T3_Ans2);
                mStoryIndex = 3;
                break;
            case 3:
                mStoryTextView.setText(R.string.T6_End);
                mButtonTop.setVisibility(View.INVISIBLE);
                mButtonBottom.setVisibility(View.INVISIBLE);
                mStoryIndex = 6;
        }
    }

    public void bottomButtonClicked(View view) {
        switch (mStoryIndex) {
            case 1:
                mStoryTextView.setText(R.string.T2_Story);
                mButtonTop.setText(R.string.T2_Ans1);
                mButtonBottom.setText(R.string.T2_Ans2);
                mStoryIndex = 2;
                break;
            case 2:
                mStoryTextView.setText(R.string.T4_End);
                mButtonTop.setVisibility(View.INVISIBLE);
                mButtonBottom.setVisibility(View.INVISIBLE);
                mStoryIndex = 4;
                break;
            case 3:
                mStoryTextView.setText(R.string.T5_End);
                mButtonTop.setVisibility(View.INVISIBLE);
                mButtonBottom.setVisibility(View.INVISIBLE);
                mStoryIndex = 5;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("mStoryIndex", mStoryIndex);
    }
}
