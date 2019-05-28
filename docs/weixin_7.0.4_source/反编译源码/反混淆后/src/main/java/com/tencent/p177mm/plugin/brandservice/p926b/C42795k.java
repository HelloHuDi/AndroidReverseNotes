package com.tencent.p177mm.plugin.brandservice.p926b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.azo;
import com.tencent.p177mm.protocal.protobuf.azr;
import com.tencent.p177mm.protocal.protobuf.azs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.b.k */
public final class C42795k extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C42795k(String str, LinkedList<azo> linkedList) {
        AppMethodBeat.m2504i(13855);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new azr();
        c1196a.fsK = new azs();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
        this.ehh = c1196a.acD();
        azr azr = (azr) this.ehh.fsG.fsP;
        azr.wxX = str;
        azr.wDy = linkedList;
        AppMethodBeat.m2505o(13855);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13856);
        C4990ab.m7411d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(13856);
    }

    public final int getType() {
        return 1030;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13857);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(13857);
        return a;
    }
}
