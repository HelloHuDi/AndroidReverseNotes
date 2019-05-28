package com.tencent.p177mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.cvd;
import com.tencent.p177mm.protocal.protobuf.cve;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.websearch.api.t */
public final class C40194t extends C7197a implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private C22760s fpL;

    public C40194t(C22760s c22760s) {
        boolean z = true;
        AppMethodBeat.m2504i(124061);
        this.fpL = c22760s;
        this.tZu = c22760s.ctj;
        this.f1969Lp = c22760s.offset;
        this.gOW = c22760s.scene;
        this.tZt = c22760s.cIv;
        this.fpL = c22760s;
        this.tZv = c22760s.tZN;
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        c1196a.fsJ = new cvd();
        c1196a.fsK = new cve();
        this.ehh = c1196a.acD();
        cvd cvd = (cvd) this.ehh.fsG.fsP;
        cvd.vOq = c22760s.offset;
        cvd.wDH = C46400aa.m87305HV(1);
        cvd.wUr = c22760s.tZw;
        cvd.wkD = c22760s.ctj;
        cvd.wDI = C46400aa.abJ();
        cvd.Scene = c22760s.scene;
        cvd.vQg = c22760s.lcA;
        cvd.xrc = c22760s.cIC;
        cvd.wCv = c22760s.tZC;
        cvd.xfr = c22760s.cdf;
        cvd.xrd = c22760s.tZP;
        C23447tn c23447tn = new C23447tn();
        c23447tn.key = "client_system_version";
        c23447tn.waD = (long) VERSION.SDK_INT;
        c22760s.tZG.add(c23447tn);
        cvd.xqa = c22760s.tZG;
        cvd.wCy = c22760s.cvF;
        this.cIz = c22760s.nQB;
        if (c22760s.tZQ) {
            int i = c22760s.scene;
            String str = c22760s.cvF;
            String str2 = c22760s.cIy;
            String str3 = c22760s.lcA;
            int i2 = c22760s.offset;
            if (c22760s.tZw != 1) {
                z = false;
            }
            C29744z.m47157a(i, str, str2, str3, i2, z, c22760s.nQB, c22760s.ctj, c22760s.businessType, c22760s.tZM);
        }
        AppMethodBeat.m2505o(124061);
    }

    public final int getType() {
        return 1943;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(124062);
        C14423an.reportIdKey649ForLook(this.gOW, 2);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(124062);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(124063);
        C4990ab.m7417i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        boolean z = i2 == 0 && i3 == 0;
        if (this.fpL.tZQ) {
            C29744z.m47159a(this.fpL.scene, this.fpL.cvF, this.fpL.cIy, this.fpL.lcA, this.fpL.offset, this.fpL.tZw == 1, this.fpL.nQB, z, this.fpL.ctj, this.fpL.businessType, this.fpL.tZM);
        }
        if (i3 == -1) {
            C14423an.reportIdKey649ForLook(this.gOW, 4);
        } else if (i2 == 0 && i3 == 0) {
            C14423an.reportIdKey649ForLook(this.gOW, 3);
        } else {
            C14423an.reportIdKey649ForLook(this.gOW, 8);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(124063);
    }

    private cve cUW() {
        return (cve) this.ehh.fsH.fsP;
    }

    public final String abH() {
        AppMethodBeat.m2504i(124064);
        String str;
        if (cUW() != null) {
            str = cUW().vOy;
            AppMethodBeat.m2505o(124064);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(124064);
        return str;
    }

    public final int abI() {
        AppMethodBeat.m2504i(124065);
        if (cUW() != null) {
            int i = cUW().wCB;
            AppMethodBeat.m2505o(124065);
            return i;
        }
        AppMethodBeat.m2505o(124065);
        return 0;
    }
}
