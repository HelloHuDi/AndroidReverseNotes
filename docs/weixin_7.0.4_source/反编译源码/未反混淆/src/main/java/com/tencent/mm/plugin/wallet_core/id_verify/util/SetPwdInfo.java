package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SetPwdInfo implements Parcelable {
    public static final Creator<SetPwdInfo> CREATOR = new Creator<SetPwdInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SetPwdInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46690);
            SetPwdInfo setPwdInfo = new SetPwdInfo(parcel);
            AppMethodBeat.o(46690);
            return setPwdInfo;
        }
    };
    public String nZa;
    public String nZb = "";
    public String nZc = "";
    public int twa;

    protected SetPwdInfo(Parcel parcel) {
        AppMethodBeat.i(46691);
        this.twa = parcel.readInt();
        this.nZa = parcel.readString();
        this.nZb = parcel.readString();
        this.nZc = parcel.readString();
        AppMethodBeat.o(46691);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(46692);
        parcel.writeInt(this.twa);
        parcel.writeString(this.nZa);
        parcel.writeString(this.nZb);
        parcel.writeString(this.nZc);
        AppMethodBeat.o(46692);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(46693);
        AppMethodBeat.o(46693);
    }
}
