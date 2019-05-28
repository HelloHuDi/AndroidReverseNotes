package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterSessionResult implements Parcelable {
    public static final Creator<SoterSessionResult> CREATOR = new Creator<SoterSessionResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SoterSessionResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(73111);
            SoterSessionResult soterSessionResult = new SoterSessionResult(parcel);
            AppMethodBeat.o(73111);
            return soterSessionResult;
        }
    };
    public long AvH;
    public int bFZ;

    protected SoterSessionResult(Parcel parcel) {
        AppMethodBeat.i(73112);
        this.AvH = parcel.readLong();
        this.bFZ = parcel.readInt();
        AppMethodBeat.o(73112);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(73113);
        parcel.writeLong(this.AvH);
        parcel.writeInt(this.bFZ);
        AppMethodBeat.o(73113);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(73114);
        AppMethodBeat.o(73114);
    }
}
