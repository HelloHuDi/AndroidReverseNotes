package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23451ur;
import com.tencent.p177mm.protocal.protobuf.C44175us;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.c */
public final class C28286c extends C44428p {
    private final String TAG = "MicroMsg.NetSceneCreateHoneyPayCard";
    public C44175us nqz;

    public C28286c(String str, long j, String str2, String str3, int i, String str4) {
        AppMethodBeat.m2504i(41721);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23451ur();
        c1196a.fsK = new C44175us();
        c1196a.fsI = 2662;
        c1196a.uri = "/cgi-bin/mmpay-bin/createhoneypaycard";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C23451ur c23451ur = (C23451ur) this.ehh.fsG.fsP;
        c23451ur.wcg = str;
        c23451ur.wch = j;
        c23451ur.vYh = str2;
        c23451ur.vYl = str3;
        c23451ur.iAd = i;
        c23451ur.nSd = str4;
        C4990ab.m7411d("MicroMsg.NetSceneCreateHoneyPayCard", "token: %s, take message: %s, wishing: %s", str, str3, str4);
        C4990ab.m7417i("MicroMsg.NetSceneCreateHoneyPayCard", "username: %s, credit line: %s", str2, Long.valueOf(j));
        AppMethodBeat.m2505o(41721);
    }

    public final int getType() {
        return 2662;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41722);
        C4990ab.m7417i("MicroMsg.NetSceneCreateHoneyPayCard", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqz = (C44175us) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneCreateHoneyPayCard", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqz.kdT), this.nqz.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41722);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        C44175us c44175us = (C44175us) ((C7472b) c1929q).fsH.fsP;
        this.AfC = c44175us.kdT;
        this.AfD = c44175us.kdU;
    }
}
