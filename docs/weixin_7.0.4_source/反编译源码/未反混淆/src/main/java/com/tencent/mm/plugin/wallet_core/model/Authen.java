package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bo;

public class Authen implements Parcelable {
    public static final Creator<Authen> CREATOR = new Creator<Authen>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Authen[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46695);
            Authen authen = new Authen(parcel);
            AppMethodBeat.o(46695);
            return authen;
        }
    };
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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(46696);
        parcel.writeInt(this.bJt);
        parcel.writeString(bo.bc(this.twc, ""));
        parcel.writeString(bo.bc(this.pbn, ""));
        parcel.writeString(bo.bc(this.pbo, ""));
        parcel.writeString(bo.bc(this.twd, ""));
        parcel.writeString(bo.bc(this.twe, ""));
        parcel.writeInt(this.twf);
        parcel.writeString(bo.bc(this.tuk, ""));
        parcel.writeString(bo.bc(this.twg, ""));
        parcel.writeString(bo.bc(this.twh, ""));
        parcel.writeString(bo.bc(this.twi, ""));
        parcel.writeString(bo.bc(this.token, ""));
        parcel.writeString(bo.bc(this.twl, ""));
        parcel.writeString(bo.bc(this.twm, ""));
        parcel.writeString(bo.bc(this.country, ""));
        parcel.writeString(bo.bc(this.duc, ""));
        parcel.writeString(bo.bc(this.dud, ""));
        parcel.writeString(bo.bc(this.fBg, ""));
        parcel.writeString(bo.bc(this.nuN, ""));
        parcel.writeString(bo.bc(this.gIO, ""));
        parcel.writeString(bo.bc(this.dtV, ""));
        parcel.writeString(bo.bc(this.tlk, ""));
        parcel.writeString(bo.bc(this.twn, ""));
        parcel.writeString(bo.bc(this.two, ""));
        parcel.writeString(bo.bc(this.twk, ""));
        parcel.writeString(bo.bc(this.twp, ""));
        parcel.writeString(bo.bc(this.twq, ""));
        parcel.writeString(bo.bc(this.twr, ""));
        parcel.writeString(bo.bc(this.tws, ""));
        parcel.writeString(bo.bc(this.twt, ""));
        parcel.writeInt(bo.a(Integer.valueOf(this.twu), 0));
        parcel.writeString(bo.bc(this.twv, ""));
        parcel.writeString(bo.bc(this.tww, ""));
        AppMethodBeat.o(46696);
    }

    public Authen() {
        AppMethodBeat.i(46697);
        AppMethodBeat.o(46697);
    }

    public Authen(Parcel parcel) {
        AppMethodBeat.i(46698);
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
        AppMethodBeat.o(46698);
    }

    static {
        AppMethodBeat.i(46699);
        AppMethodBeat.o(46699);
    }
}
