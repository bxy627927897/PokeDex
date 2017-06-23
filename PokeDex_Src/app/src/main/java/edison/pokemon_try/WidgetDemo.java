package edison.pokemon_try;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;

/**
 * Created by MSI on 2016/12/16.
 */
public class WidgetDemo extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Intent clickInt = new Intent(context, pokelist_activity.class);
        PendingIntent pi = PendingIntent.getActivity(context, 0, clickInt, 0);
        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_demo);
        rv.setOnClickPendingIntent(R.id.widget_pic, pi);
        appWidgetManager.updateAppWidget(appWidgetIds, rv);
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_demo);
        Bundle bundle = intent.getExtras();
        if (intent.getAction().equals("android.intent.action.staticreceiver")) {
            rv.setTextViewText(R.id.widget_name, bundle.getString("name"));
            rv.setImageViewResource(R.id.widget_pic, bundle.getInt("fpic"));
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            appWidgetManager.updateAppWidget(new ComponentName(context, WidgetDemo.class), rv);
        }
    }
}
