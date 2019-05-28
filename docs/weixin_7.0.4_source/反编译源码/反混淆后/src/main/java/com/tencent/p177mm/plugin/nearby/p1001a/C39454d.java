package com.tencent.p177mm.plugin.nearby.p1001a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aye;
import com.tencent.p177mm.protocal.protobuf.ayf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.nearby.a.d */
public final class C39454d extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    public String gfa;
    public String oPy;

    public C39454d(float f, float f2, int i, String str, String str2) {
        AppMethodBeat.m2504i(55367);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aye();
        c1196a.fsK = new ayf();
        c1196a.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        this.ehh = c1196a.acD();
        aye aye = (aye) this.ehh.fsG.fsP;
        aye.OpCode = 1;
        aye.vRp = f;
        aye.vRq = f2;
        aye.wfG = i;
        aye.wfH = str;
        aye.wfI = str2;
        aye.wfJ = 0;
        C4990ab.m7410d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + f + " lat:" + f2 + " pre:" + i + " gpsSource:0 mac" + str + " cell:" + str2);
        AppMethodBeat.m2505o(55367);
    }

    public C39454d(String str, int i, int i2) {
        AppMethodBeat.m2504i(55368);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aye();
        c1196a.fsK = new ayf();
        c1196a.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        this.ehh = c1196a.acD();
        aye aye = (aye) this.ehh.fsG.fsP;
        aye.vRp = 0.0f;
        aye.vRq = 0.0f;
        aye.wfG = 0;
        aye.wfJ = 0;
        aye.wfH = "";
        aye.wfI = "";
        aye.OpCode = 2;
        aye.fLc = str;
        aye.wCk = i;
        aye.wCj = i2;
        AppMethodBeat.m2505o(55368);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(55369);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(55369);
        return a;
    }

    public final int getType() {
        return 376;
    }

    /* renamed from: Ah */
    public final int mo62404Ah() {
        return ((aye) this.ehh.fsG.fsP).OpCode;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(55370);
        C4990ab.m7410d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " opCode:" + mo62404Ah());
        ayf ayf = (ayf) ((C7472b) c1929q).fsH.fsP;
        if (i2 != 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(55370);
        } else if (mo62404Ah() == 1) {
            this.gfa = ayf.fLc;
            this.oPy = ayf.wCl;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(55370);
        } else {
            if (mo62404Ah() == 2) {
                C43333b.m77311TA(((aye) ((C7472b) c1929q).fsG.fsP).fLc);
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.m2505o(55370);
        }
    }
}
