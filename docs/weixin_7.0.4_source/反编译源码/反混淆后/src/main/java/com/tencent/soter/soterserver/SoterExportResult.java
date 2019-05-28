package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterExportResult implements Parcelable {
    public static final Creator<SoterExportResult> CREATOR = new C309761();
    public byte[] AvF;
    public int AvG;
    public int bFZ;

    /* renamed from: com.tencent.soter.soterserver.SoterExportResult$1 */
    static class C309761 implements Creator<SoterExportResult> {
        C309761() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SoterExportResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(73107);
            SoterExportResult soterExportResult = new SoterExportResult(parcel);
            AppMethodBeat.m2505o(73107);
            return soterExportResult;
        }
    }

    public SoterExportResult(Parcel parcel) {
        AppMethodBeat.m2504i(73108);
        this.bFZ = parcel.readInt();
        this.AvF = parcel.createByteArray();
        this.AvG = parcel.readInt();
        AppMethodBeat.m2505o(73108);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(73109);
        parcel.writeInt(this.bFZ);
        parcel.writeByteArray(this.AvF);
        parcel.writeInt(this.AvG);
        AppMethodBeat.m2505o(73109);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(73110);
        AppMethodBeat.m2505o(73110);
    }
}
