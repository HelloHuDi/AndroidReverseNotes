package com.tencent.p177mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.location.p446ui.C34412d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.location.model.LocationInfo */
public class LocationInfo implements Parcelable {
    public static final Creator<LocationInfo> CREATOR = new C33371();
    public String cIK;
    public int nJA;
    public String nJB;
    public String nJt;
    public double nJu;
    public double nJv;
    public int nJw;
    public String nJx;
    public String nJy;
    String nJz;

    /* renamed from: com.tencent.mm.plugin.location.model.LocationInfo$1 */
    static class C33371 implements Creator<LocationInfo> {
        C33371() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocationInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(113293);
            LocationInfo locationInfo = new LocationInfo();
            locationInfo.nJt = parcel.readString();
            locationInfo.nJu = parcel.readDouble();
            locationInfo.nJv = parcel.readDouble();
            locationInfo.nJw = parcel.readInt();
            locationInfo.nJx = parcel.readString();
            locationInfo.nJy = parcel.readString();
            locationInfo.cIK = parcel.readString();
            locationInfo.nJz = parcel.readString();
            locationInfo.nJA = parcel.readInt();
            locationInfo.nJB = parcel.readString();
            AppMethodBeat.m2505o(113293);
            return locationInfo;
        }
    }

    public LocationInfo() {
        this.nJt = "";
        this.nJu = -85.0d;
        this.nJv = -1000.0d;
        this.nJx = "";
        this.nJy = "zh-cn";
        this.nJz = "";
        this.nJA = 0;
    }

    public LocationInfo(byte b) {
        AppMethodBeat.m2504i(113294);
        this.nJt = "";
        this.nJu = -85.0d;
        this.nJv = -1000.0d;
        this.nJx = "";
        this.nJy = "zh-cn";
        this.nJz = "";
        this.nJA = 0;
        this.nJt = toString() + " " + System.nanoTime();
        this.nJw = C34412d.bJM();
        AppMethodBeat.m2505o(113294);
    }

    static {
        AppMethodBeat.m2504i(113298);
        AppMethodBeat.m2505o(113298);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(113295);
        parcel.writeString(this.nJt);
        parcel.writeDouble(this.nJu);
        parcel.writeDouble(this.nJv);
        parcel.writeInt(this.nJw);
        parcel.writeString(this.nJx);
        parcel.writeString(this.nJy);
        parcel.writeString(this.cIK);
        parcel.writeString(this.nJz);
        parcel.writeInt(this.nJA);
        parcel.writeString(this.nJB);
        AppMethodBeat.m2505o(113295);
    }

    public final boolean bJo() {
        if (this.nJu == -85.0d || this.nJv == -1000.0d) {
            return false;
        }
        return true;
    }

    public final boolean bJp() {
        AppMethodBeat.m2504i(113296);
        if (C5046bo.isNullOrNil(this.nJx) && C5046bo.isNullOrNil(this.cIK)) {
            AppMethodBeat.m2505o(113296);
            return false;
        }
        AppMethodBeat.m2505o(113296);
        return true;
    }

    public String toString() {
        AppMethodBeat.m2504i(113297);
        String str = this.nJu + " " + this.nJv + " " + this.nJx + " " + this.cIK + "  " + this.nJt;
        AppMethodBeat.m2505o(113297);
        return str;
    }

    public int describeContents() {
        return 0;
    }
}
