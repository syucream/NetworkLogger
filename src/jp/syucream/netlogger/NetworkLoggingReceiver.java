package jp.syucream.netlogger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * ネットワークの状態変更を検出するブロードキャストレシーバ
 *
 * ネットワークの接続状態が変更された時、疎通確認とスイッチングを行います
 *
 */
public class NetworkLoggingReceiver extends BroadcastReceiver {
    // デバッグ用
    private static final boolean D = true;


    /**
     * intent を受け取ったときの処理
     * @param context
     * @param intent
     */
    @Override
    public void onReceive( Context context, Intent intent ){
        String action = intent.getAction();

        // ネットワーク接続状況変更の検出
        if( ConnectivityManager.CONNECTIVITY_ACTION.equals( action ) ){
            ConnectivityManager cm = ( ConnectivityManager )context.getSystemService( Context.CONNECTIVITY_SERVICE );
            NetworkInfo ni = cm.getActiveNetworkInfo();

            if( ni == null ){
                // エアプレーンモード移行時
                return;
            }
            int type = ni.getType();
            switch( type ){
                case ConnectivityManager.TYPE_MOBILE:
                    // 3G 通信時
                    break;
                case ConnectivityManager.TYPE_WIFI:
                    // WiFi 通信時
                    break;
                default:
                    break;
            }
        }
    }
}
