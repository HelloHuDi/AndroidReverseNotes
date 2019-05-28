package com.tencent.p177mm.plugin.shake.p506c.p507a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
import com.tencent.p177mm.protocal.protobuf.byk;
import com.tencent.p177mm.protocal.protobuf.byl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.shake.c.a.c */
public final class C39693c extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    C21829e qsm;

    public C39693c(float f, float f2, int i, String str) {
        AppMethodBeat.m2504i(24514);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new byk();
        c1196a.fsK = new byl();
        c1196a.uri = "/cgi-bin/mmbiz-bin/card/shakecard";
        this.ehh = c1196a.acD();
        byk byk = (byk) this.ehh.fsG.fsP;
        byk.cEB = f2;
        byk.cGm = f;
        byk.scene = i;
        byk.wXH = str;
        AppMethodBeat.m2505o(24514);
    }

    public final int getType() {
        return 1250;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(24515);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(24515);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(24516);
        C4990ab.m7416i("MicroMsg.NetSceneShakeCard", "onGYNetEnd, getType = 1250 errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            byl byl = (byl) this.ehh.fsH.fsP;
            if (byl != null) {
                this.qsm = new C21829e();
                this.qsm.kdC = byl.kdC;
                this.qsm.kbU = byl.kbU;
                this.qsm.cMD = byl.cMD;
                this.qsm.title = byl.title;
                this.qsm.kbW = byl.kbW;
                this.qsm.kbX = byl.kbX;
                this.qsm.kdg = byl.kdg;
                this.qsm.kbV = byl.kbV;
                this.qsm.color = byl.color;
                this.qsm.qsn = byl.qsn;
                this.qsm.qsq = byl.qsq;
                this.qsm.qsr = byl.qsr;
                this.qsm.qss = byl.qss;
                this.qsm.qst = byl.qst;
                this.qsm.qsu = byl.qsu;
                this.qsm.kbZ = byl.kbZ;
                this.qsm.qsv = byl.qsv;
                this.qsm.qsw = byl.qsw;
                C28987m.cjY().qsp = this.qsm.qsu;
            } else {
                this.qsm = new C21829e();
                this.qsm.kdC = 3;
                this.qsm.qsu = C28987m.cjY().qsp;
            }
        } else {
            this.qsm = new C21829e();
            this.qsm.kdC = 3;
            this.qsm.qsu = C28987m.cjY().qsp;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(24516);
    }
}
