package com.tencent.p177mm.plugin.location.model.p1278a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C27057d;
import com.tencent.p177mm.protocal.protobuf.C40592yy;
import com.tencent.p177mm.protocal.protobuf.C46602yz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.location.model.a.a */
public final class C21168a extends C1207m implements C1918k {
    public final C7472b ehh;
    private C1202f ehi;
    private Runnable fPK;

    public C21168a(String str) {
        AppMethodBeat.m2504i(113409);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40592yy();
        c1196a.fsK = new C46602yz();
        c1196a.uri = "/cgi-bin/micromsg-bin/exittrackroom";
        c1196a.fsI = C27057d.CTRL_INDEX;
        this.ehh = c1196a.acD();
        ((C40592yy) this.ehh.fsG.fsP).weu = str;
        C4990ab.m7410d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(113409);
    }

    public final int getType() {
        return C27057d.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(113410);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(113410);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(113411);
        C4990ab.m7411d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (this.fPK != null) {
            this.fPK.run();
        }
        AppMethodBeat.m2505o(113411);
    }
}
