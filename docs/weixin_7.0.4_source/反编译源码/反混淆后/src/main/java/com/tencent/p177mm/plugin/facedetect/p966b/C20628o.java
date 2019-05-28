package com.tencent.p177mm.plugin.facedetect.p966b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.plugin.facedetect.p966b.C43028j.C43026a;
import com.tencent.p177mm.plugin.facedetect.p966b.C43028j.C43027b;
import com.tencent.p177mm.protocal.protobuf.bdv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.facedetect.b.o */
public final class C20628o extends C27918p implements C1918k, C27916e {
    private final C1929q ftU = new C11790f();
    private boolean lSP = false;
    private String lSU = "";

    public final boolean bsg() {
        return true;
    }

    public final String bsh() {
        return this.lSU;
    }

    public C20628o(long j, String str, String str2) {
        AppMethodBeat.m2504i(88);
        C43026a c43026a = (C43026a) this.ftU.acF();
        c43026a.lSB.wmM = C27918p.lSV;
        c43026a.lSB.wmO = j;
        c43026a.lSB.wTm = str;
        c43026a.lSB.wTn = str2;
        AppMethodBeat.m2505o(88);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final int mo23586g(C1902e c1902e) {
        AppMethodBeat.m2504i(89);
        this.ftU.acF();
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(89);
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
        AppMethodBeat.m2504i(90);
        C4990ab.m7410d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        C43027b c43027b = (C43027b) c1929q.mo5618ZS();
        if (i == 0 && i2 == 0) {
            this.lSP = c43027b.lSC.wTp == 0;
            this.lSU = c43027b.lSC.wTo;
            i2 = c43027b.lSC.wTp;
            String str2 = "MicroMsg.NetSceneFaceRegFaceRsa";
            String str3 = "hy: is verify ok: %b, youtuRet; %d, has random pwd: %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.lSP);
            objArr[1] = Integer.valueOf(c43027b.lSC.wTp);
            if (C5046bo.isNullOrNil(this.lSU)) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            C4990ab.m7417i(str2, str3, objArr);
        } else if (!(c43027b == null || c43027b.lSC == null || c43027b.lSC.wTp == 0)) {
            C4990ab.m7416i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i2 = c43027b.lSC.wTp;
        }
        this.ehi.onSceneEnd(i, i2, str, this);
        AppMethodBeat.m2505o(90);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Lo */
    public final void mo23582Lo(String str) {
        AppMethodBeat.m2504i(91);
        ((C43026a) this.ftU.acF()).lSB.wmM = str;
        AppMethodBeat.m2505o(91);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: g */
    public final bdv mo23587g(C1929q c1929q) {
        AppMethodBeat.m2504i(92);
        bdv bdv = ((C43027b) c1929q.mo5618ZS()).lSC.wmQ;
        AppMethodBeat.m2505o(92);
        return bdv;
    }
}
