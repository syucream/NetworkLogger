package jp.syucream.netlogger;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


/**
 * ネットワークの状態変更をログに記録するサービス
 */
public class NetworkLoggingService extends Service {

    @Override
    public int onStartCommand( Intent intent, int flags, int startId ){
        final NetworkLogUnit logUnit = intent.getParcelableExtra( "LogUnit" );
        Log.d( "NetworkLoggingService", logUnit.toString() );
        return START_STICKY;
    }

    @Override
    public IBinder onBind( Intent intent ){
        return null;
    }
}
