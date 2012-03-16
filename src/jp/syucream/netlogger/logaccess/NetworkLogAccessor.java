package jp.syucream.netlogger.logaccess;

import android.database.Cursor;


/**
 * ログの外部への書き込み／外部からの読み込みを行うインタフェース
 */
public interface NetworkLogAccessor {
    public void write( NetworkLogUnit logUnit );
    public Cursor read();

    public NetworkLogUnit getLogUnit( Cursor cursor );
}
