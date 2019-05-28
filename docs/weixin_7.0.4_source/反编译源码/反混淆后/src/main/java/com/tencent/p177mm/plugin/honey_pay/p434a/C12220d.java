package com.tencent.p177mm.plugin.honey_pay.p434a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.ahv;
import com.tencent.p177mm.protocal.protobuf.ahw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.honey_pay.a.d */
public final class C12220d extends C44428p {
    private final String TAG = "MicroMsg.NetSceneGetCreateTokenSign";
    public ahw nqA;

    public C12220d(String str, long j) {
        AppMethodBeat.m2504i(41723);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ahv();
        c1196a.fsK = new ahw();
        c1196a.fsI = 2630;
        c1196a.uri = "/cgi-bin/mmpay-bin/createhpcardtoken";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ahv ahv = (ahv) this.ehh.fsG.fsP;
        ahv.vYl = str;
        ahv.wch = j;
        ahv.woh = C22594k.bQO();
        C4990ab.m7417i("MicroMsg.NetSceneGetCreateTokenSign", "take_message: %s, credit_line: %s", str, Long.valueOf(j));
        AppMethodBeat.m2505o(41723);
    }

    public final int getType() {
        return 2630;
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41724);
        C4990ab.m7417i("MicroMsg.NetSceneGetCreateTokenSign", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.nqA = (ahw) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneGetCreateTokenSign", "retcode: %s, retmsg: %s", Integer.valueOf(this.nqA.kdT), this.nqA.kdU);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41724);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        ahw ahw = (ahw) ((C7472b) c1929q).fsH.fsP;
        this.AfC = ahw.kdT;
        this.AfD = ahw.kdU;
    }
}
