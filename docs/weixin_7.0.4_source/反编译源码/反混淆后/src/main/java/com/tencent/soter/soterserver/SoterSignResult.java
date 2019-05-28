package com.tencent.soter.soterserver;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SoterSignResult implements Parcelable {
    public static final Creator<SoterSignResult> CREATOR = new C309781();
    public byte[] AvF;
    public int AvG;
    public int bFZ;

    /* renamed from: com.tencent.soter.soterserver.SoterSignResult$1 */
    static class C309781 implements Creator<SoterSignResult> {
        C309781() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SoterSignResult[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(73115);
            SoterSignResult soterSignResult = new SoterSignResult(parcel);
            AppMethodBeat.m2505o(73115);
            return soterSignResult;
        }
    }

    protected SoterSignResult(Parcel parcel) {
        AppMethodBeat.m2504i(73116);
        this.bFZ = parcel.readInt();
        this.AvF = parcel.createByteArray();
        this.AvG = parcel.readInt();
        AppMethodBeat.m2505o(73116);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(73117);
        parcel.writeInt(this.bFZ);
        parcel.writeByteArray(this.AvF);
        parcel.writeInt(this.AvG);
        AppMethodBeat.m2505o(73117);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(73118);
        AppMethodBeat.m2505o(73118);
    }
}
