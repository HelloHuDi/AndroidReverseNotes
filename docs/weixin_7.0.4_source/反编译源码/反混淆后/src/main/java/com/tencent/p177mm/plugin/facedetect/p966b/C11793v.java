package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.facedetect.p966b.C43025i.C20626a;
import com.tencent.p177mm.plugin.facedetect.p966b.C43025i.C43024b;
import com.tencent.p177mm.protocal.protobuf.bdv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.facedetect.b.v */
public final class C11793v extends C27918p implements C1918k, C39006b {
    private final C1929q ftU = new C20625h();
    private long lTa = -1;
    private byte[] lTb = null;

    public final long bse() {
        return this.lTa;
    }

    public final byte[] bsf() {
        return this.lTb;
    }

    public C11793v(int i, int i2) {
        AppMethodBeat.m2504i(112);
        C20626a c20626a = (C20626a) this.ftU.acF();
        c20626a.lSz.wmM = C27918p.lSV;
        c20626a.lSz.jCt = 1;
        c20626a.lSz.Scene = i;
        c20626a.lSz.wmN = i2;
        AppMethodBeat.m2505o(112);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final int mo23586g(C1902e c1902e) {
        AppMethodBeat.m2504i(113);
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(113);
        return a;
    }

    public final int acn() {
        return 3;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
    }

    public final int getType() {
        return 733;
    }

    /* renamed from: c */
    public final void mo23585c(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(114);
        C4990ab.m7410d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        if (i == 0 && i2 == 0) {
            C43024b c43024b = (C43024b) c1929q.mo5618ZS();
            this.lTa = c43024b.lSA.wmO;
            if (c43024b.lSA.wmP != null) {
                this.lTb = c43024b.lSA.wmP.f1226wR;
            }
            if (c43024b.lSA.wmR != null) {
                byte[] bArr;
                byte[] bArr2;
                if (c43024b.lSA.wmR.vMo == null || c43024b.lSA.wmR.vMo.getILen() <= 0) {
                    bArr = null;
                } else {
                    C4990ab.m7417i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", Integer.valueOf(c43024b.lSA.wmR.vMo.getILen()));
                    bArr = C1946aa.m4150a(c43024b.lSA.wmR.vMo);
                }
                if (c43024b.lSA.wmR.vMp == null || c43024b.lSA.wmR.vMp.getILen() <= 0) {
                    bArr2 = null;
                } else {
                    C4990ab.m7417i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", Integer.valueOf(c43024b.lSA.wmR.vMp.getILen()));
                    bArr2 = C1946aa.m4150a(c43024b.lSA.wmR.vMp);
                }
                C37461f.afy().mo20369a(c43024b.lSA.wmR.vMl, c43024b.lSA.wmR.vMm, c43024b.lSA.wmR.vMn, bArr, bArr2, c43024b.lSA.wmR.vMq);
            }
            String str2 = "MicroMsg.NetSceneGetBioConfigRsa";
            String str3 = "hy: get bio config: bioId: %s, bioConfigSize: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.lTa);
            objArr[1] = Integer.valueOf(this.lTb == null ? 0 : this.lTb.length);
            C4990ab.m7417i(str2, str3, objArr);
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(114);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Lo */
    public final void mo23582Lo(String str) {
        AppMethodBeat.m2504i(115);
        ((C20626a) this.ftU.acF()).lSz.wmM = str;
        AppMethodBeat.m2505o(115);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: g */
    public final bdv mo23587g(C1929q c1929q) {
        AppMethodBeat.m2504i(116);
        bdv bdv = ((C43024b) c1929q.mo5618ZS()).lSA.wmQ;
        AppMethodBeat.m2505o(116);
        return bdv;
    }
}
