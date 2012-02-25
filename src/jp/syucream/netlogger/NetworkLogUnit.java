package jp.syucream.netlogger;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;


/**
 * ログの構成単位
 */
public class NetworkLogUnit implements Parcelable {

    private final Date timeStamp;
    private final NetworkConnection connection;


    /**
     * 現在時刻で作成する
     */
    public static NetworkLogUnit create( NetworkConnection connection ){
        return new NetworkLogUnit( new Date(), connection );
    }

    public NetworkLogUnit( Date timeStamp, NetworkConnection connection ){
        this.timeStamp = timeStamp;
        this.connection = connection;
    }


    @Override
    public String toString(){
        return new StringBuilder( "NetworkLogUnit" )
            .append( " " )
            .append( connection.toString() )
            .append( " " )
            .append( "(" ).append( timeStamp.toString() ).append( ")" )
            .toString();
    }


    // -------------------------------------------
    // Parcelable 実装
    // -------------------------------------------


    private NetworkLogUnit( Parcel in ){
        timeStamp = ( Date )in.readSerializable();
        connection = NetworkConnection.valueOf( in.readString() );
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel( Parcel out, int flags ){
        out.writeSerializable( timeStamp );
        out.writeString( connection.name() );
    }

    public static final Creator<NetworkLogUnit> CREATOR =
        new Creator<NetworkLogUnit>(){

        @Override
        public NetworkLogUnit createFromParcel( Parcel source ){
            return new NetworkLogUnit( source );
        }

        @Override
        public NetworkLogUnit[] newArray( int size ){
            return new NetworkLogUnit[size];
        }
    };
}
