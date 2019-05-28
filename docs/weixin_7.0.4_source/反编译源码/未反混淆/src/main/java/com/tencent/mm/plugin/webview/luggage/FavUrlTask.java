package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.sc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class FavUrlTask extends MainProcessTask {
    public static final Creator<FavUrlTask> CREATOR = new Creator<FavUrlTask>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FavUrlTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(5973);
            FavUrlTask favUrlTask = new FavUrlTask(parcel, (byte) 0);
            AppMethodBeat.o(5973);
            return favUrlTask;
        }
    };
    public int actionType;
    public boolean csN;
    public Bundle mqu;
    public int ret;
    public int type;
    public boolean uhJ;
    public boolean uhK;

    /* synthetic */ FavUrlTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void asP() {
        AppMethodBeat.i(5974);
        switch (this.actionType) {
            case 1:
                if (this.mqu != null) {
                    boolean a;
                    long j = this.mqu.getLong("msg_id", Long.MIN_VALUE);
                    String string = this.mqu.getString("sns_local_id");
                    int i = this.mqu.getInt("news_svr_id", 0);
                    String string2 = this.mqu.getString("news_svr_tweetid");
                    cl clVar = new cl();
                    if (Long.MIN_VALUE != j) {
                        clVar.cvA.cvE = this.mqu.getInt("message_index", 0);
                        a = ((ad) g.K(ad.class)).a(clVar, j);
                    } else if (!bo.isNullOrNil(string)) {
                        sc scVar = new sc();
                        scVar.cNZ.cOc = string;
                        scVar.cNZ.cOd = clVar;
                        scVar.cNZ.url = this.mqu.getString("rawUrl");
                        a.xxA.m(scVar);
                        a = scVar.cOa.cvi;
                    } else if (i != 0) {
                        ng ngVar = new ng();
                        ngVar.cJw.opType = 3;
                        ngVar.cJw.cJy = clVar;
                        ngVar.cJw.cJz = i;
                        ngVar.cJw.cJA = string2;
                        a.xxA.m(ngVar);
                        a = ngVar.cJx.cvi;
                    } else {
                        this.uhJ = true;
                        AppMethodBeat.o(5974);
                        return;
                    }
                    if (a) {
                        string = bo.nullAsNil(this.mqu.getString("prePublishId"));
                        String nW = v.nW(string);
                        b y = v.Zp().y(nW, true);
                        y.j("sendAppMsgScene", Integer.valueOf(2));
                        y.j("preChatName", this.mqu.getString("preChatName"));
                        y.j("preMsgIndex", Integer.valueOf(this.mqu.getInt("preMsgIndex")));
                        y.j("prePublishId", string);
                        y.j("preUsername", this.mqu.getString("preUsername"));
                        y.j("getA8KeyScene", this.mqu.getString("getA8KeyScene"));
                        y.j("referUrl", this.mqu.getString("referUrl"));
                        Bundle bundle = this.mqu.getBundle("jsapiargs");
                        if (bundle != null) {
                            y.j("adExtStr", bundle.getString("key_snsad_statextstr"));
                        }
                        clVar.cvA.cvF = nW;
                        a.xxA.m(clVar);
                    } else {
                        if (clVar.cvA.cvG == 0) {
                            clVar.cvA.cvG = R.string.bop;
                        }
                        a.xxA.m(clVar);
                    }
                    this.ret = clVar.cvB.ret;
                }
                AppMethodBeat.o(5974);
                return;
            case 2:
                gh ghVar = new gh();
                ghVar.cAH.type = 35;
                a.xxA.m(ghVar);
                AppMethodBeat.o(5974);
                return;
            case 3:
                this.uhK = d.afj("favorite");
                AppMethodBeat.o(5974);
                return;
            case 4:
                cg cgVar = new cg();
                cgVar.cvt.cvv = this.mqu.getLong("fav_local_id", -1);
                a.xxA.m(cgVar);
                ab.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", Long.valueOf(cgVar.cvt.cvv), Boolean.valueOf(cgVar.cvu.cvi));
                this.csN = cgVar.cvu.cvi;
                break;
        }
        AppMethodBeat.o(5974);
    }

    public final void g(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(5975);
        this.actionType = parcel.readInt();
        this.mqu = parcel.readBundle();
        this.uhJ = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.csN = z;
        this.ret = parcel.readInt();
        this.type = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.uhK = z2;
        AppMethodBeat.o(5975);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(5976);
        parcel.writeInt(this.actionType);
        parcel.writeBundle(this.mqu);
        parcel.writeByte((byte) (this.uhJ ? 1 : 0));
        if (this.csN) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.ret);
        parcel.writeInt(this.type);
        if (!this.uhK) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        AppMethodBeat.o(5976);
    }

    private FavUrlTask(Parcel parcel) {
        AppMethodBeat.i(5977);
        g(parcel);
        AppMethodBeat.o(5977);
    }

    static {
        AppMethodBeat.i(5978);
        AppMethodBeat.o(5978);
    }
}
