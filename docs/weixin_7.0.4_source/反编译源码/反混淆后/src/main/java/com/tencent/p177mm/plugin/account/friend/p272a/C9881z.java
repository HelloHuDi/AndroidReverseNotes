package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C7484ax;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.plugin.account.friend.p272a.C1985r.C1986a;
import com.tencent.p177mm.plugin.account.friend.p272a.C1985r.C1987b;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C42475m;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.C40587xv;
import com.tencent.p177mm.protocal.protobuf.bzr;
import com.tencent.p177mm.protocal.protobuf.cfi;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.account.friend.a.z */
public final class C9881z extends C1207m implements C1918k {
    private C1202f ehi;
    public C1929q ftU;
    private int ftx;

    /* renamed from: com.tencent.mm.plugin.account.friend.a.z$a */
    public static class C9882a extends C6297k {
        private C1986a gvZ = new C1986a();
        private C1987b gwa = new C1987b();

        public C9882a() {
            AppMethodBeat.m2504i(108436);
            AppMethodBeat.m2505o(108436);
        }

        public final int getType() {
            return C42475m.CTRL_INDEX;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/emailreg";
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
            return this.gwa;
        }

        /* renamed from: ZR */
        public final C4834d mo14537ZR() {
            return this.gvZ;
        }

        public final int acC() {
            return 1;
        }
    }

    private C9881z(int i, String str, String str2, String str3) {
        AppMethodBeat.m2504i(108437);
        this.ftx = 2;
        this.ftU = new C9882a();
        C1986a c1986a = (C1986a) this.ftU.acF();
        c1986a.gvF.vIJ = i;
        c1986a.gvF.vLe = str;
        c1986a.gvF.luQ = C4988aa.dor();
        c1986a.gvF.vLJ = C5046bo.and(str2);
        c1986a.gvF.wdy = str3;
        C40587xv c40587xv = c1986a.gvF;
        C1720g.m3534RN();
        c40587xv.vIj = C1668a.m3397Rb();
        c1986a.gvF.wdz = C1427q.getSimCountryIso();
        c1986a.gvF.wdA = 1;
        AppMethodBeat.m2505o(108437);
    }

    public C9881z(String str, String str2, String str3) {
        this(2, str, str2, str3);
    }

    public C9881z(String str, String str2) {
        this(1, str, str2, "");
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108438);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(108438);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108439);
        C4990ab.m7417i("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:%d errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        C1987b c1987b = (C1987b) c1929q.mo5618ZS();
        if (i2 == 4 && i3 == -301) {
            C7484ax.m12918a(true, c1987b.gvG.vLL, c1987b.gvG.vLM, c1987b.gvG.vLK);
            this.ftx--;
            if (this.ftx <= 0) {
                this.ehi.onSceneEnd(3, -1, "", this);
                AppMethodBeat.m2505o(108439);
                return;
            }
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(108439);
        } else if (i2 == 0 && i3 == 0) {
            C7484ax.m12918a(false, c1987b.gvG.vLL, c1987b.gvG.vLM, c1987b.gvG.vLK);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(108439);
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneEmailReg", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(108439);
        }
    }

    public final int acn() {
        return 5;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int ajx() {
        int i;
        AppMethodBeat.m2504i(108440);
        bzr bzr = ((C1987b) this.ftU.mo5618ZS()).gvG.vHR;
        if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
            Iterator it = bzr.wYM.iterator();
            while (it.hasNext()) {
                cfi cfi = (cfi) it.next();
                if (cfi.pXC == 1) {
                    i = C5046bo.getInt(cfi.xeN, 0);
                    break;
                }
            }
        }
        i = 0;
        AppMethodBeat.m2505o(108440);
        return i;
    }

    public final int getType() {
        return C42475m.CTRL_INDEX;
    }
}
