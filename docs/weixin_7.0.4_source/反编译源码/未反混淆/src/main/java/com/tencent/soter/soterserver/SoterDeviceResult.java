package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterDeviceResult implements Parcelable {
    public static final Creator<SoterDeviceResult> CREATOR = new Creator<SoterDeviceResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SoterDeviceResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(73103);
            SoterDeviceResult soterDeviceResult = new SoterDeviceResult(parcel);
            AppMethodBeat.o(73103);
            return soterDeviceResult;
        }
    };
    public byte[] AvF;
    public int AvG;
    public int bFZ;

    protected SoterDeviceResult(Parcel parcel) {
        AppMethodBeat.i(73104);
        this.bFZ = parcel.readInt();
        this.AvF = parcel.createByteArray();
        this.AvG = parcel.readInt();
        AppMethodBeat.o(73104);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(73105);
        parcel.writeInt(this.bFZ);
        parcel.writeByteArray(this.AvF);
        parcel.writeInt(this.AvG);
        AppMethodBeat.o(73105);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(73106);
        AppMethodBeat.o(73106);
    }
}
