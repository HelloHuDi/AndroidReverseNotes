package com.tencent.p177mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.model.Authen */
public class Authen implements Parcelable {
    public static final Creator<Authen> CREATOR = new C142311();
    public int bJt;
    public String country;
    public String dtV;
    public String duc;
    public String dud;
    public String fBg;
    public String gIO;
    public String nuN;
    public PayInfo pGr = new PayInfo();
    public String pbn;
    public String pbo;
    public String tlk;
    public String token;
    public String tuk;
    public int twb = 0;
    public String twc;
    public String twd;
    public String twe;
    public int twf;
    public String twg;
    public String twh;
    public String twi;
    public String twj;
    public String twk;
    public String twl;
    public String twm;
    public String twn;
    public String two;
    public String twp;
    public String twq;
    public String twr;
    public String tws;
    public String twt;
    public int twu;
    public String twv;
    public String tww;

    /* renamed from: com.tencent.mm.plugin.wallet_core.model.Authen$1 */
    static class C142311 implements Creator<Authen> {
        C142311() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Authen[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(46695);
            Authen authen = new Authen(parcel);
            AppMethodBeat.m2505o(46695);
            return authen;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(46696);
        parcel.writeInt(this.bJt);
        parcel.writeString(C5046bo.m7532bc(this.twc, ""));
        parcel.writeString(C5046bo.m7532bc(this.pbn, ""));
        parcel.writeString(C5046bo.m7532bc(this.pbo, ""));
        parcel.writeString(C5046bo.m7532bc(this.twd, ""));
        parcel.writeString(C5046bo.m7532bc(this.twe, ""));
        parcel.writeInt(this.twf);
        parcel.writeString(C5046bo.m7532bc(this.tuk, ""));
        parcel.writeString(C5046bo.m7532bc(this.twg, ""));
        parcel.writeString(C5046bo.m7532bc(this.twh, ""));
        parcel.writeString(C5046bo.m7532bc(this.twi, ""));
        parcel.writeString(C5046bo.m7532bc(this.token, ""));
        parcel.writeString(C5046bo.m7532bc(this.twl, ""));
        parcel.writeString(C5046bo.m7532bc(this.twm, ""));
        parcel.writeString(C5046bo.m7532bc(this.country, ""));
        parcel.writeString(C5046bo.m7532bc(this.duc, ""));
        parcel.writeString(C5046bo.m7532bc(this.dud, ""));
        parcel.writeString(C5046bo.m7532bc(this.fBg, ""));
        parcel.writeString(C5046bo.m7532bc(this.nuN, ""));
        parcel.writeString(C5046bo.m7532bc(this.gIO, ""));
        parcel.writeString(C5046bo.m7532bc(this.dtV, ""));
        parcel.writeString(C5046bo.m7532bc(this.tlk, ""));
        parcel.writeString(C5046bo.m7532bc(this.twn, ""));
        parcel.writeString(C5046bo.m7532bc(this.two, ""));
        parcel.writeString(C5046bo.m7532bc(this.twk, ""));
        parcel.writeString(C5046bo.m7532bc(this.twp, ""));
        parcel.writeString(C5046bo.m7532bc(this.twq, ""));
        parcel.writeString(C5046bo.m7532bc(this.twr, ""));
        parcel.writeString(C5046bo.m7532bc(this.tws, ""));
        parcel.writeString(C5046bo.m7532bc(this.twt, ""));
        parcel.writeInt(C5046bo.m7512a(Integer.valueOf(this.twu), 0));
        parcel.writeString(C5046bo.m7532bc(this.twv, ""));
        parcel.writeString(C5046bo.m7532bc(this.tww, ""));
        AppMethodBeat.m2505o(46696);
    }

    public Authen() {
        AppMethodBeat.m2504i(46697);
        AppMethodBeat.m2505o(46697);
    }

    public Authen(Parcel parcel) {
        AppMethodBeat.m2504i(46698);
        this.bJt = parcel.readInt();
        this.twc = parcel.readString();
        this.pbn = parcel.readString();
        this.pbo = parcel.readString();
        this.twd = parcel.readString();
        this.twe = parcel.readString();
        this.twf = parcel.readInt();
        this.tuk = parcel.readString();
        this.twg = parcel.readString();
        this.twh = parcel.readString();
        this.twi = parcel.readString();
        this.token = parcel.readString();
        this.twl = parcel.readString();
        this.twm = parcel.readString();
        this.country = parcel.readString();
        this.duc = parcel.readString();
        this.dud = parcel.readString();
        this.fBg = parcel.readString();
        this.nuN = parcel.readString();
        this.gIO = parcel.readString();
        this.dtV = parcel.readString();
        this.tlk = parcel.readString();
        this.twn = parcel.readString();
        this.two = parcel.readString();
        this.twk = parcel.readString();
        this.twp = parcel.readString();
        this.twq = parcel.readString();
        this.twr = parcel.readString();
        this.tws = parcel.readString();
        this.twt = parcel.readString();
        this.twu = parcel.readInt();
        this.twv = parcel.readString();
        this.tww = parcel.readString();
        AppMethodBeat.m2505o(46698);
    }

    static {
        AppMethodBeat.m2504i(46699);
        AppMethodBeat.m2505o(46699);
    }
}
