package jp.syucream.netlogger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


/**
 * ネットワークの状態変更を検出するブロードキャストレシーバ
 *
 * ネットワークの接続状態が変更された時、疎通確認とスイッチングを行います
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
        if( ConnectivityManager.CONNECTIVITY_ACTION.equals( action ) ){
            final ConnectivityManager cm = ( ConnectivityManager )context.getSystemService( Context.CONNECTIVITY_SERVICE );
            final NetworkInfo ni = cm.getActiveNetworkInfo();

            if( ni == null ){
                onAirplaneMode();
                return;
            }

            final int type = ni.getType();
            switch( type ){
                case ConnectivityManager.TYPE_MOBILE:
                    on3GMode();
                    break;
                case ConnectivityManager.TYPE_WIFI:
                    onWifiMode();
                    break;
                default:
                    break;
            }
        }
    }

    private void onAirplaneMode(){
        Log.d( "NetworkLoggingReceiver", "onAirplaneMode" );
    }

    private void on3GMode(){
        Log.d( "NetworkLoggingReceiver", "on3GMode" );
    }

    private void onWifiMode(){
        Log.d( "NetworkLoggingReceiver", "onWifiMode" );
    }
}
