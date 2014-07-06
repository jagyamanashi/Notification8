package com.github.jagyamanashi.notification8;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Button clicked.");

                showNotification();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showNotification() {
        int notificationId1 = 011;
        String sender1 = "xxx@xxx.xxx";
        String subject1 = "Subject 1";

        int notificationId2 = 012;
        String sender2 = "yyy@yyy.yyy";
        String subject2 = "Subject 2";

        int notificationId3 = 013;

        final String GROUP_KEY_EMAILS = "group_key_emails";

        Notification notif = new NotificationCompat.Builder(this)
                .setContentTitle("New mail from " + sender1)
                .setContentText(subject1)
                .setSmallIcon(R.drawable.ic_stat_smile)
                .setGroup(GROUP_KEY_EMAILS)
                .build();

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId1, notif);

        Notification notif2 = new NotificationCompat.Builder(this)
                .setContentTitle("New mail from " + sender2)
                .setContentText(subject2)
                .setSmallIcon(R.drawable.ic_stat_smile)
                .setGroup(GROUP_KEY_EMAILS)
                .build();

        notificationManager.notify(notificationId2, notif2);

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_large_icon);

        Notification summaryNotification = new NotificationCompat.Builder(this)
                .setContentTitle("2 new messages")
                .setSmallIcon(R.drawable.ic_stat_smile)
                .setLargeIcon(largeIcon)
                .setStyle(new NotificationCompat.InboxStyle()
                        .addLine("Alex Faaborg   Check this out")
                        .addLine("Jeff Chang   Launch Party")
                        .setBigContentTitle("2 new messages")
                        .setSummaryText("johndoe@gmail.com"))
                .setGroup(GROUP_KEY_EMAILS)
                .setGroupSummary(true)
                .build();

        notificationManager.notify(notificationId3, summaryNotification);
    }
}
