package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterExportResult implements Parcelable {
    public static final Creator<SoterExportResult> CREATOR = new Creator<SoterExportResult>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SoterExportResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(73107);
            SoterExportResult soterExportResult = new SoterExportResult(parcel);
            AppMethodBeat.o(73107);
            return soterExportResult;
        }
    };
    public byte[] AvF;
    public int AvG;
    public int bFZ;

    public SoterExportResult(Parcel parcel) {
        AppMethodBeat.i(73108);
        this.bFZ = parcel.readInt();
        this.AvF = parcel.createByteArray();
        this.AvG = parcel.readInt();
        AppMethodBeat.o(73108);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(73109);
        parcel.writeInt(this.bFZ);
        parcel.writeByteArray(this.AvF);
        parcel.writeInt(this.AvG);
        AppMethodBeat.o(73109);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(73110);
        AppMethodBeat.o(73110);
    }
}
