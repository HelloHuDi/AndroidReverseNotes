package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterSessionResult implements Parcelable {
    public static final Creator<SoterSessionResult> CREATOR = new C309771();
    public long AvH;
    public int bFZ;

    /* renamed from: com.tencent.soter.soterserver.SoterSessionResult$1 */
    static class C309771 implements Creator<SoterSessionResult> {
        C309771() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SoterSessionResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(73111);
            SoterSessionResult soterSessionResult = new SoterSessionResult(parcel);
            AppMethodBeat.m2505o(73111);
            return soterSessionResult;
        }
    }

    protected SoterSessionResult(Parcel parcel) {
        AppMethodBeat.m2504i(73112);
        this.AvH = parcel.readLong();
        this.bFZ = parcel.readInt();
        AppMethodBeat.m2505o(73112);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(73113);
        parcel.writeLong(this.AvH);
        parcel.writeInt(this.bFZ);
        AppMethodBeat.m2505o(73113);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(73114);
        AppMethodBeat.m2505o(73114);
    }
}
