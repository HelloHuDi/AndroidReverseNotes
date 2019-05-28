package com.tencent.p177mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.protocal.protobuf.bpl;
import com.tencent.p177mm.protocal.protobuf.bpm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.address.model.e */
public final class C42320e extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public boolean gIJ;
    public String nickname;
    public String username;

    public C42320e(String str, String str2, int i) {
        AppMethodBeat.m2504i(16734);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bpl();
        c1196a.fsK = new bpm();
        c1196a.uri = "/cgi-bin/micromsg-bin/rcptinfoquery";
        this.ehh = c1196a.acD();
        bpl bpl = (bpl) this.ehh.fsG.fsP;
        bpl.timestamp = 0;
        bpl.wRX = str;
        bpl.csB = str2;
        bpl.scene = i;
        AppMethodBeat.m2505o(16734);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        boolean z = true;
        AppMethodBeat.m2504i(16735);
        C4990ab.m7410d("MicroMsg.NetSceneRcptInfoQuery", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            bpm bpm = (bpm) ((C7472b) c1929q).fsH.fsP;
            this.username = bpm.lCH;
            this.nickname = bpm.wSa;
            if (bpm.wRZ != 1) {
                z = false;
            }
            this.gIJ = z;
            if (bpm.wRK.wRN != null) {
                C4990ab.m7410d("MicroMsg.NetSceneRcptInfoQuery", "resp.rImpl.rcptinfolist.rcptinfolist " + bpm.wRK.wRN.size());
                C33045a.arQ();
                C33045a.arS().mo67844s(bpm.wRK.wRN);
                C33045a.arQ();
                C33045a.arS().arU();
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16735);
    }

    public final int getType() {
        return 417;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16736);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(16736);
        return a;
    }
}
