package oicq.wlogin_sdk.sharemem;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public class WloginSimpleInfo implements Parcelable, Serializable {
    public static final Creator<WloginSimpleInfo> CREATOR = new Creator<WloginSimpleInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(96448);
            WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo(parcel, null);
            AppMethodBeat.o(96448);
            return wloginSimpleInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WloginSimpleInfo[i];
        }
    };
    private static final long serialVersionUID = 1;
    public byte[] _age;
    public byte[] _face;
    public byte[] _gender;
    public byte[] _nick;
    public long _uin;

    public WloginSimpleInfo(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        AppMethodBeat.i(96450);
        this._uin = j;
        this._face = (byte[]) bArr.clone();
        this._age = (byte[]) bArr2.clone();
        this._gender = (byte[]) bArr3.clone();
        this._nick = (byte[]) bArr4.clone();
        AppMethodBeat.o(96450);
    }

    public WloginSimpleInfo() {
        AppMethodBeat.i(96451);
        this._uin = 0;
        this._face = new byte[0];
        this._age = new byte[0];
        this._gender = new byte[0];
        this._nick = new byte[0];
        AppMethodBeat.o(96451);
    }

    public void get_clone(WloginSimpleInfo wloginSimpleInfo) {
        AppMethodBeat.i(96452);
        this._uin = wloginSimpleInfo._uin;
        this._face = (byte[]) wloginSimpleInfo._face.clone();
        this._age = (byte[]) wloginSimpleInfo._age.clone();
        this._gender = (byte[]) wloginSimpleInfo._gender.clone();
        this._nick = (byte[]) wloginSimpleInfo._nick.clone();
        AppMethodBeat.o(96452);
    }

    public WloginSimpleInfo get_clone() {
        AppMethodBeat.i(96453);
        WloginSimpleInfo wloginSimpleInfo = new WloginSimpleInfo();
        wloginSimpleInfo._uin = this._uin;
        wloginSimpleInfo._face = (byte[]) this._face.clone();
        wloginSimpleInfo._age = (byte[]) this._age.clone();
        wloginSimpleInfo._gender = (byte[]) this._gender.clone();
        wloginSimpleInfo._nick = (byte[]) this._nick.clone();
        AppMethodBeat.o(96453);
        return wloginSimpleInfo;
    }

    static {
        AppMethodBeat.i(96449);
        AppMethodBeat.o(96449);
    }

    private WloginSimpleInfo(Parcel parcel) {
        AppMethodBeat.i(96454);
        readFromParcel(parcel);
        AppMethodBeat.o(96454);
    }

    /* synthetic */ WloginSimpleInfo(Parcel parcel, WloginSimpleInfo wloginSimpleInfo) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(96455);
        parcel.writeLong(this._uin);
        parcel.writeByteArray(this._face);
        parcel.writeByteArray(this._age);
        parcel.writeByteArray(this._gender);
        parcel.writeByteArray(this._nick);
        AppMethodBeat.o(96455);
    }

    public void readFromParcel(Parcel parcel) {
        AppMethodBeat.i(96456);
        this._uin = parcel.readLong();
        this._face = parcel.createByteArray();
        this._age = parcel.createByteArray();
        this._gender = parcel.createByteArray();
        this._nick = parcel.createByteArray();
        AppMethodBeat.o(96456);
    }
}
