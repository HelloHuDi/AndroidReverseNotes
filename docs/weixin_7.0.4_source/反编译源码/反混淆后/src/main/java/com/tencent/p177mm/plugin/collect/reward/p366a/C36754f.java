package com.tencent.p177mm.plugin.collect.reward.p366a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23430pq;
import com.tencent.p177mm.protocal.protobuf.C30214pr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.collect.reward.a.f */
public final class C36754f extends C33863a {
    private final String TAG = "MicroMsg.NetSceneQrRewardScanCode";
    private C7472b ehh;
    private C1202f ehi;
    public C30214pr kDz;

    public C36754f(String str, int i, String str2) {
        AppMethodBeat.m2504i(41045);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23430pq();
        c1196a.fsK = new C30214pr();
        c1196a.fsI = 1516;
        c1196a.uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C23430pq c23430pq = (C23430pq) this.ehh.fsG.fsP;
        c23430pq.kCn = str;
        c23430pq.cIb = i;
        c23430pq.vWN = str2;
        AppMethodBeat.m2505o(41045);
    }

    public final int getType() {
        return 1516;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(41046);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(41046);
        return a;
    }

    /* renamed from: b */
    public final void mo6954b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41047);
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDz = (C30214pr) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDz.kCl), this.kDz.kCm);
        if (!(this.kDr || this.kDz.kCl == 0)) {
            this.kDs = true;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41047);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bgQ() {
        return false;
    }
}
