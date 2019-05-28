package com.tencent.p177mm.plugin.shake.p1019b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.byr;
import com.tencent.p177mm.protocal.protobuf.bys;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.shake.b.b */
public final class C46194b extends C1207m implements C1918k {
    byte[] cQr;
    private final C7472b ehh;
    private C1202f ehi;
    int ret;

    public C46194b(float f, float f2, int i, int i2, String str, String str2) {
        AppMethodBeat.m2504i(24414);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new byr();
        c1196a.fsK = new bys();
        c1196a.uri = "/cgi-bin/micromsg-bin/shakereport";
        this.ehh = c1196a.acD();
        byr byr = (byr) this.ehh.fsG.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", Float.valueOf(f2), Float.valueOf(f));
        byr.OpCode = 0;
        byr.vRp = f;
        byr.vRq = f2;
        byr.wfG = i;
        byr.wfH = str;
        byr.wfI = str2;
        byr.wfJ = i2;
        C9638aw.m17190ZK();
        byr.wYa = C5046bo.m7512a((Integer) C18628c.m29072Ry().get(4107, null), 0);
        C9638aw.m17190ZK();
        int h = C5046bo.m7567h((Integer) C18628c.m29072Ry().get(4106, null));
        byr.wYb = h;
        h++;
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(4106, Integer.valueOf(h));
        byr.vIl = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.bVS());
        C18698o.m29222a(2002, f, f2, i);
        AppMethodBeat.m2505o(24414);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(24415);
        C4990ab.m7410d("MicroMsg.NetSceneShakeReport", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(24415);
        return a;
    }

    public final int getType() {
        return 161;
    }

    public final int cju() {
        return ((byr) this.ehh.fsG.fsP).wfJ;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(24416);
        C4990ab.m7410d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        bys bys = (bys) this.ehh.fsH.fsP;
        this.ret = c1929q.mo5618ZS().vyl;
        if (i2 == 0 && i3 == 0) {
            this.cQr = C1946aa.m4150a(bys.vJd);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(24416);
    }
}
