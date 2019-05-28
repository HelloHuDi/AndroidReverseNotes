package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterDeviceResult implements Parcelable {
    public static final Creator<SoterDeviceResult> CREATOR = new C410011();
    public byte[] AvF;
    public int AvG;
    public int bFZ;

    /* renamed from: com.tencent.soter.soterserver.SoterDeviceResult$1 */
    static class C410011 implements Creator<SoterDeviceResult> {
        C410011() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SoterDeviceResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(73103);
            SoterDeviceResult soterDeviceResult = new SoterDeviceResult(parcel);
            AppMethodBeat.m2505o(73103);
            return soterDeviceResult;
        }
    }

    protected SoterDeviceResult(Parcel parcel) {
        AppMethodBeat.m2504i(73104);
        this.bFZ = parcel.readInt();
        this.AvF = parcel.createByteArray();
        this.AvG = parcel.readInt();
        AppMethodBeat.m2505o(73104);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(73105);
        parcel.writeInt(this.bFZ);
        parcel.writeByteArray(this.AvF);
        parcel.writeInt(this.AvG);
        AppMethodBeat.m2505o(73105);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(73106);
        AppMethodBeat.m2505o(73106);
    }
}
