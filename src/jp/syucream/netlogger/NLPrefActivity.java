package jp.syucream.netlogger;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;


/**
 * 設定画面を表示する
 * Preference のレイアウト: res/xml/pref.xml
 */
public class NLPrefActivity extends PreferenceActivity {

    // Notification 関連
    private final static String TITLE = "Network Logger";
    private final static String MSG = "Start logging...";

    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        addPreferencesFromResource( R.xml.pref );

        // notification
        if( PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getBoolean("notification", true) )
            setNotification(getBaseContext());
    }

    /**
     * Notification を用いて動作状況をユーザに通知します
     */
    public static void setNotification(Context context){
        NotificationManager nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification n = new Notification(R.drawable.icon, TITLE + " : " + MSG, System.currentTimeMillis());
        PendingIntent intent = PendingIntent.getActivity(context, 0,
                new Intent(context, NLPrefActivity.class), Intent.FLAG_ACTIVITY_NEW_TASK);
        n.setLatestEventInfo(context, TITLE, MSG, intent);
        n.flags = Notification.FLAG_ONLY_ALERT_ONCE;
        nm.cancel(0);
        nm.notify(0, n);
    }
}
