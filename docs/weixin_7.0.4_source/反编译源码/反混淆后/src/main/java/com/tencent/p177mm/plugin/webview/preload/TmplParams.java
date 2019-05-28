package com.tencent.p177mm.plugin.webview.preload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.webview.preload.TmplParams */
public class TmplParams implements Parcelable {
    public static final Creator<TmplParams> CREATOR = new C45591();
    public String cvZ;
    public int jSV = -1;
    public String jSY;
    public String jVi;
    public long qOg;
    public String upO;
    public String upP;
    public int upQ;
    public int version;

    /* renamed from: com.tencent.mm.plugin.webview.preload.TmplParams$1 */
    static class C45591 implements Creator<TmplParams> {
        C45591() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new TmplParams[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(80445);
            TmplParams tmplParams = new TmplParams(parcel);
            AppMethodBeat.m2505o(80445);
            return tmplParams;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.preload.TmplParams$a */
    public static class C29850a {
        String cWP;
        int upR;
        int upS;
        String upT;
        String upU;
        String upV;
        String upW;
        long upX;
        int upY;

        /* renamed from: IW */
        public final C29850a mo48063IW(int i) {
            this.upR = i;
            return this;
        }

        /* renamed from: IX */
        public final C29850a mo48064IX(int i) {
            this.upS = i;
            return this;
        }

        public final C29850a aeW(String str) {
            this.upT = str;
            return this;
        }

        public final C29850a aeX(String str) {
            this.upU = str;
            return this;
        }

        public final C29850a aeY(String str) {
            this.cWP = str;
            return this;
        }

        /* renamed from: IY */
        public final C29850a mo48065IY(int i) {
            this.upY = i;
            return this;
        }

        /* renamed from: lR */
        public final C29850a mo48072lR(long j) {
            this.upX = j;
            return this;
        }

        public final C29850a aeZ(String str) {
            this.upV = str;
            return this;
        }

        public final C29850a afa(String str) {
            this.upW = str;
            return this;
        }

        public final TmplParams cYS() {
            AppMethodBeat.m2504i(80446);
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
            AppMethodBeat.m2505o(80446);
            return tmplParams;
        }
    }

    public TmplParams(Parcel parcel) {
        AppMethodBeat.m2504i(80447);
        this.jSV = parcel.readInt();
        this.version = parcel.readInt();
        this.jVi = parcel.readString();
        this.upO = parcel.readString();
        this.cvZ = parcel.readString();
        this.upQ = parcel.readInt();
        this.qOg = parcel.readLong();
        this.jSY = parcel.readString();
        this.upP = parcel.readString();
        AppMethodBeat.m2505o(80447);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(80448);
        parcel.writeInt(this.jSV);
        parcel.writeInt(this.version);
        parcel.writeString(this.jVi);
        parcel.writeString(this.upO);
        parcel.writeString(this.cvZ);
        parcel.writeInt(this.upQ);
        parcel.writeLong(this.qOg);
        parcel.writeString(this.jSY);
        parcel.writeString(this.upP);
        AppMethodBeat.m2505o(80448);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(80450);
        AppMethodBeat.m2505o(80450);
    }

    public String toString() {
        AppMethodBeat.m2504i(80449);
        String str = "TmplParams{version=" + this.version + ", initUrl='" + this.jVi + '\'' + ", initFilePath='" + this.upO + '\'' + ", reportId=" + this.upQ + '}';
        AppMethodBeat.m2505o(80449);
        return str;
    }
}
