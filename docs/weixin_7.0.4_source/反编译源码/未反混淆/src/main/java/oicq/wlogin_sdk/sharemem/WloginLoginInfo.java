package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class WloginLoginInfo implements Parcelable, Serializable {
    public static final Creator<WloginLoginInfo> CREATOR = new Creator<WloginLoginInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(96457);
            WloginLoginInfo wloginLoginInfo = new WloginLoginInfo(parcel, null);
            AppMethodBeat.o(96457);
            return wloginLoginInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WloginLoginInfo[i];
        }
    };
    public static int TYPE_LOACL = 1;
    public static int TYPE_REMOTE = 2;
    private static final long serialVersionUID = 5551948389726789420L;
    public String mAccount;
    public long mAppid;
    public long mCreateTime;
    public int mType;
    public long mUin;

    static {
        AppMethodBeat.i(96458);
        AppMethodBeat.o(96458);
    }

    public WloginLoginInfo(String str, long j, long j2, long j3, int i) {
        this.mAccount = str;
        this.mUin = j;
        this.mAppid = j2;
        this.mCreateTime = j3;
        this.mType = i;
    }

    private WloginLoginInfo(Parcel parcel) {
        AppMethodBeat.i(96459);
        readFromParcel(parcel);
        AppMethodBeat.o(96459);
    }

    /* synthetic */ WloginLoginInfo(Parcel parcel, WloginLoginInfo wloginLoginInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(96460);
        parcel.writeString(this.mAccount);
        parcel.writeLong(this.mUin);
        parcel.writeLong(this.mAppid);
        parcel.writeLong(this.mCreateTime);
        parcel.writeInt(this.mType);
        AppMethodBeat.o(96460);
    }

    public void readFromParcel(Parcel parcel) {
        AppMethodBeat.i(96461);
        this.mAccount = parcel.readString();
        this.mUin = parcel.readLong();
        this.mAppid = parcel.readLong();
        this.mCreateTime = parcel.readLong();
        this.mType = parcel.readInt();
        AppMethodBeat.o(96461);
    }
}
