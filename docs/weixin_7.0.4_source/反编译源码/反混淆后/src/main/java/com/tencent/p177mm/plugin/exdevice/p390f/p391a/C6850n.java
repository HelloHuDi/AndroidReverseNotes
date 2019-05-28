package com.tencent.p177mm.plugin.exdevice.p390f.p391a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.cjv;
import com.tencent.p177mm.protocal.protobuf.cjw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.exdevice.f.a.n */
public final class C6850n extends C1207m implements C1918k {
    private C7472b ehh = null;
    private C1202f ehi = null;
    public int lwc;
    public int lwd;
    public int opType;

    public C6850n(int i, int i2) {
        AppMethodBeat.m2504i(19472);
        this.opType = i;
        this.lwc = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cjv();
        c1196a.fsK = new cjw();
        c1196a.uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
        c1196a.fsI = FilterEnum4Shaka.MIC_SHAKA_ADD2_9;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        cjv cjv = (cjv) this.ehh.fsG.fsP;
        cjv.cKJ = this.opType;
        cjv.bJt = this.lwc;
        AppMethodBeat.m2505o(19472);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_SHAKA_ADD2_9;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(19473);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(19473);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(19474);
        C4990ab.m7411d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.lwd = ((cjw) this.ehh.fsH.fsP).bJt;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(19474);
    }
}
