package com.egorand.wear.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ActionResultReceiverActivity extends Activity {

    public static final String ARG_ACTION_RESULT = "action_result";
    public static final int ACTION_RESULT_OK = 0x12;
    public static final int ACTION_RESULT_CANCEL = 0x13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_result);

        TextView message = (TextView) findViewById(R.id.text);
        if (getIntent().hasExtra(ARG_ACTION_RESULT)) {
            int result = getIntent().getIntExtra(ARG_ACTION_RESULT, -1);
            if (result == ACTION_RESULT_OK) {
                message.setText("Are you sure?!");
            } else if (result == ACTION_RESULT_CANCEL) {
                message.setText("OK, don't worry, your disk is gonna be fine.");
            }
        }
    }
}
