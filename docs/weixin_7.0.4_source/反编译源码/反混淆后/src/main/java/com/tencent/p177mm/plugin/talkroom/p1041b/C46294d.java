package com.tencent.p177mm.plugin.talkroom.p1041b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cgh;
import com.tencent.p177mm.protocal.protobuf.cgi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.talkroom.b.d */
public final class C46294d extends C29415f {
    public int actionType;
    private final C7472b ehh;
    private C1202f ehi;
    private final String nNq;
    private int sceneType = 0;
    public int syE;

    public C46294d(int i, long j, int i2, String str, int i3) {
        AppMethodBeat.m2504i(25879);
        this.sceneType = i3;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cgh();
        c1196a.fsK = new cgi();
        c1196a.uri = "/cgi-bin/micromsg-bin/talkmicaction";
        c1196a.fsI = 334;
        c1196a.fsL = 146;
        c1196a.fsM = 1000000146;
        this.ehh = c1196a.acD();
        cgh cgh = (cgh) this.ehh.fsG.fsP;
        cgh.wem = i;
        cgh.wen = j;
        cgh.wkB = i2;
        cgh.vEr = (int) C5046bo.anT();
        this.actionType = i2;
        this.nNq = str;
        cgh.Scene = i3;
        AppMethodBeat.m2505o(25879);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25880);
        C4990ab.m7410d("MicroMsg.NetSceneTalkMicAction", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(25880);
        return a;
    }

    public final int getType() {
        return 334;
    }

    public final String cED() {
        return this.nNq;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25881);
        C4990ab.m7410d("MicroMsg.NetSceneTalkMicAction", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.syE = ((cgi) this.ehh.fsH.fsP).weo;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(25881);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(25881);
    }

    public final int cEE() {
        return this.sceneType;
    }
}
