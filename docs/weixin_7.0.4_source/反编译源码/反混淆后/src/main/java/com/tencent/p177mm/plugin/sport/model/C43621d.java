package com.tencent.p177mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.sport.p1302a.C46265c;
import com.tencent.p177mm.protocal.protobuf.aom;
import com.tencent.p177mm.protocal.protobuf.aon;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.sport.model.d */
public final class C43621d extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b fAT;
    aom rPr;
    aon rPs;
    private WeakReference<C46265c> rPt;

    public C43621d(long j, long j2, C46265c c46265c) {
        AppMethodBeat.m2504i(93657);
        this.rPt = new WeakReference(c46265c);
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/mmoc-bin/hardware/getsteplist";
        c1196a.fsJ = new aom();
        c1196a.fsK = new aon();
        this.fAT = c1196a.acD();
        this.rPr = (aom) this.fAT.fsG.fsP;
        this.rPr.wdb = (int) (j / 1000);
        this.rPr.wdc = (int) (j2 / 1000);
        AppMethodBeat.m2505o(93657);
    }

    public final int getType() {
        return 1734;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(93658);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(93658);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(93659);
        C4990ab.m7417i("MicroMsg.Sport.NetSceneGetStepList", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.rPs = (aon) this.fAT.fsH.fsP;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(93659);
    }

    public final C46265c cwm() {
        AppMethodBeat.m2504i(138291);
        C46265c c46265c = (C46265c) this.rPt.get();
        AppMethodBeat.m2505o(138291);
        return c46265c;
    }
}
