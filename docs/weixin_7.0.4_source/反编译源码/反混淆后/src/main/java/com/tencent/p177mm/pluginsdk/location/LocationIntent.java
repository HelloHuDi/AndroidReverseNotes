package com.tencent.p177mm.pluginsdk.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelgeo.Addr;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.location.LocationIntent */
public class LocationIntent implements Parcelable {
    public static final Creator<LocationIntent> CREATOR = new C47291();
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

    /* renamed from: com.tencent.mm.pluginsdk.location.LocationIntent$1 */
    static class C47291 implements Creator<LocationIntent> {
        C47291() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocationIntent[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(79206);
            LocationIntent locationIntent = new LocationIntent();
            locationIntent.lat = parcel.readDouble();
            locationIntent.lng = parcel.readDouble();
            locationIntent.cED = parcel.readInt();
            locationIntent.label = parcel.readString();
            locationIntent.eUu = C5046bo.m7532bc(parcel.readString(), "");
            locationIntent.vaO = C5046bo.m7532bc(parcel.readString(), "");
            locationIntent.nJz = C5046bo.m7532bc(parcel.readString(), "");
            locationIntent.vaP = parcel.readInt();
            locationIntent.fBB = (Addr) parcel.readParcelable(Addr.class.getClassLoader());
            locationIntent.nJB = C5046bo.m7532bc(parcel.readString(), "");
            AppMethodBeat.m2505o(79206);
            return locationIntent;
        }
    }

    /* renamed from: SY */
    public final String mo69747SY() {
        AppMethodBeat.m2504i(79207);
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
        AppMethodBeat.m2505o(79207);
        return stringBuffer2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(79208);
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
        AppMethodBeat.m2505o(79208);
    }

    static {
        AppMethodBeat.m2504i(79209);
        AppMethodBeat.m2505o(79209);
    }
}
