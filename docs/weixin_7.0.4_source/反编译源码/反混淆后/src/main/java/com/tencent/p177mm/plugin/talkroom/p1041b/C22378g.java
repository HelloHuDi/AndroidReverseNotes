package com.tencent.p177mm.plugin.talkroom.p1041b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C45575b;
import com.tencent.p177mm.protocal.protobuf.cgn;
import com.tencent.p177mm.protocal.protobuf.cgo;
import com.tencent.p177mm.protocal.protobuf.cgp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.talkroom.b.g */
public final class C22378g extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C22378g(LinkedList<cgn> linkedList, int i) {
        AppMethodBeat.m2504i(25885);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cgo();
        c1196a.fsK = new cgp();
        c1196a.uri = "/cgi-bin/micromsg-bin/talkstatreport";
        c1196a.fsI = C45575b.CTRL_INDEX;
        this.ehh = c1196a.acD();
        cgo cgo = (cgo) this.ehh.fsG.fsP;
        cgo.xfv = linkedList.size();
        cgo.xfw = linkedList;
        cgo.Scene = i;
        AppMethodBeat.m2505o(25885);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25886);
        C4990ab.m7410d("MicroMsg.NetSceneTalkStatReport", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(25886);
        return a;
    }

    public final int getType() {
        return C45575b.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25887);
        C4990ab.m7410d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(25887);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(25887);
    }
}
