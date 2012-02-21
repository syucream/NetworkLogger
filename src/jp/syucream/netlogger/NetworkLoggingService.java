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
    public void onCreate(){
        Log.d( "NetworkLoggingService", "service started" );
    }

    @Override
    public IBinder onBind( Intent intent ){
        return null;
    }
}
