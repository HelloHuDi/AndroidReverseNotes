package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class MallFunction implements Parcelable {
    public static final Creator<MallFunction> CREATOR = new Creator<MallFunction>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallFunction[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(47003);
            MallFunction mallFunction = new MallFunction(parcel);
            AppMethodBeat.o(47003);
            return mallFunction;
        }
    };
    public String cOI;
    public String cRS;
    public String nmz;
    public String olO;
    public String olP;
    public String pFP;
    public String tDl;
    public ArrayList<String> tDm;
    public MallNews tDn;
    public String tDo;
    public int tDp = 0;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallFunction(Parcel parcel) {
        AppMethodBeat.i(47004);
        this.pFP = parcel.readString();
        this.cOI = parcel.readString();
        this.tDl = parcel.readString();
        this.olO = parcel.readString();
        this.olP = parcel.readString();
        this.cRS = parcel.readString();
        this.nmz = parcel.readString();
        this.tDm = new ArrayList();
        parcel.readStringList(this.tDm);
        this.tDn = (MallNews) parcel.readParcelable(MallNews.class.getClassLoader());
        this.type = parcel.readInt();
        this.tDo = parcel.readString();
        this.tDp = parcel.readInt();
        AppMethodBeat.o(47004);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(47005);
        parcel.writeString(this.pFP);
        parcel.writeString(this.cOI);
        parcel.writeString(this.tDl);
        parcel.writeString(this.olO);
        parcel.writeString(this.olP);
        parcel.writeString(this.cRS);
        parcel.writeString(this.nmz);
        parcel.writeStringList(this.tDm);
        parcel.writeParcelable(this.tDn, i);
        parcel.writeInt(this.type);
        parcel.writeString(this.tDo);
        parcel.writeInt(this.tDp);
        AppMethodBeat.o(47005);
    }

    static {
        AppMethodBeat.i(47006);
        AppMethodBeat.o(47006);
    }
}
