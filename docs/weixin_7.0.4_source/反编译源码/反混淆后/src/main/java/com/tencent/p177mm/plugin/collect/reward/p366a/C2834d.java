package com.tencent.p177mm.plugin.collect.reward.p366a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40559pn;
import com.tencent.p177mm.protocal.protobuf.C44157pm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.collect.reward.a.d */
public final class C2834d extends C33863a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    private C7472b ehh;
    private C1202f ehi;
    private C40559pn kDx;

    public C2834d(String str, String str2, String str3, int i, String str4, String str5) {
        AppMethodBeat.m2504i(41039);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44157pm();
        c1196a.fsK = new C40559pn();
        c1196a.fsI = 1960;
        c1196a.uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C44157pm c44157pm = (C44157pm) this.ehh.fsG.fsP;
        c44157pm.cBT = str;
        c44157pm.vWI = str2;
        c44157pm.vFc = str3;
        c44157pm.nUf = i;
        c44157pm.vWG = str4;
        c44157pm.vWF = str5;
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", str2, Integer.valueOf(i));
        AppMethodBeat.m2505o(41039);
    }

    public final int getType() {
        return 1960;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(41040);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(41040);
        return a;
    }

    /* renamed from: b */
    public final void mo6954b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41041);
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDx = (C40559pn) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDx.kCl), this.kDx.kCm);
        if (!(this.kDr || this.kDx.kCl == 0)) {
            this.kDs = true;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41041);
    }
}
