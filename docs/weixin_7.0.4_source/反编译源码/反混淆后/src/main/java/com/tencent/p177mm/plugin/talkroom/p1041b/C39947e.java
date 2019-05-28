package com.tencent.p177mm.plugin.talkroom.p1041b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cgj;
import com.tencent.p177mm.protocal.protobuf.cgk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.talkroom.b.e */
public final class C39947e extends C29415f {
    private final C7472b ehh;
    private C1202f ehi;
    private final String nNq;
    private int sceneType = 0;

    public C39947e(String str, int i, long j, int i2) {
        AppMethodBeat.m2504i(25882);
        this.sceneType = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cgj();
        c1196a.fsK = new cgk();
        c1196a.uri = "/cgi-bin/micromsg-bin/talknoop";
        c1196a.fsI = 335;
        c1196a.fsL = 149;
        c1196a.fsM = 1000000149;
        this.ehh = c1196a.acD();
        cgj cgj = (cgj) this.ehh.fsG.fsP;
        cgj.wem = i;
        cgj.wen = j;
        cgj.vEr = (int) C5046bo.anT();
        this.nNq = str;
        cgj.Scene = i2;
        AppMethodBeat.m2505o(25882);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25883);
        C4990ab.m7410d("MicroMsg.NetSceneTalkNoop", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(25883);
        return a;
    }

    public final int getType() {
        return 335;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25884);
        C4990ab.m7410d("MicroMsg.NetSceneTalkNoop", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(25884);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(25884);
    }

    public final String cED() {
        return this.nNq;
    }

    public final int cEE() {
        return this.sceneType;
    }
}
