package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterSignResult implements Parcelable {
    public static final Creator<SoterSignResult> CREATOR = new Creator<SoterSignResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SoterSignResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(73115);
            SoterSignResult soterSignResult = new SoterSignResult(parcel);
            AppMethodBeat.o(73115);
            return soterSignResult;
        }
    };
    public byte[] AvF;
    public int AvG;
    public int bFZ;

    protected SoterSignResult(Parcel parcel) {
        AppMethodBeat.i(73116);
        this.bFZ = parcel.readInt();
        this.AvF = parcel.createByteArray();
        this.AvG = parcel.readInt();
        AppMethodBeat.o(73116);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(73117);
        parcel.writeInt(this.bFZ);
        parcel.writeByteArray(this.AvF);
        parcel.writeInt(this.AvG);
        AppMethodBeat.o(73117);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(73118);
        AppMethodBeat.o(73118);
    }
}
