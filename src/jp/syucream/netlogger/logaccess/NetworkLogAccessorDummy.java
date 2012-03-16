package jp.syucream.netlogger.logaccess;

import android.database.MatrixCursor;
import android.util.Log;


/**
 * テスト用のダミーログアクセサ
 */
public class NetworkLogAccessorDummy implements NetworkLogAccessor {

    @Override
    public void write( NetworkLogUnit logUnit ){
        Log.d( getClass().getSimpleName(), "write: " + logUnit.toString() );
    }

    @Override
    public DummyCursor read(){
        return new DummyCursor();
    }


    /* package */ class DummyCursor extends MatrixCursor {

        private static final int ROW_NUM = 40;

        public DummyCursor(){
            super( new String[] { "dummy" }, ROW_NUM );

            final Object[] dummy = new Object[1];
            for ( int i = 0; i < ROW_NUM; ++i ){
                addRow( dummy );
            }
        }


        public NetworkLogUnit getLogUnit(){
            final NetworkConnection[] connections = NetworkConnection.values();

            // Cursor の現在位置から NetworkConnection を生成
            final NetworkConnection conn = connections[getPosition() % connections.length];
            return NetworkLogUnit.create( conn );
        }
    }
}
