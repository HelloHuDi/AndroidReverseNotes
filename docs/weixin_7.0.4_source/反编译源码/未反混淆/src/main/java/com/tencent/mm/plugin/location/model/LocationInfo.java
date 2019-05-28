package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.bo;

public class LocationInfo implements Parcelable {
    public static final Creator<LocationInfo> CREATOR = new Creator<LocationInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocationInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(113293);
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
            AppMethodBeat.o(113293);
            return locationInfo;
        }
    };
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
        AppMethodBeat.i(113294);
        this.nJt = "";
        this.nJu = -85.0d;
        this.nJv = -1000.0d;
        this.nJx = "";
        this.nJy = "zh-cn";
        this.nJz = "";
        this.nJA = 0;
        this.nJt = toString() + " " + System.nanoTime();
        this.nJw = d.bJM();
        AppMethodBeat.o(113294);
    }

    static {
        AppMethodBeat.i(113298);
        AppMethodBeat.o(113298);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(113295);
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
        AppMethodBeat.o(113295);
    }

    public final boolean bJo() {
        if (this.nJu == -85.0d || this.nJv == -1000.0d) {
            return false;
        }
        return true;
    }

    public final boolean bJp() {
        AppMethodBeat.i(113296);
        if (bo.isNullOrNil(this.nJx) && bo.isNullOrNil(this.cIK)) {
            AppMethodBeat.o(113296);
            return false;
        }
        AppMethodBeat.o(113296);
        return true;
    }

    public String toString() {
        AppMethodBeat.i(113297);
        String str = this.nJu + " " + this.nJv + " " + this.nJx + " " + this.cIK + "  " + this.nJt;
        AppMethodBeat.o(113297);
        return str;
    }

    public int describeContents() {
        return 0;
    }
}
