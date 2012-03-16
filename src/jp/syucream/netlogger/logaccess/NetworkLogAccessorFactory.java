package jp.syucream.netlogger.logaccess;

import android.content.Context;


/**
 * NetworkLogAccessor の実装のカプセル化を行うファクトリ
 */
public final class NetworkLogAccessorFactory {

    private NetworkLogAccessorFactory(){
        throw new AssertionError();
    }


    public static final NetworkLogAccessor create( Context context ){
        return new NetworkLogAccessorDummy();
    }
}
