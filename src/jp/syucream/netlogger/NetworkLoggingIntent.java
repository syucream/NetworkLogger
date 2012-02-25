package jp.syucream.netlogger;

import android.content.Context;
import android.content.Intent;


/**
 * NetworkLoggingReceiver/Service 間のやりとりをカプセル化するためのユーティリティ
 */
public final class NetworkLoggingIntent {

    private static final String NETWORK_LOG_UNIT_KEY = "NetworkLogUnit";


    private NetworkLoggingIntent(){
        throw new AssertionError();
    }


    public static final NetworkLogUnit getNetworkLogUnit( Intent intent ){
        return intent.getParcelableExtra( NETWORK_LOG_UNIT_KEY );
    }


    public static final class Builder {

        private final Context context;
        private NetworkLogUnit logUnit = null;


        public Builder( Context context ){
            this.context = context;
        }

        public Builder setNetworkLogUnit( NetworkLogUnit logUnit ){
            this.logUnit = logUnit;
            return this;
        }

        public Intent build(){
            final Intent intent = new Intent( context, NetworkLoggingService.class );
            intent.putExtra( NETWORK_LOG_UNIT_KEY, logUnit );
            return intent;
        }
    }
}
