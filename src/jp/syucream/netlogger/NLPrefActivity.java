package jp.syucream.netlogger;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.ProgressBar;

/**
 * 設定画面を表示する
 * Preference のレイアウト: res/xml/pref.xml
 */
public class NLPrefActivity extends PreferenceActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        addPreferencesFromResource( R.xml.pref );
    }
}
