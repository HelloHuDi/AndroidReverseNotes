package com.tencent.p177mm.plugin.location.model.p1278a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.awl;
import com.tencent.p177mm.protocal.protobuf.awm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.location.model.a.b */
public final class C21169b extends C1207m implements C1918k {
    public String aIm;
    public final C7472b ehh;
    private C1202f ehi;
    public int errCode;
    public int errType;
    private Runnable fPK;
    public String hwA;
    public String nJs = "";

    public C21169b(String str) {
        AppMethodBeat.m2504i(113412);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new awl();
        c1196a.fsK = new awm();
        c1196a.uri = "/cgi-bin/micromsg-bin/jointrackroom";
        c1196a.fsI = 490;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((awl) this.ehh.fsG.fsP).wAT = str;
        C4990ab.m7410d("MicroMsg.NetSceneJoinTrackRoom", "chatNameId:".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(113412);
    }

    public final int getType() {
        return 490;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(113413);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(113413);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        awm awm;
        AppMethodBeat.m2504i(113414);
        this.errType = i2;
        this.errCode = i3;
        this.aIm = str;
        if (((C7472b) c1929q).fsH.fsP != null) {
            awm = (awm) ((C7472b) c1929q).fsH.fsP;
        } else {
            awm = null;
        }
        C4990ab.m7411d("MicroMsg.NetSceneJoinTrackRoom", "onGYNetEnd errType %d errCode%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if ((i3 == 0 || i3 >= 1000) && awm != null) {
            this.nJs = awm.weu;
            C4990ab.m7411d("MicroMsg.NetSceneJoinTrackRoom", "get trackRoomid %s", this.nJs);
        }
        if (awm != null) {
            this.hwA = awm.vKq;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        if (this.fPK != null) {
            this.fPK.run();
        }
        AppMethodBeat.m2505o(113414);
    }
}
