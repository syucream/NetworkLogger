package jp.syucream.netlogger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;


/**
 * ネットワークの状態変更を検出するブロードキャストレシーバ
 *
 * ネットワークの接続状態が変更された時、ログ記録サービスを起動します
 *
 */
public class NetworkLoggingReceiver extends BroadcastReceiver {

    /**
     * intent を受け取ったときの処理
     * @param context
     * @param intent
     */
    @Override
    public void onReceive( Context context, Intent intent ){
        final String action = intent.getAction();

        // ネットワーク接続状況変更の検出
        NetworkLogUnit logUnit = null;
        if( ConnectivityManager.CONNECTIVITY_ACTION.equals( action ) ){
            final NetworkInfo ni = getActiveNetworkInfo( context );

            if( ni == null ){
                logUnit = NetworkLogUnit.create( NetworkConnection.NONE );
            }else{
                switch( ni.getType() ){
                    case ConnectivityManager.TYPE_MOBILE:
                        logUnit = NetworkLogUnit.create( NetworkConnection.THREE_G );
                        break;

                    case ConnectivityManager.TYPE_WIFI:
                        logUnit = NetworkLogUnit.create( NetworkConnection.WIFI );
                        break;
                }
            }
        }

        if( logUnit != null ){
            startLoggingService( context, logUnit );
        }
    }

    private NetworkInfo getActiveNetworkInfo( Context context ){
        final ConnectivityManager cm = ( ConnectivityManager )
            context.getSystemService( Context.CONNECTIVITY_SERVICE );

        return cm.getActiveNetworkInfo();
    }

    private static void startLoggingService( Context context, NetworkLogUnit logUnit ){
        final Intent intent = new Intent( context, NetworkLoggingService.class );
        intent.putExtra( "LogUnit", logUnit );

        context.startService( intent );
    }
}
