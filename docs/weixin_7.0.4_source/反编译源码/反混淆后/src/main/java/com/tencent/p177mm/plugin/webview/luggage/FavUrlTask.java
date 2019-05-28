package com.tencent.p177mm.plugin.webview.luggage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p230g.p231a.C45346ng;
import com.tencent.p177mm.p230g.p231a.C9306cg;
import com.tencent.p177mm.p230g.p231a.C9465sc;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.fav.p407a.C6893ad;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.FavUrlTask */
public class FavUrlTask extends MainProcessTask {
    public static final Creator<FavUrlTask> CREATOR = new C144611();
    public int actionType;
    public boolean csN;
    public Bundle mqu;
    public int ret;
    public int type;
    public boolean uhJ;
    public boolean uhK;

    /* renamed from: com.tencent.mm.plugin.webview.luggage.FavUrlTask$1 */
    static class C144611 implements Creator<FavUrlTask> {
        C144611() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FavUrlTask[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(5973);
            FavUrlTask favUrlTask = new FavUrlTask(parcel, (byte) 0);
            AppMethodBeat.m2505o(5973);
            return favUrlTask;
        }
    }

    /* synthetic */ FavUrlTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void asP() {
        AppMethodBeat.m2504i(5974);
        switch (this.actionType) {
            case 1:
                if (this.mqu != null) {
                    boolean a;
                    long j = this.mqu.getLong("msg_id", Long.MIN_VALUE);
                    String string = this.mqu.getString("sns_local_id");
                    int i = this.mqu.getInt("news_svr_id", 0);
                    String string2 = this.mqu.getString("news_svr_tweetid");
                    C45316cl c45316cl = new C45316cl();
                    if (Long.MIN_VALUE != j) {
                        c45316cl.cvA.cvE = this.mqu.getInt("message_index", 0);
                        a = ((C6893ad) C1720g.m3528K(C6893ad.class)).mo15153a(c45316cl, j);
                    } else if (!C5046bo.isNullOrNil(string)) {
                        C9465sc c9465sc = new C9465sc();
                        c9465sc.cNZ.cOc = string;
                        c9465sc.cNZ.cOd = c45316cl;
                        c9465sc.cNZ.url = this.mqu.getString("rawUrl");
                        C4879a.xxA.mo10055m(c9465sc);
                        a = c9465sc.cOa.cvi;
                    } else if (i != 0) {
                        C45346ng c45346ng = new C45346ng();
                        c45346ng.cJw.opType = 3;
                        c45346ng.cJw.cJy = c45316cl;
                        c45346ng.cJw.cJz = i;
                        c45346ng.cJw.cJA = string2;
                        C4879a.xxA.mo10055m(c45346ng);
                        a = c45346ng.cJx.cvi;
                    } else {
                        this.uhJ = true;
                        AppMethodBeat.m2505o(5974);
                        return;
                    }
                    if (a) {
                        string = C5046bo.nullAsNil(this.mqu.getString("prePublishId"));
                        String nW = C37922v.m64078nW(string);
                        C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                        y.mo53356j("sendAppMsgScene", Integer.valueOf(2));
                        y.mo53356j("preChatName", this.mqu.getString("preChatName"));
                        y.mo53356j("preMsgIndex", Integer.valueOf(this.mqu.getInt("preMsgIndex")));
                        y.mo53356j("prePublishId", string);
                        y.mo53356j("preUsername", this.mqu.getString("preUsername"));
                        y.mo53356j("getA8KeyScene", this.mqu.getString("getA8KeyScene"));
                        y.mo53356j("referUrl", this.mqu.getString("referUrl"));
                        Bundle bundle = this.mqu.getBundle("jsapiargs");
                        if (bundle != null) {
                            y.mo53356j("adExtStr", bundle.getString("key_snsad_statextstr"));
                        }
                        c45316cl.cvA.cvF = nW;
                        C4879a.xxA.mo10055m(c45316cl);
                    } else {
                        if (c45316cl.cvA.cvG == 0) {
                            c45316cl.cvA.cvG = C25738R.string.bop;
                        }
                        C4879a.xxA.mo10055m(c45316cl);
                    }
                    this.ret = c45316cl.cvB.ret;
                }
                AppMethodBeat.m2505o(5974);
                return;
            case 2:
                C37721gh c37721gh = new C37721gh();
                c37721gh.cAH.type = 35;
                C4879a.xxA.mo10055m(c37721gh);
                AppMethodBeat.m2505o(5974);
                return;
            case 3:
                this.uhK = C25985d.afj("favorite");
                AppMethodBeat.m2505o(5974);
                return;
            case 4:
                C9306cg c9306cg = new C9306cg();
                c9306cg.cvt.cvv = this.mqu.getLong("fav_local_id", -1);
                C4879a.xxA.mo10055m(c9306cg);
                C4990ab.m7417i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", Long.valueOf(c9306cg.cvt.cvv), Boolean.valueOf(c9306cg.cvu.cvi));
                this.csN = c9306cg.cvu.cvi;
                break;
        }
        AppMethodBeat.m2505o(5974);
    }

    /* renamed from: g */
    public final void mo6032g(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(5975);
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
        AppMethodBeat.m2505o(5975);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        AppMethodBeat.m2504i(5976);
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
        AppMethodBeat.m2505o(5976);
    }

    private FavUrlTask(Parcel parcel) {
        AppMethodBeat.m2504i(5977);
        mo6032g(parcel);
        AppMethodBeat.m2505o(5977);
    }

    static {
        AppMethodBeat.m2504i(5978);
        AppMethodBeat.m2505o(5978);
    }
}
