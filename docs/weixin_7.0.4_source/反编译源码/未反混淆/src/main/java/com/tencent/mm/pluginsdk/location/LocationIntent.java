package com.tencent.mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.sdk.platformtools.bo;

public class LocationIntent implements Parcelable {
    public static final Creator<LocationIntent> CREATOR = new Creator<LocationIntent>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocationIntent[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(79206);
            LocationIntent locationIntent = new LocationIntent();
            locationIntent.lat = parcel.readDouble();
            locationIntent.lng = parcel.readDouble();
            locationIntent.cED = parcel.readInt();
            locationIntent.label = parcel.readString();
            locationIntent.eUu = bo.bc(parcel.readString(), "");
            locationIntent.vaO = bo.bc(parcel.readString(), "");
            locationIntent.nJz = bo.bc(parcel.readString(), "");
            locationIntent.vaP = parcel.readInt();
            locationIntent.fBB = (Addr) parcel.readParcelable(Addr.class.getClassLoader());
            locationIntent.nJB = bo.bc(parcel.readString(), "");
            AppMethodBeat.o(79206);
            return locationIntent;
        }
    };
    public int cED = 0;
    public String eUu = "";
    public Addr fBB = null;
    public String label = "";
    public double lat;
    public double lng;
    public String nJB;
    public String nJz;
    public String vaO = "";
    public int vaP = 0;

    public final String SY() {
        AppMethodBeat.i(79207);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("lat " + this.lat + ";");
        stringBuffer.append("lng " + this.lng + ";");
        stringBuffer.append("scale " + this.cED + ";");
        stringBuffer.append("label " + this.label + ";");
        stringBuffer.append("poiname " + this.eUu + ";");
        stringBuffer.append("infourl " + this.vaO + ";");
        stringBuffer.append("locTypeId " + this.nJz + ";");
        stringBuffer.append("poiType " + this.vaP + ";");
        if (this.fBB != null) {
            stringBuffer.append("addr " + this.fBB.toString() + ";");
        }
        stringBuffer.append("poiid " + this.nJB + ";");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(79207);
        return stringBuffer2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(79208);
        parcel.writeDouble(this.lat);
        parcel.writeDouble(this.lng);
        parcel.writeInt(this.cED);
        parcel.writeString(this.label);
        parcel.writeString(this.eUu);
        parcel.writeString(this.vaO);
        parcel.writeString(this.nJz);
        parcel.writeInt(this.vaP);
        parcel.writeParcelable(this.fBB, i);
        parcel.writeString(this.nJB);
        AppMethodBeat.o(79208);
    }

    static {
        AppMethodBeat.i(79209);
        AppMethodBeat.o(79209);
    }
}
