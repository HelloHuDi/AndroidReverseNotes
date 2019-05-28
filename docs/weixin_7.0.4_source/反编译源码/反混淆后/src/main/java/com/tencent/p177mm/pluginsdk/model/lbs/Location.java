package com.tencent.p177mm.pluginsdk.model.lbs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.pluginsdk.model.lbs.Location */
public class Location implements Parcelable {
    public static final Creator<Location> CREATOR = new C232521();
    public int accuracy;
    public int cGo;
    public String cGq;
    public float fBr;
    public float fBs;
    public String mac;

    /* renamed from: com.tencent.mm.pluginsdk.model.lbs.Location$1 */
    static class C232521 implements Creator<Location> {
        C232521() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Location[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(79407);
            Location location = new Location();
            location.fBr = parcel.readFloat();
            location.fBs = parcel.readFloat();
            location.accuracy = parcel.readInt();
            location.cGo = parcel.readInt();
            location.mac = parcel.readString();
            location.cGq = parcel.readString();
            AppMethodBeat.m2505o(79407);
            return location;
        }
    }

    public Location(float f, float f2, int i, int i2, String str, String str2) {
        this.fBr = f;
        this.fBs = f2;
        this.accuracy = i;
        this.cGo = i2;
        this.mac = str;
        this.cGq = str2;
    }

    public final boolean dhR() {
        AppMethodBeat.m2504i(79408);
        if (this.fBr == -85.0f || this.fBs == -1000.0f) {
            C4990ab.m7410d("MicroMsg.Radar.Location", "mac and cellId is null");
            AppMethodBeat.m2505o(79408);
            return true;
        }
        AppMethodBeat.m2505o(79408);
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(79409);
        parcel.writeFloat(this.fBr);
        parcel.writeFloat(this.fBs);
        parcel.writeInt(this.accuracy);
        parcel.writeInt(this.cGo);
        parcel.writeString(this.mac);
        parcel.writeString(this.cGq);
        AppMethodBeat.m2505o(79409);
    }

    static {
        AppMethodBeat.m2504i(79410);
        AppMethodBeat.m2505o(79410);
    }
}
