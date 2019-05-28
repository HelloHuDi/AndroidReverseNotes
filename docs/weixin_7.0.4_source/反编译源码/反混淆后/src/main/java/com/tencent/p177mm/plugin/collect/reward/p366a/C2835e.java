package com.tencent.p177mm.plugin.collect.reward.p366a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23428po;
import com.tencent.p177mm.protocal.protobuf.C23429pp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.collect.reward.a.e */
public final class C2835e extends C33863a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    private C7472b ehh;
    private C1202f ehi;
    public C23429pp kDy;

    public C2835e(int i, int i2, String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7, String str8, int i4) {
        AppMethodBeat.m2504i(41042);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23428po();
        c1196a.fsK = new C23429pp();
        c1196a.fsI = 1336;
        c1196a.uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C23428po c23428po = (C23428po) this.ehh.fsG.fsP;
        c23428po.nUf = i;
        c23428po.vWL = i2;
        c23428po.vWJ = str;
        c23428po.vWK = str2;
        c23428po.pPT = str3;
        c23428po.cIb = i3;
        c23428po.vWM = str4;
        c23428po.vWG = str5;
        c23428po.vWN = str6;
        c23428po.vWO = str7;
        c23428po.vWP = str8;
        c23428po.vWQ = i4;
        AppMethodBeat.m2505o(41042);
    }

    public final int getType() {
        return 1336;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(41043);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(41043);
        return a;
    }

    /* renamed from: b */
    public final void mo6954b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41044);
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.kDy = (C23429pp) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDy.kCl), this.kDy.kCm);
        if (!(this.kDr || this.kDy.kCl == 0)) {
            this.kDs = true;
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41044);
    }
}
