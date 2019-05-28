package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.plugin.facedetect.p966b.C43029k.C27917b;
import com.tencent.p177mm.plugin.facedetect.p966b.C43029k.C39008a;
import com.tencent.p177mm.protocal.protobuf.bdv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.facedetect.b.t */
public final class C39009t extends C27918p implements C1918k, C27916e {
    private final C1929q ftU = new C20624g();
    private boolean lSP = false;
    private String lSU = "";

    public final boolean bsg() {
        return true;
    }

    public final String bsh() {
        return this.lSU;
    }

    public C39009t(long j, String str, String str2) {
        AppMethodBeat.m2504i(104);
        C39008a c39008a = (C39008a) this.ftU.acF();
        c39008a.lSD.wmM = C27918p.lSV;
        c39008a.lSD.wmO = j;
        c39008a.lSD.wTn = str2;
        c39008a.lSD.wTm = str;
        AppMethodBeat.m2505o(104);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final int mo23586g(C1902e c1902e) {
        AppMethodBeat.m2504i(105);
        this.ftU.acF();
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(105);
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
        return 930;
    }

    /* renamed from: c */
    public final void mo23585c(int i, int i2, String str, C1929q c1929q) {
        boolean z = true;
        AppMethodBeat.m2504i(106);
        C4990ab.m7410d("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        C27917b c27917b = (C27917b) c1929q.mo5618ZS();
        if (i == 0 && i2 == 0) {
            this.lSP = c27917b.lSE.wTp == 0;
            this.lSU = c27917b.lSE.wTo;
            String str2 = "MicroMsg.NetSceneFaceVerifyFaceRsa";
            String str3 = "hy: is verify ok: %b, youtuRet: %d, has random pwd: %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.lSP);
            objArr[1] = Integer.valueOf(c27917b.lSE.wTp);
            if (C5046bo.isNullOrNil(this.lSU)) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            C4990ab.m7417i(str2, str3, objArr);
            i2 = c27917b.lSE.wTp;
        } else if (!(c27917b == null || c27917b.lSE == null || c27917b.lSE.wTp == 0)) {
            C4990ab.m7416i("MicroMsg.NetSceneFaceVerifyFaceRsa", "hy: has detail ret. use");
            i2 = c27917b.lSE.wTp;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(106);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Lo */
    public final void mo23582Lo(String str) {
        AppMethodBeat.m2504i(107);
        ((C39008a) this.ftU.acF()).lSD.wmM = str;
        AppMethodBeat.m2505o(107);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: g */
    public final bdv mo23587g(C1929q c1929q) {
        AppMethodBeat.m2504i(108);
        bdv bdv = ((C27917b) c1929q.mo5618ZS()).lSE.wmQ;
        AppMethodBeat.m2505o(108);
        return bdv;
    }
}
