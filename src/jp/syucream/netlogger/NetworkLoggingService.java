package jp.syucream.netlogger;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


/**
 * ネットワークの状態変更をログに記録するサービス
 */
public class NetworkLoggingService extends IntentService {

    public NetworkLoggingService(){
        super( "NetworkLoggingService" ); // このクラスで使われるスレッド名
    }

    @Override
    public void onHandleIntent( Intent intent ){
        final NetworkLogUnit logUnit =
            NetworkLoggingIntent.getNetworkLogUnit( intent );
        Log.d( "NetworkLoggingService", logUnit.toString() );
    }
}
