package edison.pokemon_try;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

/**
 * Created by MSI on 2016/12/16.
 */
public class StaticReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.staticreceiver")) {
            Bundle bundle = intent.getExtras();
            Bitmap bm = BitmapFactory.decodeResource(Resources.getSystem(), bundle.getInt("fpic"));
            Notification.Builder builder = new Notification.Builder(context);
            Intent intent1 = new Intent(context, pokelist_activity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent1, 0);
            builder.setContentTitle("POKEDEX")
                    .setSmallIcon(bundle.getInt("fpic"))
                    .setContentText(bundle.getString("name"))
                    .setLargeIcon(bm)
                    .setTicker("请详细阅读有关"+ bundle.getString("name") +"的介绍")
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
            NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            Notification notify = builder.build();
            manager.notify(0, notify);
        }
    }
}
