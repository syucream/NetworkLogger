package jp.syucream.netlogger.logaccess;

import android.database.Cursor;


/**
 * NetworkLogAccessor のヘルパ
 */
public final class NetworkLogAccessHelper {

    private static final NetworkLogAccessor ACCESSOR = new NetworkLogAccessorDummy();


    private NetworkLogAccessHelper(){
        throw new AssertionError();
    }


    public static final NetworkLogAccessor getAccessor(){
        return ACCESSOR;
    }


    public static final NetworkLogUnit getLogUnitFromCursor( Cursor c ){
        if (c instanceof NetworkLogAccessorDummy.DummyCursor){
            return ((NetworkLogAccessorDummy.DummyCursor)c).getLogUnit();
        }

        throw new IllegalArgumentException();
    }
}
