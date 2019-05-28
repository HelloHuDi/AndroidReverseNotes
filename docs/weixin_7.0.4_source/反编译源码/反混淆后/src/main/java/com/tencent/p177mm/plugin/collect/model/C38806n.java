package com.tencent.p177mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.protocal.protobuf.C23427pi;
import com.tencent.p177mm.protocal.protobuf.C44154pj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.collect.model.n */
public final class C38806n extends C1207m implements C1918k {
    private final String TAG = "MicroMsg.NetSceneMDRcvVoice";
    public String cva;
    private C7472b ehh;
    private C1202f ehi;
    public C44154pj kCB;

    public C38806n(int i, C1332b c1332b, String str) {
        AppMethodBeat.m2504i(40983);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23427pi();
        c1196a.fsK = new C44154pj();
        c1196a.fsI = 1317;
        c1196a.uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C23427pi c23427pi = (C23427pi) this.ehh.fsG.fsP;
        c23427pi.nUf = i;
        c23427pi.vWi = 0;
        c23427pi.kCK = str;
        c23427pi.vWg = null;
        c23427pi.vWh = c1332b;
        this.cva = str;
        C4990ab.m7417i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", Integer.valueOf(i), str);
        AppMethodBeat.m2505o(40983);
    }

    public final int getType() {
        return 1317;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(40984);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(40984);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(40985);
        C4990ab.m7417i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.kCB = (C44154pj) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", Integer.valueOf(this.kCB.kCl), this.kCB.kCm, Integer.valueOf(this.kCB.vWi));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(40985);
    }
}
