package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aix;
import com.tencent.p177mm.protocal.protobuf.aiy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fav.a.ak */
public final class C34126ak extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;

    public C34126ak() {
        AppMethodBeat.m2504i(102740);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aix();
        c1196a.fsK = new aiy();
        c1196a.uri = "/cgi-bin/micromsg-bin/getfavinfo";
        c1196a.fsI = 438;
        c1196a.fsL = 217;
        c1196a.fsM = 1000000217;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(102740);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(102741);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(102741);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(102742);
        C4990ab.m7410d("MicroMsg.NetSceneGetFavInfo", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            aiy aiy = (aiy) ((C7472b) c1929q).fsH.fsP;
            C4990ab.m7419v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", Long.valueOf(aiy.vEw), Long.valueOf(aiy.jBS), Integer.valueOf(aiy.woT), Integer.valueOf(aiy.woS), Integer.valueOf(aiy.woR));
            C39037b.m66399in(aiy.vEw);
            C39037b.m66400io(aiy.jBS);
            C39037b.m66402iq((long) aiy.woT);
            C39037b.m66403ir((long) aiy.woS);
            C39037b.m66404is((long) aiy.woR);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(102742);
    }

    public final int getType() {
        return 438;
    }
}
