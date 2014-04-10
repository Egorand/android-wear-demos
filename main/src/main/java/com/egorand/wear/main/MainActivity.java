package com.egorand.wear.main;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.preview.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat;
import android.view.View;

import static com.egorand.wear.main.ActionResultReceiverActivity.ACTION_RESULT_CANCEL;
import static com.egorand.wear.main.ActionResultReceiverActivity.ACTION_RESULT_OK;
import static com.egorand.wear.main.ActionResultReceiverActivity.ARG_ACTION_RESULT;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createSimpleNotification(View v) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Android Wear")
                .setContentText("Exploring the developer preview SDK");
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(1, builder.build());
    }

    public void createNotificationWithActions(View view) {
        Intent resultOkIntent = new Intent(this, ActionResultReceiverActivity.class);
        resultOkIntent.putExtra(ARG_ACTION_RESULT, ACTION_RESULT_OK);
        PendingIntent resultOkPendingIntent = PendingIntent.getActivity(this, ACTION_RESULT_OK, resultOkIntent, 0);

        Intent resultCancelIntent = new Intent(this, ActionResultReceiverActivity.class);
        resultCancelIntent.putExtra(ARG_ACTION_RESULT, ACTION_RESULT_CANCEL);
        PendingIntent resultCancelPendingIntent = PendingIntent.getActivity(this, ACTION_RESULT_CANCEL, resultCancelIntent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("Warning!")
                .setContentText("Your disk is about to be wiped!")
                .addAction(R.drawable.ic_ok, getString(android.R.string.ok), resultOkPendingIntent)
                .addAction(R.drawable.ic_cancel, getString(android.R.string.cancel), resultCancelPendingIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(2, builder.build());
    }
}
