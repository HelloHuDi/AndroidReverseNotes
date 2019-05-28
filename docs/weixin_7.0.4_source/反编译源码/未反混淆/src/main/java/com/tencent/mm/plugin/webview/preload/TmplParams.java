package com.tencent.mm.plugin.webview.preload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TmplParams implements Parcelable {
    public static final Creator<TmplParams> CREATOR = new Creator<TmplParams>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TmplParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(80445);
            TmplParams tmplParams = new TmplParams(parcel);
            AppMethodBeat.o(80445);
            return tmplParams;
        }
    };
    public String cvZ;
    public int jSV = -1;
    public String jSY;
    public String jVi;
    public long qOg;
    public String upO;
    public String upP;
    public int upQ;
    public int version;

    public static class a {
        String cWP;
        int upR;
        int upS;
        String upT;
        String upU;
        String upV;
        String upW;
        long upX;
        int upY;

        public final a IW(int i) {
            this.upR = i;
            return this;
        }

        public final a IX(int i) {
            this.upS = i;
            return this;
        }

        public final a aeW(String str) {
            this.upT = str;
            return this;
        }

        public final a aeX(String str) {
            this.upU = str;
            return this;
        }

        public final a aeY(String str) {
            this.cWP = str;
            return this;
        }

        public final a IY(int i) {
            this.upY = i;
            return this;
        }

        public final a lR(long j) {
            this.upX = j;
            return this;
        }

        public final a aeZ(String str) {
            this.upV = str;
            return this;
        }

        public final a afa(String str) {
            this.upW = str;
            return this;
        }

        public final TmplParams cYS() {
            AppMethodBeat.i(80446);
            TmplParams tmplParams = new TmplParams();
            tmplParams.jSV = this.upR;
            tmplParams.version = this.upS;
            tmplParams.jVi = this.upT;
            tmplParams.upO = this.upU;
            tmplParams.cvZ = this.cWP;
            tmplParams.upQ = this.upY;
            tmplParams.qOg = this.upX;
            tmplParams.jSY = this.upV;
            tmplParams.upP = this.upW;
            AppMethodBeat.o(80446);
            return tmplParams;
        }
    }

    public TmplParams(Parcel parcel) {
        AppMethodBeat.i(80447);
        this.jSV = parcel.readInt();
        this.version = parcel.readInt();
        this.jVi = parcel.readString();
        this.upO = parcel.readString();
        this.cvZ = parcel.readString();
        this.upQ = parcel.readInt();
        this.qOg = parcel.readLong();
        this.jSY = parcel.readString();
        this.upP = parcel.readString();
        AppMethodBeat.o(80447);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(80448);
        parcel.writeInt(this.jSV);
        parcel.writeInt(this.version);
        parcel.writeString(this.jVi);
        parcel.writeString(this.upO);
        parcel.writeString(this.cvZ);
        parcel.writeInt(this.upQ);
        parcel.writeLong(this.qOg);
        parcel.writeString(this.jSY);
        parcel.writeString(this.upP);
        AppMethodBeat.o(80448);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(80450);
        AppMethodBeat.o(80450);
    }

    public String toString() {
        AppMethodBeat.i(80449);
        String str = "TmplParams{version=" + this.version + ", initUrl='" + this.jVi + '\'' + ", initFilePath='" + this.upO + '\'' + ", reportId=" + this.upQ + '}';
        AppMethodBeat.o(80449);
        return str;
    }
}
