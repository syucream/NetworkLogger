package jp.syucream.netlogger;

import android.database.Cursor;


/**
 * NetworkLogAccessor のヘルパ
 */
public final class NetworkLogAccessHelper {

    private static final NetworkLogAccessor ACCESSOR = null;


    private NetworkLogAccessHelper(){
        throw new AssertionError();
    }


    public static final NetworkLogAccessor getAccessor(){
        return ACCESSOR;
    }


    public static final NetworkLogUnit getLogUnitFromCursor( Cursor c ){
        throw new IllegalArgumentException();
    }
}
