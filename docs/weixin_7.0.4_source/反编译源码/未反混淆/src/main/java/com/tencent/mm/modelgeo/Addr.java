package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class Addr implements Parcelable {
    public static final Creator<Addr> CREATOR = new Creator<Addr>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Addr[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(78098);
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
            AppMethodBeat.o(78098);
            return addr;
        }
    };
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

    public String toString() {
        AppMethodBeat.i(78099);
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
        AppMethodBeat.o(78099);
        return stringBuilder2;
    }

    public final String agv() {
        AppMethodBeat.i(78100);
        String str = bo.bc(this.fBj, "") + bo.bc(this.fBk, "") + bo.bc(this.fBl, "") + bo.bc(this.fBm, "") + bo.bc(this.fBn, "");
        AppMethodBeat.o(78100);
        return str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(78101);
        parcel.writeString(bo.bc(this.fBg, ""));
        parcel.writeString(bo.bc(this.country, ""));
        parcel.writeString(bo.bc(this.fBh, ""));
        parcel.writeString(bo.bc(this.fBi, ""));
        parcel.writeString(bo.bc(this.fBj, ""));
        parcel.writeString(bo.bc(this.fBk, ""));
        parcel.writeString(bo.bc(this.fBl, ""));
        parcel.writeString(bo.bc(this.fBm, ""));
        parcel.writeString(bo.bc(this.fBn, ""));
        parcel.writeString(bo.bc(this.fBo, ""));
        parcel.writeString(bo.bc(this.fBp, ""));
        parcel.writeFloat(this.fBr);
        parcel.writeFloat(this.fBs);
        AppMethodBeat.o(78101);
    }

    static {
        AppMethodBeat.i(78102);
        AppMethodBeat.o(78102);
    }
}
