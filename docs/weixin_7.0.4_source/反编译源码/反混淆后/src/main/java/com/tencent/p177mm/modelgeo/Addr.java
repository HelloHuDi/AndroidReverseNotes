package com.tencent.p177mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelgeo.Addr */
public class Addr implements Parcelable {
    public static final Creator<Addr> CREATOR = new C186551();
    public String country;
    public String fBg;
    public String fBh;
    public String fBi;
    public String fBj;
    public String fBk;
    public String fBl;
    public String fBm;
    public String fBn;
    public String fBo;
    public String fBp;
    public String fBq;
    public float fBr;
    public float fBs;
    public Object tag = "";

    /* renamed from: com.tencent.mm.modelgeo.Addr$1 */
    static class C186551 implements Creator<Addr> {
        C186551() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Addr[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(78098);
            Addr addr = new Addr();
            addr.fBg = parcel.readString();
            addr.country = parcel.readString();
            addr.fBh = parcel.readString();
            addr.fBi = parcel.readString();
            addr.fBj = parcel.readString();
            addr.fBk = parcel.readString();
            addr.fBl = parcel.readString();
            addr.fBm = parcel.readString();
            addr.fBn = parcel.readString();
            addr.fBo = parcel.readString();
            addr.fBp = parcel.readString();
            addr.fBr = parcel.readFloat();
            addr.fBs = parcel.readFloat();
            AppMethodBeat.m2505o(78098);
            return addr;
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(78099);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("address='" + this.fBg + '\'');
        stringBuilder.append(", country='" + this.country + '\'');
        stringBuilder.append(", administrative_area_level_1='" + this.fBh + '\'');
        stringBuilder.append(", locality='" + this.fBi + '\'');
        stringBuilder.append(", locality_shi='" + this.fBj + '\'');
        stringBuilder.append(", sublocality='" + this.fBk + '\'');
        stringBuilder.append(", neighborhood='" + this.fBl + '\'');
        stringBuilder.append(", route='" + this.fBm + '\'');
        stringBuilder.append(", streetNum='" + this.fBn + '\'');
        stringBuilder.append(", roughAddr='" + this.fBo + '\'');
        stringBuilder.append(", poi_name='" + this.fBp + '\'');
        stringBuilder.append(", lat=" + this.fBr);
        stringBuilder.append(", lng=" + this.fBs);
        stringBuilder.append(", tag=" + this.tag);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(78099);
        return stringBuilder2;
    }

    public final String agv() {
        AppMethodBeat.m2504i(78100);
        String str = C5046bo.m7532bc(this.fBj, "") + C5046bo.m7532bc(this.fBk, "") + C5046bo.m7532bc(this.fBl, "") + C5046bo.m7532bc(this.fBm, "") + C5046bo.m7532bc(this.fBn, "");
        AppMethodBeat.m2505o(78100);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(78101);
        parcel.writeString(C5046bo.m7532bc(this.fBg, ""));
        parcel.writeString(C5046bo.m7532bc(this.country, ""));
        parcel.writeString(C5046bo.m7532bc(this.fBh, ""));
        parcel.writeString(C5046bo.m7532bc(this.fBi, ""));
        parcel.writeString(C5046bo.m7532bc(this.fBj, ""));
        parcel.writeString(C5046bo.m7532bc(this.fBk, ""));
        parcel.writeString(C5046bo.m7532bc(this.fBl, ""));
        parcel.writeString(C5046bo.m7532bc(this.fBm, ""));
        parcel.writeString(C5046bo.m7532bc(this.fBn, ""));
        parcel.writeString(C5046bo.m7532bc(this.fBo, ""));
        parcel.writeString(C5046bo.m7532bc(this.fBp, ""));
        parcel.writeFloat(this.fBr);
        parcel.writeFloat(this.fBs);
        AppMethodBeat.m2505o(78101);
    }

    static {
        AppMethodBeat.m2504i(78102);
        AppMethodBeat.m2505o(78102);
    }
}
