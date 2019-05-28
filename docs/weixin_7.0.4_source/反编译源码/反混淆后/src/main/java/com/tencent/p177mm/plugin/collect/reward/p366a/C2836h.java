package com.tencent.p177mm.plugin.collect.reward.p366a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C44158ps;
import com.tencent.p177mm.protocal.protobuf.C44159pt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.collect.reward.a.h */
public final class C2836h extends C33863a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetPhotoWord";
    private C7472b ehh;
    private C1202f ehi;
    public String jMS;
    public C44159pt kDB;

    public C2836h(String str) {
        AppMethodBeat.m2504i(41051);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44158ps();
        c1196a.fsK = new C44159pt();
        c1196a.fsI = 1649;
        c1196a.uri = "/cgi-bin/mmpay-bin/setrewardqrcodephotoword";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((C44158ps) this.ehh.fsG.fsP).jMS = str;
        this.jMS = str;
        if (str.length() <= 0 || str.length() > 3) {
            if (str.length() > 3) {
                C7060h.pYm.mo8378a(724, 1, 1, false);
            }
            AppMethodBeat.m2505o(41051);
            return;
        }
        C7060h.pYm.mo8378a(724, 0, 1, false);
        AppMethodBeat.m2505o(41051);
    }

    public final int getType() {
        return 1649;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(41052);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(41052);
        return a;
    }

    /* renamed from: b */
    public final void mo6954b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41053);
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardSetPhotoWord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDB = (C44159pt) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardSetPhotoWord", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDB.kCl), this.kDB.kCm);
        if (!(this.kDr || this.kDB.kCl == 0)) {
            this.kDs = true;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41053);
    }
}
