package erizzocreations.es.notificationstowear;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/*
* Author: CVR
* Date :22/01/2015
* Description: Example  wearable notifications
* */
public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button BT_notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        //Define notification button
        BT_notification = (Button) findViewById(R.id.BT_notif);

        //Set onclicklistener
        BT_notification.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.BT_notif:
                notifyToWear();
                break;
            default:
                break;
        }
    }

    public void notifyToWear() {

        int notificationId = 001;

        // Build intent for notification content

        Intent viewIntent = new Intent(this, MainActivity.class);

        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(this, 0, viewIntent, 0);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Hola caracola")
                        .setContentText("Saludo desde mi telefono")
                        .setContentIntent(viewPendingIntent);

        // Get an instance of the NotificationManager service

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(this);

        // Build the notification and issues it with notification manager.

        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
